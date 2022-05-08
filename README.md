# Scala - luzne zadanka

Here I will solve some tasks in [Scala](https://en.wikipedia.org/wiki/Scala_(programming_language)).

No big deal, but who knows maybe I will be hooked in.

# Initial info

Introductory video to Scala from [DevInsideYou](https://www.youtube.com/watch?v=-xRfJcwhy7A)

Initial setup based on the video above, briefly:
- install [coursier](https://github.com/coursier/coursier), instructions [here](https://get-coursier.io/docs/cli-installation)
- run from bash `./sc setup`

Coursier is like package manager for Scala (something like `pip` in python?)

Use:
- scala: type in bash `scala`, basic Scala REPL
- ammonite: type in bash `amm`, better Scala REPL
- scalac: type in bash `scalac [file_name.scala]`, scala compiler
- sbt: will use it for quite some stuff (better scalac?), more info probably [here](https://www.scala-sbt.org/)

## Metals

Additional install:
- Metals: LSP (language server protocol) for Scala, more info probably [here](https://scalameta.org/metals/)

Installing metals via coursier `coursier install metals`

## Sbt

A minimum sbt build:

```bash
mkdir foo-build
cd foo-build
touch build.sbt
```

Start sbt shell: `sbt`

Exit sbt shell: `sbt:foo-build> exit`

Compile code: `sbt:foo-build> compile`

Recompile code at change: `sbt:foo-build> ~compile`

Run the app: `sbt:foo-build> run`

Rerun the app at change: `sbt:foo-build> ~run`

# Additional info

**Do użytku własnego, nie powinno być używane przez nikogo innego.**

**For personal use only, should not be used by anyone else.**
