(defproject structure "0.1.0-SNAPSHOT"
  :description     "FIXME: write description"
  :url             "http://example.com/FIXME"

  :license         {:name "Eclipse Public License"
                    :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies    [[org.clojure/clojure "1.11.1"]
                    [midje "1.10.9"]
                    [org.clojure/math.numeric-tower "0.0.5"]
                    [org.clojure/core.async "1.6.681"]
                    [incanter "1.9.3" :exclusions [org.clojure/clojure]] ;; See https://github.com/technomancy/leiningen/issues/2240
                    ]

  :profiles        {:dev
                    {:plugins [[lein-midje "3.2.1"]]}
                     :dependencies []
                     :repositories {}}

  :main            structure.core)
