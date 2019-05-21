(ns scramble-ui.events
  (:require
    [scramble-ui.db :as db]
    [scramble-ui.config :as config]
    [ajax.core :as ajax]
    [day8.re-frame.http-fx]
    [re-frame.core :as re-frame]
    [re-frame.core :refer [reg-event-fx]]
))


(re-frame/reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))

(re-frame/reg-event-db
  :update-str1
  (fn [db [_ value]]
    (into db {:result config/default-result
              :message-text config/default-message-text
              :is-error-message false
              :str1 value})
))

(re-frame/reg-event-db
  :update-str2
  (fn [db [_ value]]
    (into db {:result config/default-result
              :message-text config/default-message-text
              :is-error-message false
              :str2 value})))

(re-frame/reg-event-fx
  :request-it
  (fn
    [{db :db} _]

    {:http-xhrio {:method          :get
                  :uri             config/back-end-url
                  :params          {:str1 (db :str1) :str2 (db :str2)}
                  :format          (ajax/json-request-format)
                  :response-format (ajax/json-response-format {:keywords? true})
                  :on-success      [:process-response]
                  :on-failure      [:bad-response]}
     }))

(re-frame/reg-event-db
  :process-response
  (fn
    [db [_ response]]
    (-> db
        (assoc :result ((js->clj response) :result)))))

(re-frame/reg-event-db
  :bad-response
  (fn
    [db [_ response]]
    (-> db
        (assoc :is-error-message true)
        (assoc :message-text ((js->clj response) :status-text)))))