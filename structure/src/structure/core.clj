(ns structure.core
  (:use structure.execute
        structure.branching :as branching)
  (:gen-class))

(defn -main
  "Prints out some stuff"
  [& args]
  (exedoc branching/execute))
