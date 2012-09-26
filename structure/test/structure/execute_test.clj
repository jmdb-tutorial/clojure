(ns structure.execute-test
  (:use clojure.test
        midje.sweet
        structure.execute))

(defn add-up
  "Adds two numbers"
  [a b]
  (+ a b))

(fact "Can call a no-arg function"
      (add-up 2 2) => 4)

(fact "this should fail"
      (+ 1 2) => 3)