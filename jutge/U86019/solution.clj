(def f1 #(->> % (filter even?) (map (partial * 2)) (reduce +)))
(def f2 #(->> % (filter (partial <= 0)) (take 3) (map (partial * 10))))
(def f3 #(->> % (filter (partial <= 5)) (map (partial * 3)) (sort-by (partial * -1))))
(defn f4 [l] (->> l (filter #(not (= 0 (rem % 3)))) (take 5) (map #(* % %))))