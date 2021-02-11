name := """karumi"""
organization := "com.karumi.blog"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"
val slickVersion   = "3.3.2"

libraryDependencies ++=  Seq( guice, ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "com.typesafe.slick" %% "slick" % slickVersion,
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
  "io.jvm.uuid" %% "scala-uuid" % "0.3.1",
  "mysql" % "mysql-connector-java" % "6.0.6"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.karumi.blog.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.karumi.blog.binders._"
