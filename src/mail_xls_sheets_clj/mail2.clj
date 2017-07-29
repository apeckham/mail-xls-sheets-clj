(ns mail-xls-sheets-clj.mail2
  (:require clojure.java.io)
  (:import java.util.Properties
           javax.mail.internet.MimeMessage))

(def input-stream (clojure.java.io/input-stream "file:///Users/apeckham/Downloads/original_msg.txt"))

(def message (-> (Properties.)
                 javax.mail.Session/getInstance
                 (MimeMessage. input-stream)))
