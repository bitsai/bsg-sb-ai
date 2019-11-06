(ns bsg-sb-ai.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[bsg-sb-ai started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[bsg-sb-ai has shut down successfully]=-"))
   :middleware identity})
