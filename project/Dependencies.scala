import sbt._

object Dependencies {
  val versions = new {
    val spark = "2.3.2"

    val scalaTest     = "3.0.5"
    val scalaCheck    = "1.14.0"
    val scalaMock     = "4.1.0"
    val dockerTestkit = "0.9.8"
  }

  lazy val main = Seq(
    "org.apache.spark" %% "spark-core" % versions.spark,
    "org.apache.spark" %% "spark-sql"  % versions.spark
  )

  lazy val test = Seq(
    "org.scalatest"  %% "scalatest"                   % versions.scalaTest,
    "org.scalacheck" %% "scalacheck"                  % versions.scalaCheck,
    "org.scalamock"  %% "scalamock"                   % versions.scalaMock,
    "com.whisk"      %% "docker-testkit-scalatest"    % versions.dockerTestkit,
    "com.whisk"      %% "docker-testkit-impl-spotify" % versions.dockerTestkit
  ).map(_ % Test)

  lazy val overrides = Seq(
    "com.google.guava" % "guava" % "20.0"
  )
}
