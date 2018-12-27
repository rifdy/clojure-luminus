(ns app.extend.tutor
  (:require [app.layout :as layout]
            [app.db.core :as db]
            [compojure.core :refer [defroutes ANY]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn operation [oper var]
  (layout/render "Tutorial.html"
      (cond
        (= oper "+") {:my-var1 
                      (runthis oper var)}
        (= oper "-") {:my-var2 
                      (runthis oper var)}
        (= oper "*") {:my-var3 
                      (runthis oper var)}
        (= oper "/") {:my-var4 
                      (runthis oper var)}
        (= oper "inc") {:my-var5 
                        (runthis oper var)}
        (= oper "dec") {:my-var6 
                        (runthis oper var)}
        (= oper "max") {:my-var7 
                        (runthis oper var)}
        (= oper "min") {:my-var8 
                        (runthis oper var)}
      )
    ))

(defn runthis [oper var]
  (try 
   (apply(resolve(symbol oper)) (str-to-ints var))
   (catch Exception e nil)))

(defn str-to-ints [var]
  (map #(Integer/parseInt %)(str/split var #" ")))

(defn parse-int [number-string]
  (try (Integer/parseInt number-string)
    (catch Exception e nil)))

(defroutes tutor-routes
  (ANY "/tutorial" [oper var] (operation oper var))
  )