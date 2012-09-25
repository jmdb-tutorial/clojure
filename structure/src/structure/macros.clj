(ns structure.macros)

;;Some examples of macros:

;; Simple reader expansion
(def x 5)
(def lst '(a b c))
`(fred x ~x lst ~@lst 7 8 :nine)


(defn foo
  "This is some function"
  []
  (println "Hello foo"))

;; This is what we want to do ...
(:doc  (meta #'foo))


(defn meta-doc
  "Gets documentation from the metadata"
  [obj]
  (:doc (meta obj)))

(defmacro doc-string
  [fn-obj]
  `(meta-doc (var ~fn-obj)))

(doc-string foo)

;; We can see what the macro looks like when its expanded by doing this:
(macroexpand '(doc-string foo))
;; Note we have to put the literal syntax in there (') so that it doesn't actually execute the function!


(defmacro exedoc
  [fn-obj]
  `(do
     (println (meta-doc (var ~fn-obj)))
     (~fn-obj)))

(exedoc foo)
