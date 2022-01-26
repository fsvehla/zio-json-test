ThisBuild / organization := "io.fsvehla"
ThisBuild / scalaVersion := "2.13.7"

ThisBuild / turbo                 := true
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger

lazy val `zio-json-test` = (project in file(".")).
  settings(
    name := "zio-json-test",
    crossScalaVersions := Vector("2.13.7", "3.1.0"),

    libraryDependencies ++= List(
      "dev.zio" %% "zio"          % Versions.zio,
      "dev.zio" %% "zio-json"     % Versions.zioJson,
      "dev.zio" %% "zio-streams"  % Versions.zio,
      "dev.zio" %% "zio-test"     % Versions.zio % Test,
      "dev.zio" %% "zio-test-sbt" % Versions.zio % Test
    ),

    testFrameworks ++= Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
    publishArtifact := false,

    scalacOptions ++= Vector(
      "-encoding", "UTF-8",
      "-feature",                      // Emit warning and location for usages of features that should be imported explicitly.
      "-language:implicitConversions", // Allow implicit conversions
      "-language:higherKinds",         // Allow higher kinded types
    )
  )
