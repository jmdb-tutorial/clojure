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