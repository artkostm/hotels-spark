package by.artsiom.bigdata101.hotels

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

trait Homework {
  import Columns._

  /**
    * Find top 3 most popular hotels between couples. (treat hotel as composite key of continent, country and market).
    * @param df
    * @return DataFrame, schema: [hotel_continent: int, hotel_country: int, hotel_market: int, count: long]
    */
  def task1(implicit df: DataFrame): DataFrame =
    popularHotels(df, s"$AdultsCount = 2", 3)

  /**
    * Find the most popular country where hotels are booked and searched from the same country.
    * @param df
    * @return DataFrame, schema: [hotel_country: int, count: long]
    */
  def task2(implicit df: DataFrame): DataFrame =
    df.where(s"$IsBooking = 1 AND $UserCountry = $HotelCountry")
      .groupBy(col(HotelCountry))
      .count()
      .sort(desc(Count))
      .limit(1)

  /**
    * Find top 3 hotels where people with children are interested but not booked in the end.
    * @param df
    * @return DataFrame, schema: [hotel_continent: int, hotel_country: int, hotel_market: int, count: long]
    */
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
      .sort(desc(Count))
      .limit(top)
}
