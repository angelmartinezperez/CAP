(defn my-count1 [l] (letfn [
    (my-count [count l]
        (if (empty? l)
            count
            (my-count (inc count) (rest l))))]
    (my-count 0 l)))
(defn my-count2 [l] 
    (loop [count 0 left l]
        (if (empty? left)
            count
            (recur (inc count) (rest left)))))
(def num-max #(if (> %1 %2) %1 %2))
(defn my-maximum1 [l] (letfn [
    (my-max [current l]
        (if (empty? l)
            current
            (my-max (num-max current (first l)) (rest l))))
    ] (my-max (first l) (rest l))))
(defn my-maximum2 [l] 
    (loop [m (first l) left (rest l)]
        (if (empty? left)
            m
            (recur (num-max m (first left)) (rest left)))))
;; I'm too lazy to write the same code again with a slight modification
(defn average1 [l] (/ (apply + l) (my-count1 l)))
(defn average2 [l] (/ (apply + l) (my-count1 l)))