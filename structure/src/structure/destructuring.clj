(ns structure.destructuring)

(defn f1 [a & args]
  (str "a= " a " args= " args))

;; user> (f1 1 2 3 4)
;; "a= 1 args= (2 3 4)"

(defn f2 [& [a & args]]
  (str "a= " a " args= " args))

;; user> (f2 1 2 3 4)
;; "a= 1 args= (2 3 4)"

(defn f3 [& [a & args :as allargs]]
  (str "a= " a " args= " args " all= " allargs))

;; user> (f3 1 2 3 4)
;; "a= 1 args= (2 3 4) all= (1 2 3 4)"


(defn f4
  ([] (str "no-args"))
  ([a & args]
     (str "a= " a " args= " args)))

;; user> (f4)
;; "no-args"
;; user> (f4 1 2 3 4)
;; "a= 1 args= (2 3 4)"

(defn f5 [& [a & args :as allargs]]
  (if (or (empty? allargs) (= 1 a))
        (str "Either there were 0 args, or a=1")
        (str "a= " a " args= " args " all= " allargs)))

;; user> (f5)
;; "Either there were 0 args, or a=1"
;; user> (f5 1 2 3 4)
;; "Either there were 0 args, or a=1"
;; user> (f5 :foo 2 3 4)
;; "a= :foo args= (2 3 4) all= (:foo 2 3 4)"

(defn f6 [& [a & args :as allargs]]
  (cond (or (empty? allargs) (= 1 a))
        (str "Either there were 0 args, or a=1")
        :otherwise
        (str "a= " a " args= " args " all= " allargs)))

;; user> (f6)
;; "Either there were 0 args, or a=1"
;; user> (f6 1 2 3 4)
;; "Either there were 0 args, or a=1"
;; user> (f6 :foo 2 3 4)
;; "a= :foo args= (2 3 4) all= (:foo 2 3 4)"
