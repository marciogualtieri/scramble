(ns scramble-ui.subs
  (:require
   [re-frame.core :as re-frame]))


(re-frame/reg-sub
 ::str1
 (fn [db]
   (:str1 db)))

(re-frame/reg-sub
  ::str2
  (fn [db]
    (:str2 db)))

(re-frame/reg-sub
  ::result
  (fn [db]
    (:result db)))

(re-frame/reg-sub
  ::message-text
  (fn [db]
    (:message-text db)))

(re-frame/reg-sub
  ::is-error-message
  (fn [db]
    (:is-error-message db)))
