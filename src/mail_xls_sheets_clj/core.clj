(ns mail-xls-sheets-clj.core
  (:gen-class))

;; ; https://github.com/javaee/javamail/blob/cbf47f61945bde02301e2f9ddc4e2c4a1b7fbb72/demo/src/main/java/msgshow.java
;; (def s (javax.mail.Session/getInstance (System/getProperties) nil))
;; (.setDebug s true)
;; (def store (.getStore s "imaps"))
;; (.connect store "imap.gmail.com" 993 username password)
;; (def folder (.getFolder (.getDefaultFolder store) "INBOX"))
;; (.open folder javax.mail.Folder/READ_ONLY)
;; (.getMessageCount folder)
;; (def message (.getMessage folder 1))
;; (.getFrom message)
;; (.getContent message)
;; (.getContentType (.getBodyPart (.getContent m) 0))
;; (.getDisposition (.getBodyPart (.getContent m) 1))
;; (.saveFile (.getBodyPart (.getContent m) 1) (java.io.File. "/tmp/x.png"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
