(ns structure.execute-test
  (:use clojure.test
        midje.sweet
        structure.execute))

(defn print-something
  "Prints something out"
  []
  (println "something"))



(defn add-up
  "Adds two numbers"
  [a b]
  (+ a b))



(fact "Describes and then executes a function"
      (with-out-str (exedoc print-something))
         => #"(.*)example(.*)something(.*)")







