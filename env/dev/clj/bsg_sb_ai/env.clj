(ns bsg-sb-ai.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [bsg-sb-ai.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[bsg-sb-ai started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[bsg-sb-ai has shut down successfully]=-"))
   :middleware wrap-dev})
