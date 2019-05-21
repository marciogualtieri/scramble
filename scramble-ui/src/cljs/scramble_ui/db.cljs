(ns scramble-ui.db
  (:require [scramble-ui.config :as config]))

(def default-db
  {:str1 "rekqodlw"
   :str2 "world"
   :result "?"
   :message-text config/default-message-text
   :is-error-message false})
