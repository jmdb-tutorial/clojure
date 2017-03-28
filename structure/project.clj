(defproject structure "0.1.0-SNAPSHOT"
  :description     "FIXME: write description"
  :url             "http://example.com/FIXME"

  :license         {:name "Eclipse Public License"
                    :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies    [[org.clojure/clojure "1.8.0"]
                    [midje "1.8.3"]]

  :profiles        {:dev
                    {:plugins [[lein-midje "3.2.1"]]}
                     :dependencies []
                     :repositories {}}

  :main            structure.core)
