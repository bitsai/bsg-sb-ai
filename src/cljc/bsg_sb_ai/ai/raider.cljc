(ns bsg-sb-ai.ai.raider)

(def maneuver-cards
  {:maneuver {:left  [{:card-number 1
                       :g 0
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 2
                       :g 1
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 4
                       :g 1
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 6
                       :g 2
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 8
                       :g 2
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 10
                       :g 3
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 12
                       :g 3
                       :kinetic-energy {:high 3
                                        :medium 2}}]
              :right [{:card-number 1
                       :g 0
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 3
                       :g 1
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 5
                       :g 1
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 7
                       :g 2
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 9
                       :g 2
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 11
                       :g 3
                       :kinetic-energy {:high 3
                                        :medium 2
                                        :low 1}}
                      {:card-number 13
                       :g 3
                       :kinetic-energy {:high 3
                                        :medium 2}}]} 
   :overboost {:left  [{:card-number 14
                        :g 0
                        :kinetic-energy 3}
                       {:card-number 15
                        :g 1
                        :kinetic-energy 3}
                       {:card-number 17
                        :g 2
                        :kinetic-energy 3}
                       {:card-number 19
                        :g 3
                        :kinetic-energy 3}]
               :right [{:card-number 14
                        :g 0
                        :kinetic-energy 3}
                       {:card-number 16
                        :g 1
                        :kinetic-energy 3}
                       {:card-number 18
                        :g 2
                        :kinetic-energy 3}
                       {:card-number 20
                        :g 3
                        :kinetic-energy 3}]}})
