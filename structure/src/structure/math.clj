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
