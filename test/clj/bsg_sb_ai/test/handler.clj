(ns bsg-sb-ai.test.handler
  (:require
    [clojure.test :refer :all]
    [ring.mock.request :refer :all]
    [bsg-sb-ai.handler :refer :all]
    [bsg-sb-ai.middleware.formats :as formats]
    [muuntaja.core :as m]
    [mount.core :as mount]))

(defn parse-json [body]
  (m/decode formats/instance "application/json" body))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'bsg-sb-ai.config/env
                 #'bsg-sb-ai.handler/app-routes)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response ((app) (request :get "/invalid"))]
      (is (= 404 (:status response))))))
