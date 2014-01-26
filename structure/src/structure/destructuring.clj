(ns structure.destructuring)

(defn f1 [a & args]
  (str "a= " a " args= " args))

;; user> (f1 1 2 3 4)
;; "a= 1 args= (2 3 4)"

(defn f2 [& [a & args]]
  (str "a= " a " args= " args))

;; user> (f2 1 2 3 4)
;; "a= 1 args= (2 3 4)"

(defn f3 [& [a & args :as all]]
  (str "a= " a " args= " args " all= " all))

;; user> (f3 1 2 3 4)
;; "a= 1 args= (2 3 4) all= (1 2 3 4)"


(defn f4
  ([] (str "no-args"))
  ([a & args]
     (str "a= " a " args= " args)))

