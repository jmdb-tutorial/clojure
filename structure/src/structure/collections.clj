(ns structure.collections
  "Contains demonstrations of various ways to work with collections of things"
  (:require [clojure.math.numeric-tower]))

;; Create a list of numbers
(def zero2ten (range 0 11))

;; Iterate over a collection to calculate some aggregate (e.g. sum)
(reduce + zero2ten) ;; => 55

;; Equivalent to:
(+ 1 2 3 4 5 6 7 8 9 10) ;; => 55


;; Iterate over a collection and return a collection of results
(map (fn[i] (* 2 i)) [1 2 3]) ;; => (2 4 6)

(defn power [i]
  ())


;; Iterate over a collection with some kind of side effect
