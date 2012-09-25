(ns structure.execute-test
  (:use clojure.test
        structure.execute))

(defn add-up
  "Adds two numbers"
  [a b]
  (+ a b))

(deftest no-arg-function
  (testing "Can call a no-arg function"
    (is (= 4 (add-up 2 2)))))