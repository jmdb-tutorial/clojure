(ns structure.core
  (:use [structure.branching :as branching])
  (:gen-class))

(defn meta-doc
  "Gets documentation from the meta data"
  [obj]
  (:doc (meta obj)))

(defmacro exedoc
  [fn-obj]
  `(do
     (printf "\n[example] %s:\n\n" (meta-doc (var ~fn-obj)))
     (~fn-obj)))

(defn -main
  "Prints out some stuff"
  [& args]
  (exedoc branching/execute))
