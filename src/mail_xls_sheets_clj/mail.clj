(ns mail-xls-sheets-clj.mail
  (:import javax.mail.Session))

;; ; https://github.com/javaee/javamail/blob/cbf47f61945bde02301e2f9ddc4e2c4a1b7fbb72/demo/src/main/java/msgshow.java
;; enable https://myaccount.google.com/lesssecureapps

(def session (javax.mail.Session/getInstance (System/getProperties) nil))

#_(.setDebug session true)

(def store (.getStore session "imaps"))

(.connect store "imap.gmail.com" 993 username password)

(def folder (.getFolder (.getDefaultFolder store) "INBOX"))

(.open folder javax.mail.Folder/READ_ONLY)

(.getMessageCount folder)

(def message (.getMessage folder 3))

(.getFrom message)

(.getContent message)

(.getSubject message)

(.getCount (.getContent message))

(.getContentType (.getBodyPart (.getContent message) 0))

(def input-stream (let [body-part (.getBodyPart (.getContent message) 1)]
                    (.getDisposition body-part)
                    body-part
                    #_(.saveFile body-part (java.io.File. "/tmp/x"))
                    (.getInputStream body-part)))

(def zip-input-stream (java.util.zip.ZipInputStream. input-stream))

(def entry (.getNextEntry zip-input-stream))

(def bis (java.io.ByteArrayOutputStream.))

(clojure.java.io/copy zip-input-stream bis)

#_(slurp bis)
