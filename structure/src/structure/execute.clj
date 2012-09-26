(ns structure.execute)

(defn meta-doc
  "Gets documentation from the meta data"
  [obj]
  (:doc (meta obj)))

(defmacro exedoc
  [fn-obj]
  `(do
     (printf "\n[example] %s:\n\n" (meta-doc (var ~fn-obj)))
     (~fn-obj)))

(defmacro exedoc-1 [& body]
  `(let [x# ~@body]
     (println (str "dbg: " (quote ~@body) "=" x#))
     x#))




