package com.pluralsight.courses.Scala_Methods_Functions
/** A partial function cater to only a SUBSET of possible data for which it has been defined */
object PartialFunctions extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val data = readFinanceData()

//  val printStockRecords: PartialFunction[String, Unit] = new PartialFunction[String, Unit] {
//
//    val recordedTickers = List("MSFT", "GOOG", "TTM", "TM", "DB", "BNS")
//
//    def apply(ticker: String): Unit = {
//      for (lines <- data.filter(_.ticker == ticker)) {
//
//        println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
//      }
//    }
//
//    def isDefinedAt(ticker: String): Boolean = recordedTickers.contains(ticker)
//  }
//
//  if (printStockRecords.isDefinedAt("MSFT")) printStockRecords("MSFT")

  /** Example using match case  */

  val printStockRecords: PartialFunction[String, Unit] = {
    case ticker: String if (List("MSFT", "GOOG", "TTM", "TM", "DB", "BNS").contains(ticker)) =>
      for (lines <- data.filter(_.ticker == ticker)) {
        println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
      }
  }

  // List("DB", "TSLA") map {printStockRecords}
  /** map method does not invoke isDefinedAt when called so ^above causes an Exception^ */
  List("DB", "TSLA") collect {printStockRecords}
  /** collect does so returns DB since Tesla is not recorded */

  /** Combined Partial Functions Example */

  val printTechStocks = new PartialFunction[String, Unit] {
    def apply(ticker: String): Unit = for (lines <- data.filter(_.ticker == ticker)) {
      println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
    }

    def isDefinedAt(ticker: String): Boolean = ticker == "GOOG" || ticker == "MSFT"
  }

  val printMotorStocks = new PartialFunction[String, Unit] {
    def apply(ticker: String): Unit = for (lines <- data.filter(_.ticker == ticker)) {
      println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
    }

    def isDefinedAt(ticker: String): Boolean = ticker == "TM" || ticker == "TTM"
  }

  val printTechOrMotorStocks = printTechStocks orElse printMotorStocks

  printTechOrMotorStocks("TM")
  printTechOrMotorStocks("GOOG")
}
