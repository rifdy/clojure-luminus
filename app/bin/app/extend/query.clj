(ns app.extend.query
  (:require [app.layout :as layout]
            [app.db.core :as db]
            [compojure.core :refer [defroutes ANY]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn query-page [ad_org_id]
  (layout/render "query.html"
    {:my-var1 (db/get-organization_mapping {:ad_org_id ad_org_id})}
    ))

(defn parse-int [number-string]
  (try (Integer/parseInt number-string)
    (catch Exception e nil)))

(defroutes query-routes
  (ANY "/query" [ad_org_id] (query-page (parse-int ad_org_id)))
  )
