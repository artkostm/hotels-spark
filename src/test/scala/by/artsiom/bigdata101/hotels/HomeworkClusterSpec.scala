package by.artsiom.bigdata101.hotels

import java.net.URI

import by.artsiom.bigdata101.hotels.cluster.DockerSparkService
import com.whisk.docker.impl.spotify.DockerKitSpotify
import org.apache.spark.sql.SparkSession
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.time.{Second, Seconds, Span}

class HomeworkClusterSpec extends FlatSpec with Matchers with DockerKitSpotify with DockerSparkService {
  implicit val pc = PatienceConfig(Span(20, Seconds), Span(1, Second))

  "spark cluster" should "be ready for job submitting" in {
    dockerContainers.map(_.name).foreach(println)
    dockerContainers.forall(c => isContainerReady(c).futureValue) shouldBe true
  }

  "all tasks" should "return correct result" in {
    val spark = SparkSession.builder
      .master(s"spark://${new URI(sys.env("DOCKER_HOST")).getHost}:7077")
      .config("spark.submit.deployMode", "client")
      .appName("hotels")
      .getOrCreate()

    implicit val test = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("src/test/resources/test.csv")

    val homework = new Homework {}

    /**
      * +---------------+-------------+------------+-----+
      * |hotel_continent|hotel_country|hotel_market|count|
      * +---------------+-------------+------------+-----+
      * |              6|          105|          29|   42|
      * |              3|          151|          69|   37|
      * |              2|           50|         675|   12|
      * +---------------+-------------+------------+-----+
      */
    val result1 = homework.task1.collect()

    /**
      * +-------------+-----+
      * |hotel_country|count|
      * +-------------+-----+
      * |           66|    1|
      * +-------------+-----+
      */
    val result2 = homework.task2.collect()

    /**
      * +---------------+-------------+------------+-----+
      * |hotel_continent|hotel_country|hotel_market|count|
      * +---------------+-------------+------------+-----+
      * |              6|          204|        1776|    4|
      * +---------------+-------------+------------+-----+
      */
    val result3 = homework.task3.collect()

    assert(result1.size == 3)
    assert(result2.size == 1)
    assert(result3.size == 1)
  }
}
