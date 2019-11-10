(ns bsg-sb-ai.ai.core)

(def max-g 4)

(defn range->speeds [range*]
  (cond
    (<= range* 10) [:low]
    (<= range* 15) [:medium]
    (<= range* 20) [:high]
    :else          [:overboost :high]))

(defn get-normal-maneuver
  ([cards {:keys [side index]} speed]
   (let [{:keys [kinetic-energy] :as c} (get-in cards [:maneuver side index])
         ;; cards with no low speed maneuver should default to medium speed
         speed (if (get kinetic-energy speed)
                 speed
                 :medium)]
     (assoc c
            :kinetic-energy (get kinetic-energy speed)
            :speed speed)))
  ([cards vector* speed max-g]
   (let [m (get-normal-maneuver cards vector* speed)]
     ;; maneuvers should not exceed maximum G
     (if (-> m :g (<= max-g))
       m
       (recur cards (update vector* :index dec) speed max-g)))))

(defn get-overboost-maneuver [cards {:keys [side index]}]
  (let [;; overboost card index should not be out-of-bounds
        index (min index (-> cards :overboost side count dec))]
    (get-in cards [:overboost side index])))

(defn get-maneuver [cards vector* speed max-g]
  (if (= speed :overboost)
    (get-overboost-maneuver cards vector*)
    (get-normal-maneuver cards vector* speed max-g)))

(defn get-maneuvers [cards range* vector*]
  (let [[s1 s2] (range->speeds range*)
        m1 (get-maneuver cards vector* s1 max-g)
        maneuvers (if s2
                    [m1 (get-maneuver cards vector* s2 (- max-g (:g m1)))]
                    [m1])]
    {:maneuvers maneuvers
     :kinetic-energy (->> maneuvers
                          (map :kinetic-energy)
                          (reduce +))}))
