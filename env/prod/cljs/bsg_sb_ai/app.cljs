(ns bsg-sb-ai.app
  (:require [bsg-sb-ai.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
