package com.pluralsight.courses.Scala_Methods_Functions.functions

import com.pluralsight.courses.Scala_Methods_Functions.StockRecord

object HigherOrderFunctionInvocationWithFunctionLiteralBlocks extends App {

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

  val getStockDetails = (ticker: String,
                         extractFunction: (StockRecord) => Float) => {
    val filteredRecords = records.filter(_.ticker == ticker)
    assert(filteredRecords.length == 1)
  }

  def getStockDetails(ticker: String)(extractFunction: (StockRecord) => Float): Float = {
    val filteredRecords = records.filter(_.ticker == ticker)
    assert(filteredRecords.length == 1)

    extractFunction(filteredRecords(0))
  }

  val ttmStockDetails = getStockDetails("TTM", (record: StockRecord) => record.high)
  val ttmStockDetails2 = getStockDetails("TTM") {
    (record: StockRecord) => record.high
  }
  println("------------TTM high")
  println(ttmStockDetails) // "7.19"

  val googStockDetails = getStockDetails("GOOG", (record: StockRecord) => record.low)
  val googStockDetails2 = getStockDetails("GOOG") {
    (record: StockRecord) => record.low
  }
  println("------------GOOG low")
  println(googStockDetails) // "1386.02"

}
