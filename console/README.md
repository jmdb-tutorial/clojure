# console

A simple application that demonstrates a clojure console application.

It was generated using the leingen `new` command...

    $ lein new app console

To build it just type:

    $ lein uberjar

I had to modify the project.clj to get everything to be output into a `target` folder, it looks like this will be fixed in lein version 2.0 but I'm using 1.7 as it is what is in homebrew.

See (https://github.com/technomancy/leiningen/issues/302) for the issue about specifying a target directory.

## Usage

    $ java -jar console-0.1.0-standalone.jar [args]

## Options


## Examples


### Bugs


## License

Copyright © 2012 Jim Barritt

Distributed under the Eclipse Public License, the same as Clojure.
