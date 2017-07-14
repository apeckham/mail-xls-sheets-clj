(ns mail-xls-sheets-clj.sheets
  (:require clojure.java.io)
  (:import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
           com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
           com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
           com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
           com.google.api.client.json.jackson2.JacksonFactory
           com.google.api.client.util.store.FileDataStoreFactory
           com.google.api.services.sheets.v4.SheetsScopes))

(import com.google.api.services.sheets.v4.Sheets$Builder)
(import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow$Builder)

(def http-transport (GoogleNetHttpTransport/newTrustedTransport))
(def json-factory (JacksonFactory/getDefaultInstance))
(def client-secrets (GoogleClientSecrets/load json-factory (clojure.java.io/reader "client_id.json")))
(def scopes (Collections/singleton SheetsScopes/SPREADSHEETS_READONLY))

(def flow (-> http-transport
              (GoogleAuthorizationCodeFlow$Builder. json-factory client-secrets scopes)
              (.setDataStoreFactory (FileDataStoreFactory. (clojure.java.io/file "/tmp/.creds")))
              (.setAccessType "offline")
              .build))

(def cred (.authorize (AuthorizationCodeInstalledApp. flow (LocalServerReceiver.)) "user"))

(def svc (-> http-transport
             (Sheets$Builder. json-factory cred)
             (.setApplicationName "test")
             .build))

(def response (-> svc
                  .spreadsheets
                  .values
                  (.get "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms" "Class Data!A2:E")
                  .execute))

(prn response)
