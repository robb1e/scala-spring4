name := "Hello World"

version := "1.0"

scalaVersion := "2.10.2"

resolvers += "Spring" at "http://repo.spring.io/libs-snapshot"

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.0.0.BUILD-SNAPSHOT",
  "org.springframework.boot" % "spring-boot-starter-thymeleaf" % "1.0.0.BUILD-SNAPSHOT"
)

