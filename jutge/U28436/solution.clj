(defn abs-value "Absolute value" [x] (if (> x 0) x (- x)))
(defn power1 [x p] (apply * (repeat p x)))
(defn power2 [x p] 
    (loop [current x, i p] 
        (if (= i 1) 
            current
            (recur (* current x) (dec i)))))
(defn prime? [n] 
    (loop [i (dec n)] (cond 
        (= i 1) true
        (= (mod n i) 0) false
        :else (recur (dec i)))))