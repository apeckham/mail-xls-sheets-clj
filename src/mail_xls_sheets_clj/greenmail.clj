(ns mail-xls-sheets-clj.greenmail
  (:import [com.icegreen.greenmail.util GreenMail GreenMailUtil]
           javax.mail.Folder))

(def gm (GreenMail.))

(.start gm)

(.setUser gm "bar@example.com" "bar@example.com" "secret-pwd")

(GreenMailUtil/sendTextEmailTest "bar@example.com" "from@localhost.com" "subject" "body")

(.getSubject (first (.getReceivedMessages gm)))

(def session (.createSession (.getImap gm)))

(def store (.getStore session "imap"))

(.connect store "bar@example.com" "secret-pwd")

(def inbox (.getFolder store "INBOX"))

(.open inbox Folder/READ_ONLY)

(def message (.getMessage inbox 1))

(.getSubject message)

