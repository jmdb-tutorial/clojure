(ns structure.core
  (:use structure.execute
        [structure.branching :as branching])
  (:gen-class))

(defn -main
  "Executes various clojure tutorials"
  [& args]
  (exedoc branching/execute))