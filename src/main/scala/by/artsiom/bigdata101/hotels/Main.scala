package by.artsiom.bigdata101.hotels

import java.net.URI

import org.apache.spark.sql.SparkSession

object Main extends App with Homework {

  val spark = SparkSession.builder
    .master(s"spark://${new URI(sys.env("DOCKER_HOST")).getHost}:7077")
    .appName("hotels")
    .getOrCreate()

  implicit val test = spark.read
    .option("header", "true")
    .option("inferSchema", "true")
    //.schema(schema)
    .csv("src/test/resources/test.csv") //D:\homework\Hadoop.Intro\train.csv

  task1.explain(true)

//  task2.explain(true)
//
//  task3.explain(true)

  spark.stop()
}
