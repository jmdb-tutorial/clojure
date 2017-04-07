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

(let [[a & rest :as all] [1 2 3 4 5 6]]
     (str "a= " a ", rest= " rest ", all= " all))

(let [[a b c] [1 2 3 4 5]]
  (str "a= " a ",b= " b ",c=" c))

;; Destructuring Maps

;; Simple
(def simple-map {:a "foo"
                 :b "bar"
                 :c "baz"})

(let [{a :a b :b} simple-map]
  (str "a= " a ",b= " b))

;; Nested
(def nested-map {:a "foo"
                 :b "bar"
                 :c { :d "boom!"
                      :e "bang!"}})


(let [{ a :a { d :d e :e } :c} nested-map]
  (str "a= " a ",d= " d ",e= " e))

;; Defaults

(let [{a :a, no-such-key :no-such-key, b :b, :or {no-such-key "default value"}} simple-map]
  (str ))

;; Destructure over a list of maps:

(def list-of-maps [{:a "1" :b "a"}
                   {:a "2" :b "b"}
                   {:a "3" :b "c"}
                   {:a "4" :b "d"}
                   {:a "5" :b "e"}
                   {:a "6" :b "f"}])

(map [{a :a b :b}] )
