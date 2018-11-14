package by.artsiom.bigdata101.hotels

import com.whisk.docker.impl.spotify.DockerKitSpotify
import org.apache.spark.sql.SparkSession
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.time.{Second, Seconds, Span}

class PingPongSpec extends FlatSpec with Matchers with DockerKitSpotify with DockerSparkService {
  implicit val pc = PatienceConfig(Span(20, Seconds), Span(1, Second))

  "all containers" should "be ready at the same time" in {
    println("hello")
    dockerContainers.map(_.name).foreach(println)
    dockerContainers.forall(c => {
      val future = isContainerReady(c).futureValue
      future
    }) shouldBe true

    Thread.sleep(5 * 60 * 1000)

//    val spark = SparkSession.builder
//      .master("local[*]")
//      .appName("hotels")
//      .getOrCreate()
//
//    implicit val test = spark.read
//      .option("header", "true")
//      .option("inferSchema", "true")
//      //.schema(schema)
//      .csv("src/test/resources/test.csv")//D:\homework\Hadoop.Intro\train.csv
  }
}
