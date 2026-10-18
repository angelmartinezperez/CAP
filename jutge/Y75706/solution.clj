(defn build-palindrome [lst] (apply conj lst lst))
(defn remove-list [lst, remove]
  (letfn [(without [lst value]
            (loop [lst lst, out '()]
              (let [elem (first lst)] 
                (cond 
                  (= elem nil) out
                  (= elem value) (recur (rest lst) out)
                  :else (recur (rest lst) (conj out elem))))))]
  (loop [remove remove, out lst] 
    (let [elem (first remove)] 
      (if (= elem nil) 
        out
        (recur (rest remove) (without out elem)))))))
(defn add-if [lst elem cond]
  (if (cond elem)
    (conj lst elem)
    lst))
(def rev #(apply conj '() %))
(defn odds-n-evens [lst] 
  (loop [lst lst, odds '(), evens '()] 
    (let [elem (first lst)]
      (if (empty? lst)
        (conj '() (rev evens) (rev odds))
        (recur (rest lst) (add-if odds elem odd?) (add-if evens elem even?))))))
(defn prime-divisors [n] '())