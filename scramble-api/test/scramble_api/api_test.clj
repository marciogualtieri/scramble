(ns scramble-api.api-test
  (:require [cheshire.core :as cheshire]
            [midje.sweet :refer :all]
            [scramble-api.handler :refer :all]
            [ring.mock.request :as mock]))


(defn parse-body [body]
  (cheshire/parse-string (slurp body) true))

(facts "api tests"
       (fact "Test scramble api returns true when a portion of str1 can be rearranged to match str2"
             (let [response (app (-> (mock/request :get "/api/scramble?str1=rekqodlw&str2=world")))
                   body (parse-body (:body response))]
               (:status response) => 200
               (:result body) => true))


       (fact "Test scramble api returns false when a portion of str1 cannot be rearranged to match str2"
             (let [response (app (-> (mock/request :get "/api/scramble?str1=katas&str2=steak")))
                   body (parse-body (:body response))]
               (:status response) => 200
               (:result body) => false))


       (fact "Test call for an invalid resource"
             (let [response (app (-> (mock/request :get "/i/do/not/exist")))
                   body (parse-body (:body response))]
               (:status response) => 404
               (:error body) => "invalid resource"))



       )
