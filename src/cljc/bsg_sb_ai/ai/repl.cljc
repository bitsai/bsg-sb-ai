(ns bsg-sb-ai.ai.repl
  (:require [bsg-sb-ai.ai.core :as ai]
            [bsg-sb-ai.ai.raider :as raider]
            [clojure.string :as str]))

;; define REPL helpers
(doseq [{:keys [side index] :as v} [{:side :right :index 0}
                                    {:side :right :index 1}
                                    {:side :right :index 2}
                                    {:side :right :index 3}
                                    {:side :right :index 4}
                                    {:side :right :index 5}
                                    {:side :right :index 6}
                                    {:side :left :index 0}
                                    {:side :left :index 1}
                                    {:side :left :index 2}
                                    {:side :left :index 3}
                                    {:side :left :index 4}
                                    {:side :left :index 5}
                                    {:side :left :index 6}]
        :let [s (str (-> side name first) index)
              f (fn []
                  (doseq [r [21 16 11 0]
                          :let [ms (ai/get-maneuvers raider/maneuver-cards r v)]]
                    (printf "If target >= %s cm:\n" r)
                    (doseq [m (:maneuvers ms)]
                      (printf "Card = %s" (:card-number m))
                      (when-let [s (:speed m)]
                        (printf " | Speed = %s" (-> s name str/upper-case)))
                      (println))
                    (printf "Kinetic Energy = %s\n\n" (:kinetic-energy ms))))]]
  (intern *ns* (symbol s) f))
