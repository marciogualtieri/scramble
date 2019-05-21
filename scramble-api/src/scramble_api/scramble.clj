(ns scramble-api.scramble
  (:require [clojure.set :refer [superset?]]))



(defn scramble? [str1 str2] (superset? (set str1) (set str2)))
