package by.artsiom.bigdata101.hotels

import org.apache.spark.sql.SparkSession

object Main extends App with Homework {

  val spark = SparkSession.builder
    .master("local[*]")
    .appName("hotels")
    .getOrCreate()

  implicit val test = spark.read
    .option("header", "true")
    .schema(FileSchema)
    .csv("src/test/resources/test.csv")

  task3.show()
  task3.show()
  task3.show()

  spark.stop()
}
