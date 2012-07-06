(ns clj-cosmx.server
  (:require [noir.server :as server]))

(server/load-views "src/clj_cosmx/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'clj-cosmx})))

