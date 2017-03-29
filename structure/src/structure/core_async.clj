(ns structure.core-async
  (:require [clojure.core.async :as a :refer [go <!! <! >! go-loop >!! timeout close! chan alts!!]]))

;; Create a channel - like a communications channel to another thread / process
(def ch (chan 1))

;; Do some basic comms:

;; Put on the channel
(>!! ch "hello") => ;; true

;; Take off the channel
(<!! ch) ;; => "hello"

;; If you take off when theres nothing there, it blocks
(<!! ch)

;; If you CTRL+C its still running so when you do
(>!! ch "hello")

;; The previous take gets that value, so you have to do it again if you want it to work...
(>!! ch "hello")
(<!! ch)

;; Now we can do something more asynchronous:
(go (let [value (<! ch)] (println "got a value from channel: " value)))

(>!! ch "hello")

;; Notice if you do this again, you don't see the output - because the async call finished, but you can run it again...

(go (let [value (<! ch)] (println "got a value from channel: " value)))

;; Also notice that go returns a channel itself. This is how it communicates back whatever is the result of the block:

;; Notice that this might end up just printing over your prompt in the repl so it looks like the repl is hanging but its not, just press <RETURN>
(def rc (go (do (println "hello") true)))

(<!! rc) ;; =>true

;; Of course that block could also be a function:

(defn say-hello []
  "Hello from a function")

(def rc (go (say-hello)))

(<!! rc) ;; => "Hello from a function"


;; Create a function that takes a value off the channel and prints it out:
(defn take-and-print [channel]
  (let [value (<!! channel)]
    (println "got a value from channel: " value)))

;; Try it out - first put a value on the channel:
(>!! ch "hello")

;; Then try our function
(take-and-print ch)


(defn consume-channel [channel handler]
  "Will block on a channel until a message is recieved or the channel is closed at which point it will return 'finished' The blocking take
   (<!) function wil return nil when the channel is closed."
  (go
    (while (handler (<! channel)))
    "finished"))

(defn handle-message [message]
  (if (nil? message)
    false
    (do
      (println "Message recieved: " message)
      true)))

(def ch (chan 1))

(def rc (consume-channel ch handle-message))

(>!! ch {:a "foo"})
(>!! ch {:a "foo"})

(close! ch)

(<!! rc)

;; TODO
;; - ALTS! and ALT!
