(ns structure.macros)

;;Some examples of macros:

;; Simple reader expansion
(def x 5)
(def lst '(a b c))
`(fred x ~x lst ~@lst 7 8 :nine)


(defn foo
  "This is some function"
  [someArg]
  (format "Hello %s" someArg))

;; Expansion of the meta function
`(meta (var ~foo))


(:doc  (get-meta foo))


(defmacro get-meta
  [fun]
  `(meta (var ~fun)))

(defmacro doc-string
  "Returns only the documentation of an object"
  [obj]
  `(:doc (get-meta ~obj)))

(defmacro doc-string
  "Gets documentation but inlines the meta call"
  [obj]
  `(:doc (meta (var ~obj))))

(doc-string foo)
(doc-string-1 foo)

