(ns bsg-sb-ai.test.ai.core
  (:require [clojure.test :refer :all]
            [bsg-sb-ai.ai.core :as ai]
            [bsg-sb-ai.ai.raider :as raider]))

(deftest test-ai
  (testing "cards with no low speed maneuver should default to medium speed"
    (is (= {:maneuvers [{:card-number 13
                         :g 3
                         :kinetic-energy 2
                         :speed :medium}]
            :kinetic-energy 2}
           (ai/get-maneuvers raider/maneuver-cards 1 {:side :right :idx 6}))))

  (testing "maneuvers should not exceed maximum G"
    (is (= {:maneuvers [{:card-number 20
                         :g 3
                         :kinetic-energy 3}
                        {:card-number 5
                         :g 1
                         :kinetic-energy 3
                         :speed :high}]
            :kinetic-energy 6}
           (ai/get-maneuvers raider/maneuver-cards 21 {:side :right :idx 3}))))

  (testing "overboost card index should not be out-of-bounds"
    (is (= {:maneuvers [{:card-number 20
                         :g 3
                         :kinetic-energy 3}
                        {:card-number 5
                         :g 1
                         :kinetic-energy 3
                         :speed :high}]
            :kinetic-energy 6}
           (ai/get-maneuvers raider/maneuver-cards 21 {:side :right :idx 6})))))
