package by.artsiom.bigdata101.hotels

import org.apache.spark.sql.SparkSession

object Main extends App with Homework {

  val spark = SparkSession.builder
    .master("local[*]")
    .appName("hotels")
    .getOrCreate()

  implicit val test = spark.read
    .option("header", "true")
    .option("inferSchema", "true")
    //.schema(schema)
    .csv("D:\\homework\\Hadoop.Intro\\train.csv")

  task1.show()

  task2.show()

  task3.show()

  Thread.sleep(100000)

  spark.stop()
}
