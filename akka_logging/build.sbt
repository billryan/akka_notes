name := "akka_logging"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.12",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.12",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)
