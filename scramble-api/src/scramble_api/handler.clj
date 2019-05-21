(ns scramble-api.handler
  (:require [compojure.api.sweet :refer :all]
            [compojure.route :as route]
            [ring.util.http-response :refer :all]
            [scramble-api.scramble :refer :all]
            [ring.middleware.cors :refer [wrap-cors]]))

(def app-routes
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "scramble-api"
                    :description "scramble-api"}
             :tags [{:name "api", :description "scramble-api"}]}}}

    (context "/api" []
      :tags ["api"]

      (GET "/scramble" []
        :return {:result Boolean}
        :query-params [str1 :- String, str2 :- String]
        :summary "returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false"
        (ok {:result (scramble? str1 str2)}))


      )

    (context "/" []
      (undocumented (route/not-found (not-found {:error "invalid resource"}))))

    )

  )

(def app
  (wrap-cors app-routes
             :access-control-allow-origin [#"http://localhost:3449"]
             :access-control-allow-headers ["Origin" "X-Requested-With" "Content-Type" "Accept"]
             :access-control-allow-methods [:get])
  )

