# Spring4 with Scala

## Installation

You will need `sbt` which is the project builder, if on a Mac you can:

    brew install sbt

## Running

To run the webapp you use sbt, although it can be a memory hog so you might want to add this to your environment

    export SBT_OPTS=-XX:MaxPermSize=2048M

Then run like from within `sbt`

    container:start

This will start the application in an embedded Jetty web container.

## Packaging

To build a deployable file (WAR - Web ARchive) you can run `sbt` and run the following command:

    package

## IntelliJ

There is a plugin which will build IntelliJ project files, run `sbt` and run the following command

    gen-idea
