(ns structure.functions)

(defn a-function
  []
  (println "Hey, I do something"))

(a-function)

(var a-function) ;; Turns this reference into a variable

(def theFun (var a-function))

(println theFun)

(defn i-take-afunction-var-as-a-parameter
  [aFun]
  (meta (aFun)))

(i-take-afunction-var-as-a-parameter a-function)

;; Variable args:

(defn pass-me-something
  [a & others]
  (println others))

;; Use of apply
(defn myfn [a b c]
  (format "%s:%s:%s" a b c))

(myfn 1 2 3)

(apply myfn ["a" "b" "c"]) ;; => "a:b:c"


;; @TODO
;; - Higher order functions (Functions that return functions)
;; - Partials
;; - Anonymous functions
;; - apply
