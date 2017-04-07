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

(defn mean
  [numbers]
  (let [count (count numbers)
        sum (reduce + numbers)
        mean (double (/ sum count))]
    {:count count
     :sum sum
     :mean mean} ))

;; The laws of averages - or rather calculating the mean
(def values-a [16 17 0 16 15 3 13 8 19 5 0 16 10 1 4 4 5 11 19 0])
(def values-b [11 13 15 11 19 6 5 12 0 1 17 4 14 15 16 4 7 15 16 2 10 19 0 0 14 11 4 19 6 8])
(def values-c [16 6 0 12 0 8 8 10 16 11 13 18 18 7 4])

(def all-values (flatten [values-a values-b values-c]))

(def all-values ())

(def mean-a (mean values-a))
(def mean-b (mean values-b))
(def mean-c (mean values-c))

;; Now try doing the mean of means
(def mean-of-means (mean (map :mean [mean-a mean-b mean-c])))

;; Vs the mean of all values:
(def mean-of-all (mean all-values))

;; Or you could add the counts and sums and then calculate
(def aggregated-mean (let [input [mean-a mean-b mean-c]                          
                           counts (map :count input)
                           sums (map :sum input)
                           N (reduce + counts)
                           SUM (reduce + sums)]
                       (double (/ SUM N))))

(:mean mean-of-all)
aggregated-mean
(= (:mean mean-of-all) aggregated-mean) ;; => true

;; Put this into a real world context
;; For example readings of measurements and then finding out a daily mean
;; e.g.
;; |Day   | Time  | Obs |
;; |------|-------|-----|
;; | 1    | 20:00 | 2   |
;; | 1    | 21:00 | 4   |
;; | 1    | 22:00 | 3   |
;; | 1    | 23:00 | 1   |
;; | 2    | 00:00 | 100 |
;;
;; In this case, the mean on day 1 would be
(mean [2 4 3 1]) ;; => 2.5

;; The mean on day 2 would be 10 so the mean of means would be:
(mean [2.5, 100]) ;; => 51.25

;; But the mean of everything would be:
(mean [2 4 3 1 100]) => 22.0

;; What this comes down to is wether a sample of 1 is representative of the actual air quality of that day.
;; If we believe that the single value is close to the mean then the mean of means is correct,
;; if we believe that a single sample is not representative and that its actually an incorrect random sample,
;; then its better to take the mean of all of them
;; At this point its starts getting statistical - best jump to statistics.clj




