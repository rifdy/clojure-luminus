(ns app.extend.tutor
  (:require [app.layout :as layout]
            [app.db.core :as db]
            [compojure.core :refer [defroutes ANY]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn operation [oper vari]
  (layout/render "Tutorial.html"
      (cond
        (= oper "+") {:my-var1 
                      (try 
                        (apply(resolve(symbol oper)) (map #(Integer/parseInt %)(str/split vari #" ")))
                        (catch Exception e nil))}
        (= oper "-") {:my-var2 
                      (try 
                        (apply(resolve(symbol oper)) (map #(Integer/parseInt %)(str/split vari #" ")))
                        (catch Exception e nil))}
        (= oper "*") {:my-var3 
                      (try 
                        (apply(resolve(symbol oper)) (map #(Integer/parseInt %)(str/split vari #" ")))
                        (catch Exception e nil))}
        (= oper "/") {:my-var4 
                      (try 
                        (apply(resolve(symbol oper)) (map #(Double/parseDouble %)(str/split vari #" ")))
                        (catch Exception e nil))}
        (= oper "inc") {:my-var5 
                        (try 
                        (apply(resolve(symbol oper)) (map #(Integer/parseInt %)(str/split vari #" ")))
                        (catch Exception e nil))}
        (= oper "dec") {:my-var6 
                        (try 
                        (apply(resolve(symbol oper)) (map #(Integer/parseInt %)(str/split vari #" ")))
                        (catch Exception e nil))}
        (= oper "max") {:my-var7 
                        (try 
                        (apply(resolve(symbol oper)) (map #(Integer/parseInt %)(str/split vari #" ")))
                        (catch Exception e nil))}
        (= oper "min") {:my-var8 
                        (try 
                        (apply(resolve(symbol oper)) (map #(Integer/parseInt %)(str/split vari #" ")))
                        (catch Exception e nil))}
      )
    ))

(defroutes tutor-routes
  (ANY "/tutorial" [oper vari] (operation oper vari))
  )