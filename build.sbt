name := "Hello World"

version := "1.0"

scalaVersion := "2.10.2"

seq(webSettings : _*)

resolvers += "Spring" at "http://repo.spring.io/libs-milestone"

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.0.0.RC1",
  "org.apache.tomcat.embed" % "tomcat-embed-jasper" % "7.0.47" % "container, compile"
)

