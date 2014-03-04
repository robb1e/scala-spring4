name := "Hello World"

version := "1.0"

scalaVersion := "2.10.2"

sbtVersion := "0.13.1"

seq(webSettings : _*)

libraryDependencies ++= Seq(
  "org.springframework" % "spring-webmvc" % "4.0.0.RELEASE",
  "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container, compile",
  "org.eclipse.jetty" % "jetty-jsp" % "9.1.0.v20131115" % "container"
)

