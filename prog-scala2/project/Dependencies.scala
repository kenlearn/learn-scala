import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4"
  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.5.8"
  
  // https://mvnrepository.com/artifact/org.scala-lang.modules/scala-async
  lazy val scalaAsync = "org.scala-lang.modules" %% "scala-async" % "0.9.6"

  // https://mvnrepository.com/artifact/com.typesafe.akka/akka-slf4j
  lazy val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % "2.5.8"

  // https://mvnrepository.com/artifact/ch.qos.logback/logback-core
  lazy val logback = "ch.qos.logback" % "logback-core" % "1.2.3"

  // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
  lazy val slf4jSimple = "org.slf4j" % "slf4j-simple" % "1.7.25"

}
