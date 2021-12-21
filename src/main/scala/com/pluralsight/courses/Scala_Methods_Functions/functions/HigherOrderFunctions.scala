package com.pluralsight.courses.Scala_Methods_Functions.functions

import com.pluralsight.courses.Scala_Methods_Functions.StockRecord

object HigherOrderFunctions extends App {
  /** First-class functions in Scala allow us to assign functions to variables */
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

  println(records.getClass)

  for (record <- records) {
    println(record)
  }
  println("-" * 100)

  val extractHighPrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.high)
  }

  val extractOpenPrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.open)
  }

  val extractClosePrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.close)
  }

  val extractPriceDelta = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.close - record.open)
  }

  /** HIGHER-ORDER FUNCTIONS accept functions as input arguments, this also means functions are first-class citizens in Scala */
  val extractInfo = (records: Vector[StockRecord],
                     extractFunction: Vector[StockRecord] => Vector[(String, Float)]) => {
    extractFunction(records)
  }

  println("Open: " + extractOpenPrice(records))
  println("Close: " + extractClosePrice(records))
  println("Delta: " + extractPriceDelta(records))
  println("-" * 100)
  println("Opren: " + extractInfo(records, extractOpenPrice))
  println("Close: " + extractInfo(records, extractClosePrice))
  println("Delta: " + extractInfo(records, extractPriceDelta))

  /** Using a case class with methods Example */
  case class StockInformation(records: Vector[StockRecord]) {

    def extractHighPrice(): Vector[(String, Float)] = {
      for (record <- records) yield (record.ticker, record.high)
    }

    def extractOpenPrice(): Vector[(String, Float)] = {
      for (record <- records) yield (record.ticker, record.open)
    }

    def extractClosePrice(): Vector[(String, Float)] = {
      for (record <- records) yield (record.ticker, record.close)
    }

    def extractPriceDelta(): Vector[(String, Float)] = {
      for (record <- records) yield (record.ticker, record.close - record.open)
    }

    def extractInfo(extractFunction: () => Vector[(String, Float)]): Vector[(String, Float)] =
      extractFunction()
  }

  val stockInformation = StockInformation(records)
  println("-" * 100)

  /** Coerce methods to functions when they are passed in as an argument */
  println("Open: " + stockInformation.extractInfo(stockInformation.extractOpenPrice))
  println("Close: " + stockInformation.extractInfo(stockInformation.extractClosePrice))
  println("Delta: " + stockInformation.extractInfo(stockInformation.extractPriceDelta))

  /** Higher Order Functions that returns other functions as result type Example
   * Higher-order functions return functions as the return value */
  val getExtractFunction = (functionName: String, records: Vector[StockRecord]) => {
    if (functionName == "high") {
      () => for (record <- records) yield (record.ticker, record.high)
    } else if (functionName == "open") {
      () => for (record <- records) yield (record.ticker, record.open)
    } else if (functionName == "close") {
      () => for (record <- records) yield (record.ticker, record.close)
    } else {
      () => for (record <- records) yield (record.ticker, record.open - record.close)
    }
  }

  val openFunction = getExtractFunction("open", records)
  val closeFunction = getExtractFunction("close", records)
  val deltaFunction = getExtractFunction("delta", records)
  println("-" * 100)
  println("Open: " + openFunction())
  println("Close: " + closeFunction())
  println("Delta: " + deltaFunction())
}
