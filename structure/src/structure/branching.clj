(ns structure.branching
  (:use structure.execute))

(defn simple-if-statement
  "The most basic branching type"
  [aBoolean]
  (if aBoolean
    (println "Your variable was true")
    (println "Your variable was false")))

(defn execute
  "Runs some interesting branching examples"
  []
  (simple-if-statement true)
  (simple-if-statement false))
