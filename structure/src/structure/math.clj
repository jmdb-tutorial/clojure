(ns structure.math
  "Examples of how to do maths - relies on clojure.math.numeric-tower"
  (:use [clojure.math.numeric-tower]))

;; Exponents
(expt 2 3) ;; => 8

(abs -34.234) ;;= 34.234

;; Greatest common divisor
(gcd 10 15) ;; => 5

;; Least common multiple
(lcm 4 5) ;; => 20

;; Floor (round down)
(floor 2.345) ;; => 2.0

;; Ceiling (round up)
(ceil 2.345) ;; => 3.0

;; To nearest
(round 2.345) ;; => 2

;; Square root
(sqrt 25) ;; => 5

;; Exact square root plus remainder
(exact-integer-sqrt 17) ;; => [4 1]


(defn gen-rand-ints [n, max]
  (take n (repeatedly #(rand-int max))))

(defn average
  [numbers]
  (let [count (count numbers)
        sum (reduce + numbers)
        avg (double (/ sum count))]
    {:count count
     :sum sum
     :avg avg} ))

;; The laws of averages
(def values-a [16 17 0 16 15 3 13 8 19 5 0 16 10 1 4 4 5 11 19 0])
(def values-b [11 13 15 11 19 6 5 12 0 1 17 4 14 15 16 4 7 15 16 2 10 19 0 0 14 11 4 19 6 8])
(def values-c [16 6 0 12 0 8 8 10 16 11 13 18 18 7 4])

(def all-values (flatten [values-a values-b values-c]))

(def all-values ())

(def avg-a (average values-a))
(def avg-b (average values-b))
(def avg-c (average values-c))

;; Now try doing the average of averages:
(def avg-of-avgs (average (map :avg [avg-a avg-b avg-c])))

;; Vs the true average of all values:
(def true-avg (average all-values))

;; Or you could add the counts and sums and then calculate
(def aggregated-avg (let [input [avg-a avg-b avg-c]
                          counts (map :count input)
                          sums (map :sum input)
                          N (reduce + counts)
                          SUM (reduce + sums)]
                      (double (/ SUM N))))

(:avg true-avg)
aggregated-avg
(= (:avg true-avg) aggregated-avg) ;; => true
