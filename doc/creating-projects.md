Creating Projects with Leiningen
================================

The easiest way to create a new project for clojure is to use Leiningen (https://github.com/technomancy/leiningen).

Install leiningen using homebrew (http://mxcl.github.com/homebrew/).

Simply navigate into place where you want to create the project and type:

`lein new`

The `new` command takes a template parameter which will create projects of different types.

You can see what kinds of project you can create by typing:

`lein help new`

At the time of writing this was:

    template   A meta-template for 'lein new' templates.
    app        An application project template.
    plugin     A leiningen plugin project template.
    default    A general project template for libraries.
    pallet     A Pallet project template. The template requires a project name, and an

