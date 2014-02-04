# Spring4 with Scala

## Setup

### Installation

You will need `sbt` which is the project builder, if on a Mac you can:

    brew install sbt

### Running

To run the webapp you use sbt, although it can be a memory hog so you might want to add this to your environment

    export SBT_OPTS=-XX:MaxPermSize=2048M

Then run like from within `sbt`

    container:start

This will start the application in an embedded Jetty web container.

### Packaging

To build a deployable file (WAR - Web ARchive) you can run `sbt` and run the following command:

    package

### IntelliJ

There is a plugin which will build IntelliJ project files, run `sbt` and run the following command

    gen-idea

# Why?

In my previous job at [The Guardian](http://www.guardian.co.uk) I used Scala on various projects and enjoyed it. We employed various [dependency injection](http://en.wikipedia.org/wiki/Dependency_injection) (DI) frameworks from [Spring](http://spring.io), [Guice](http://code.google.com/p/google-guice/) and a lightweight homegrow pattern. Now I'm at [Pivotal Labs](http://www.pivotallabs.com) Spring is part of [the family](http://www.gopivotal.com) and some recent [JVM](http://en.wikipedia.org/wiki/Java_virtual_machine) projects combined with the recent release of [Spring 4](http://spring.io/blog/2013/12/12/announcing-spring-framework-4-0-ga-release) means we've been looking at how these tools can help our clients.

I think there's a natural tendency when you hear 'Spring' to think 'Java', but I wanted to show that this isn't the case anymore, and I'm going to walk through a simple web application using Scala and Spring 4. Here's the toolset I'm using in this demo:

* [SBT](http://www.scala-sbt.org/)
* [Jetty](http://www.eclipse.org/jetty/)
* [Spring](http://spring.io)
* [Scala](http://www.scala-lang.org/)

## Project setup

So first off, you'll notice I'm not using [Maven](http://maven.apache.org/) or [Gradle](http://www.gradle.org/) but SBT. This is the `build.sbt` file which outlines the name and version of the application along with the Scala version. It pulls in the `webSettings` from a plugin which I'll drop into in a moment. Then it outlines the dependencies, `spring-mvc` for the web component of the application, `jetty-container` is required for the complication and runtime while `jetty-jsp` is only required for the runtime used by the plugin. 


    name := "Hello World"

    version := "1.0"

    scalaVersion := "2.10.2"

    seq(webSettings : _*)

      libraryDependencies ++= Seq(
          "org.springframework" % "spring-webmvc" % "4.0.0.RELEASE",
          "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container, compile",
          "org.eclipse.jetty" % "jetty-jsp" % "9.1.0.v20131115" % "container"
          )

In `projects/plugins.sbt` there are two plugins, one for running the web application within SBT and the other to create [IntelliJ](http://www.jetbrains.com/idea/) project files.

    addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.6.0")

    addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

The project uses the 'standard' Java convention of having a `src` folder at the root, followed by `webapp` which includes the web application configuration and static resources as well as the source folder called `scala`. Within the `scala` directory there is a namespaced directory structure of `com/robb1e/helloworld` although in Scala unlike in Java there is not a one to one mapping of file to classname. But let's first head into `webapp/WEB-INF/web.xml`. This is the deployment descriptor from the [Servlet standard](http://en.wikipedia.org/wiki/Java_Servlet). 

## Configuration

We essentially are telling Spring to handle all HTTP requests from the root context (i.e. '/'). We are also passing a reference to a configuration class, in this case `com.robb1e.helloworld.Config`. 

This configuration uses Spring annotations `@ComponentScan` to declare which package to look for Spring wiring to occur in. The `@Bean` annotation makes the `viewResolver` available which is required by the controller to render HTML.

    package com.robb1e.helloworld

    import org.springframework.context.annotation.{Bean, ComponentScan}
    import org.springframework.web.servlet.view.{InternalResourceViewResolver, JstlView}

    @ComponentScan(basePackages = Array("com.robb1e.helloworld"))
    class Config {

        @Bean
        def viewResolver = {
            val viewResolver = new InternalResourceViewResolver
            viewResolver.setViewClass(classOf[JstlView])
            viewResolver.setPrefix("/WEB-INF/views/")
            viewResolver.setSuffix(".jsp")
            viewResolver
        }

    }

See this great writeup for more on [Spring MVC Configuration](http://www.luckyryan.com/2013/02/07/migrate-spring-mvc-servlet-xml-to-java-config/).

## Dependencies

To show a simple dependency this example includes a 'service' which provides the name to render in HTML.

    package com.robb1e.helloworld

    import org.springframework.stereotype.Service

    trait HelloWorldName {
      def name: String
    }

    @Service
    class HelloWorldService extends HelloWorldName {

      def name = "world"

    }

The `trait` isn't strictly required, but enables me to introduce the comparison between [Java Interfaces](http://docs.oracle.com/javase/tutorial/java/concepts/interface.html).








