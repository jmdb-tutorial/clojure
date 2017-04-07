(ns structure.statistics
  "Examples of how to do statistics - relies on clojure.math.numeric-tower and incanter"
  (:use [clojure.math.numeric-tower])
  (:require [incanter.core :as i]
            [incanter.stats :as s]
            [incanter.charts :as p]))


(i/view (p/histogram (s/sample-normal 1000)))

(defn show [chart]
  "Renders a chart and saves the result in a temp file"
  (i/save chart "/tmp/chart.png" :width 700 :height 500))



(def day-1 (vec (s/sample-normal 1000 :mean 10)))
(def day-2 (vec (s/sample-normal 1000 :mean 20)))
(def day-3 (vec (s/sample-normal 1000 :mean 30)))

(show (p/scatter-plot (range 0 1000) day-1))
(show (p/histogram day-1))

(def samples-1-10 (take 10 (repeatedly #(rand-nth day-1))))
(def samples-2-10 (take 10 (repeatedly #(rand-nth day-2))))
(def samples-3-10 (take 10 (repeatedly #(rand-nth day-3))))
(def samples-3-1 (take 1 (repeatedly #(rand-nth day-3))))

(show (p/histogram samples-1-10))

(s/mean samples-1-10)
(s/mean samples-2-10)
(s/mean samples-3-10)
(s/mean samples-3-1)

(s/mean [10 20 30])

;; How reliable is 1 sample?
;; https://en.wikipedia.org/wiki/68%E2%80%9395%E2%80%9399.7_rule
;; Theres a 68%, 95% and 99.7% chance a sample lies within 1,2 and 3 standard deviations of the mean
;; SO it will depend a lot on what the distribution of the underlying population looks like
;; If it has a very broad distribution then 1 sample increasingly unlikely to be accurate. If very narrow will be more accurate

