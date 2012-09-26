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

(fact "Can call a no-arg function"
      (with-out-str (print-something)) => (contains "something"))





