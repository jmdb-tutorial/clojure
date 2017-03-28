(ns structure.collections
  "Contains demonstrations of various ways to work with collections of things
   Notice that (apply) is not in here - that is for functions and parameters, see functions.clj"
  (:use [clojure.math.numeric-tower])
  (:require [clojure [zip :as zip]]))

;; Create a list of numbers
(def zero2ten (range 0 11))

;; Iterate over a collection to calculate some aggregate (e.g. sum)
(reduce + zero2ten) ;; => 55

;; Equivalent to:
(+ 1 2 3 4 5 6 7 8 9 10) ;; => 55


;; Iterate over a collection and return a collection of results
(map (fn[i] (* 2 i)) [1 2 3]) ;; => (2 4 6)

;; Or can return a vector:
(mapv (fn[i] (* 2 i)) [1 2 3]) ;; => [2 4 6]

;; Filter out things:
(filter odd? zero2ten)

;; Flatten arrays
(flatten [[1 2] [3 4] [5 6]])

;; 

;; Higher level constructs:

(for [i [1 2 3]] (* 2 i)) ;; => (2 4 6)

;; More complex for:
(for [x [1 2 3]
      y [1 2 3]]
  (format "(%d, %d)" x y))

;; Can use :when and :let
(for [x (range 6)
        :when (odd? x)
        :let [y (* x x)] ]
  (format "(expt %d 2) => %d" x y))

;; And :while
(for [x (range 99)
               :let [y (* x x)] 
               :while (< y 30)]
  (format "(expt %d 2) => %d" x y))


;; Iterate over a collection with some kind of side effect (ie. doesnt return a resulting collection
(doseq [x [1 2 3]
        y [1 2 3]]
  (println (format "(%d, %d)" x y)))

;; Can use :when and :let
(doseq [x (range 6)
        :when (odd? x)
        :let [y (* x x)] ]
  (println (format "(expt %d 2) => %d" x y)))

;; And :while
(doseq [x (range 99)
        :let [y (* x x)] 
        :while (< y 30)]
  (println (format "(expt %d 2) => %d" x y)))

;; Can do multiple things in the body:
(doseq [x [1 2 3]
        :let [y (* x x)]]
  (println "x: " x)
  (println "y: " y))


;; Looping when you don't have a starting collection
(loop [x 0]
  (when (<= x 4)
    (println x)
    (recur (+ 1 x))))


;; Zippers (http://josf.info/blog/2014/03/21/getting-acquainted-with-clojure-zippers/)

(def tree [1 [:a :b] 2 3 [40 50 60]])

(zip/vector-zip [1 [:a :b] 2 3 [40 50 60]])

(->  tree
     zip/vector-zip
     zip/down
     zip/right)

(def zipper (zip/vector-zip tree))

(loop [z (zip/next zipper)]
  (when (not (zip/end? z))
    (println (zip/node z))
    (recur (zip/next z))))
