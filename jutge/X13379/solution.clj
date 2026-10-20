(def mides #(->> % (map count) (filter odd?) (reduce +)))
(defn noms [mapa] (->> mapa (filter #(>= (val %) 18)) (map key) (sort)))
(defn suma [v] (->> v (map #(* (:quantitat %) (:preu %))) (filter (partial <= 100)) (reduce +)))