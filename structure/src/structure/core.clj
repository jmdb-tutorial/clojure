(ns structure.core
  (:use [structure.branching :as branching])
  (:gen-class))

(defn say-hello
  []
  (println "hello"))

(defmacro bob
  [fn]
  '(fn))

(defmacro describe-and-execute [fn]
  (printf "\n[example] %s:\n\n" (:doc (meta fn)))
  (fn))

(defn -main
  "Prints out some stuff"
  [& args]
  (println "Here are some interesting examples of clojure algorithm structure...")
  (printf "\n[example] %s:\n\n" (:doc (meta #'structure.branching/execute)))
  (branching/execute)
  (describe-and-execute branching/execute))
