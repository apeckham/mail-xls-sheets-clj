(ns mail-xls-sheets-clj.mail
  (:import javax.mail.Session))

;; ; https://github.com/javaee/javamail/blob/cbf47f61945bde02301e2f9ddc4e2c4a1b7fbb72/demo/src/main/java/msgshow.java
;; enable https://myaccount.google.com/lesssecureapps

(def session (javax.mail.Session/getInstance (System/getProperties) nil))
(.setDebug session true)

(def store (.getStore session "imaps"))

(.connect store "imap.gmail.com" 993 username password)

(def folder (.getFolder (.getDefaultFolder store) "INBOX"))

(.open folder javax.mail.Folder/READ_ONLY)

(.getMessageCount folder)

(def message (.getMessage folder 2))

(.getFrom message)

(.getContent message)

(.getSubject message)

(.getContentType (.getBodyPart (.getContent message) 0))

(.getDisposition (.getBodyPart (.getContent message) 1))

(.saveFile (.getBodyPart (.getContent message) 1) (java.io.File. "/tmp/x.png"))
