package com.pluralsight.courses.Scala_Methods_Functions.methods

import com.pluralsight.courses.Scala_Methods_Functions.StockRecord

object Currying extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  /** A CURRIED function has multiple argument lists -
   * this is equivalent to multiple function invocations back to back.
   * The first function accepts 2 arguments, the second function accepts one. */
  def getPrice(date: String)(ticker: String)(priceType: String): Float = {
    val recordsByDate = records.filter(_.date == date)
    val recordsByTicker = recordsByDate.filter(_.ticker == ticker)

    val price = priceType match {
      case "open" => recordsByTicker(0).open
      case "close" => recordsByTicker(0).close
      case "high" => recordsByTicker(0).high
      case "low" => recordsByTicker(0).low
    }
    price
  }

  /** The placeholder notation allows us to see the curried function as a partially applied function */
  val getPriceForGoog = getPrice("12-06-2020")("GOOG") _
  println("-----------------------GOOG")
  println("Open: " + getPriceForGoog("open"))
  println("Close: " + getPriceForGoog("close"))
  println("High: " + getPriceForGoog("high"))
  println("Low: " + getPriceForGoog("low"))

  val getPriceForMsft = getPrice("12-06-2020")("MSFT") _
  println("-----------------------MSFT")
  println("Open: " + getPriceForMsft("open"))
  println("Close: " + getPriceForMsft("close"))
  println("High: " + getPriceForMsft("high"))
  println("Low: " + getPriceForMsft("low"))

  val getPriceForDeutsche = getPrice("12-06-2020") _

  println("-------------------------DB")
  println("Open: " + getPriceForDeutsche("DB")("open"))
  println("Close: " + getPriceForDeutsche("DB")("close"))
  println("High: " + getPriceForDeutsche("DB")("high"))
  println("Low: " + getPriceForDeutsche("DB")("low"))

  val getPriceForToyota = getPrice("12-06-2020")("TM") _
  println("-------------------------TM")
  println("Open: " + getPriceForToyota("open"))
  println("Close: " + getPriceForToyota("close"))
  println("High: " + getPriceForToyota("high"))
  println("Low: " + getPriceForToyota("low"))
}
