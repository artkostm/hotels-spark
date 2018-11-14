name := "hotels-spark"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Dependencies.main
libraryDependencies ++= Dependencies.test
dependencyOverrides ++= Dependencies.overrides

enablePlugins(JavaAppPackaging)

mainClass in Compile := Some("by.artsiom.bigdata101.hotels.Main")
