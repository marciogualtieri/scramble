(ns scramble-api.scramble-test
  (:require [midje.sweet :refer :all]
            [scramble-api.scramble :refer :all]))

(facts "scramble? tests"
       (fact "first example from specs" (scramble? "rekqodlw" "world") => true)
       (fact "second example from specs" (scramble? "cedewaraaossoqqyt" "codewars") => true)
       (fact "third example from specs" (scramble? "katas" "steak") => false))

