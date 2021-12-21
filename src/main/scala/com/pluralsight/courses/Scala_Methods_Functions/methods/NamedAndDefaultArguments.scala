package com.pluralsight.courses.Scala_Methods_Functions.methods

import com.pluralsight.courses.Scala_Methods_Functions.StockRecord

object NamedAndDefaultArguments extends App {

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

  /** For every parameter with a default argument Scala generates a SYNTHETIC METHOD which computes the default,
   * missing parameters are added to the argument list as calls to these synthetic methods */
  def getStockPriceDetails(date: String = "11-06-2020", ticker: String, priceType: String):
  (String, String, Float) = {

    println(s"Accessing records for ${date}")
    var filteredRecords = records.filter(_.date == date)

    println(s"Accessing records for ${ticker}")
    filteredRecords = filteredRecords.filter(_.ticker == ticker)

    val record = filteredRecords(0)

    println(s"Accessing price type ${priceType}")
    val price = priceType match {
      case "open" => record.open
      case "close" => record.close
      case "high" => record.high
      case "low" => record.low
    }

    (record.date, record.ticker, price)
  }

  /** POSITIONAL ARGUMENT values are assigned based on position or order in which arguments are specified */
  println(getStockPriceDetails("12-06-2020", "BNS", "open"))
  println(getStockPriceDetails(priceType = "close", ticker = "MSFT", date = "11-06-2020"))

  /** Values for arguments after the one which has the default value have to be
   * specified as named arguments */
  println(getStockPriceDetails(ticker = "GOOG", priceType = "high"))

  def getCurriedStockPriceDetails(date: String = "11-06-2020")(ticker: String = "GOOG")(priceType: String):
  (String, String, Float) = {

    println(s"Accessing records for ${date}")
    var filteredRecords = records.filter(_.date == date)

    println(s"Accessing records for ${ticker}")
    filteredRecords = filteredRecords.filter(_.ticker == ticker)

    val record = filteredRecords(0)

    println(s"Accessing price type ${priceType}")
    val price = priceType match {
      case "open" => record.open
      case "close" => record.close
      case "high" => record.high
      case "low" => record.low
    }

    (record.date, record.ticker, price)
  }

  println(getCurriedStockPriceDetails(date = "12-06-2020")(ticker = "DB")(priceType = "high"))
  println(getCurriedStockPriceDetails()("TM")("low"))
  println(getCurriedStockPriceDetails()()("close"))
}
