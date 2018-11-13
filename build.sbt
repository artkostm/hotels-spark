name := "hotels-spark"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Dependencies.main
libraryDependencies ++= Dependencies.test

enablePlugins(JavaAppPackaging)

mainClass in Compile := Some("by.artsiom.bigdata101.hotels.Main")
