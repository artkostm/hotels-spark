import sbt._

object Dependencies {
  val versions = new {
    val spark = "2.4.0"

    val scalaTest  = "3.0.5"
    val scalaCheck = "1.14.0"
    val scalaMock  = "4.1.0"
  }

  lazy val main = Seq(
    "org.apache.spark" %% "spark-core" % versions.spark,
    "org.apache.spark" %% "spark-sql"  % versions.spark
  )

  lazy val test = Seq(
    "org.scalatest"  %% "scalatest"  % versions.scalaTest,
    "org.scalacheck" %% "scalacheck" % versions.scalaCheck,
    "org.scalamock"  %% "scalamock"  % versions.scalaMock
  ).map(_ % Test)
}
