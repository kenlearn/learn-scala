import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "me.kenqcl",
      scalaVersion := "2.12.4",
      version      := "0.1.0"
    )),
    name := "progsc2",
    // mainClass in (Compile, run) := Some("ch01.Upper"),

    libraryDependencies ++= Seq(
      scalaTest,
      akkaActor,
      scalaAsync,
      akkaSlf4j,
      slf4jSimple,
      logback
    )
  )
