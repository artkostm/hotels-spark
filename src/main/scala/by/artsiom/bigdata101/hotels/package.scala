package by.artsiom.bigdata101

package object hotels {
  lazy val Columns = new {
    val AdultsCount    = "srch_adults_cnt"
    val ChildrenCount  = "srch_children_cnt"
    val IsBooking      = "is_booking"
    val UserCountry    = "user_location_country"
    val HotelContinent = "hotel_continent"
    val HotelCountry   = "hotel_country"
    val HotelMarket    = "hotel_market"
    val Count          = "count"
  }
}
