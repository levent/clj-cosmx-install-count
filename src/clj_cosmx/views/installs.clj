(ns clj-cosmx.views.installs
  (:require [clj-cosmx.views.common :as common])
  (:require [clj-http.client :as client])
  (:require [cheshire.core :as json])
            
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defn get-cosmx-install-count []
  (get (json/parse-string (get (client/get (str "http://api.cosm.com/v2/feeds.json?tag=app%3Aname%3DCosmX&content=summary&key=" (get (System/getenv) "API_KEY")) ) :body) true) :totalResults))

(defpage "/" []
         (common/layout
           [:p (get-cosmx-install-count)]))
