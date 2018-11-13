package by.artsiom.bigdata101.hotels

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col

trait Homework {
  import Columns._

  def task1(implicit df: DataFrame): DataFrame =
    popularHotels(df, s"$AdultsCount = 2", 3)

  def task2(implicit df: DataFrame): DataFrame =
    df.where(s"$IsBooking = 1 AND $UserCountry = $HotelCountry")
      .groupBy(col(HotelCountry))
      .count()
      .orderBy(col(Count).desc)
      .limit(1)

  def task3(implicit df: DataFrame): DataFrame =
    popularHotels(df, s"$ChildrenCount > 0 AND $IsBooking = 0", 3)

  private def popularHotels(df: DataFrame, conditionExpr: String, top: Int): DataFrame =
    df.where(conditionExpr)
      .groupBy(
        col(HotelContinent),
        col(HotelCountry),
        col(HotelMarket)
      )
      .count()
      .orderBy(col(Count).desc)
      .limit(top)
}
