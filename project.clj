(defproject mail-xls-sheets-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.google.api-client/google-api-client "1.22.0"]
                 [com.google.oauth-client/google-oauth-client-jetty "1.22.0"]
                 [com.google.apis/google-api-services-sheets "v4-rev478-1.22.0"]
                 [com.sun.mail/javax.mail "1.6.0-rc2"]
                 [com.icegreen/greenmail "1.5.5"]
                 [org.apache.poi/poi-ooxml "3.16"]]
  :main ^:skip-aot mail-xls-sheets-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
