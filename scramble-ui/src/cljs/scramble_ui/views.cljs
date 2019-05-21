(ns scramble-ui.views
  (:require
    [re-frame.core :as re-frame]
    [scramble-ui.subs :as subs]))

(defn main-panel []
  (let [str1 (re-frame/subscribe [::subs/str1])
        str2 (re-frame/subscribe [::subs/str2])
        result (re-frame/subscribe [::subs/result])
        message-text (re-frame/subscribe [::subs/message-text])
        is-error-message (re-frame/subscribe [::subs/is-error-message])
        ]
    [:div {:class "panel panel-default"}

     [:div {:class "page-header"}

      [:h1 "Scramble?"

       [:small "i.e., Can a portion of str1 characters be rearranged to match str2?"]
       ]
      ]

     [:div {:class "form-group"}
      [:label {:for "str1"} "str1"]
      [:input {:id "str1" :name "str1" :type "text" :value @str1 :class "form-control"
               :onChange #(re-frame/dispatch [:update-str1 (-> % .-target .-value)])}]
      ]

     [:div {:class "form-group"}
      [:label {:for "str2"} "str2"]
      [:input {:id "str2" :name "str2" :type "text" :value @str2 :class "form-control"
               :onChange #(re-frame/dispatch [:update-str2 (-> % .-target .-value)])}]
      ]

     [:div {:class "form-group"}
      [:label {:for "result"} "result"]
      [:input {:id "result" :name "result" :type "text" :value @result :class "form-control" :readOnly true}]
      ]

     [:button {:class "btn btn-primary" :on-click #(re-frame/dispatch [:request-it])} "Submit"]

     [:div {:class (str "alert" (if @is-error-message " alert-danger" " alert-success"))} @message-text]

     ]))
