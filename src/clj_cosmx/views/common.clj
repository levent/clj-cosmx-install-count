(ns clj-cosmx.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "clj-cosmx"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))
