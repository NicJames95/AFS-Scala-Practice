package com.pluralsight.courses.Scala_Methods_Functions.methods

import com.pluralsight.courses.Scala_Methods_Functions.StockRecord

/** Assert is not working */
object MethodEvaluationStrategies extends App {

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

  /** CALL BY VALUE is the strict evaluation strategy that Scala uses by default,
   * here the expressions corresponding to INPUT ARGUMENTS ARE EVALUATED BEFORE THE FUNCTION BODY IS EXECUTED */
  /* def makeMomentumBasedTradingDecision(record: StockRecord, percentDelta: Float): Unit = { */

  /** CALL BY NAME is the non-strict evaluation strategy in Scala,
   * here the expressions corresponding to INPUT ARGUMENTS ARE EVALUATED ONLY WHEN THE PROGRAM NEEDS IT */
  def makeMomentumBasedTradingDecision(record: => StockRecord, percentDelta: Float): Unit = {

    println(s"Calculating percentage move")

    lazy val stockRecord = record

    val percentageMove = ((stockRecord.close - stockRecord.open) / stockRecord.open) * 100;

    if (percentageMove > percentDelta) {
      println(s"Buy ${stockRecord.ticker}")
    } else if (percentageMove < -percentDelta) {
      println(s"Sell ${stockRecord.ticker}")
    } else {
      println(s"No call on ${stockRecord.ticker}")
    }
  }

  def getRecord(ticker: String): StockRecord = {
    println(s"Accessing Record for ${ticker}")
    val filteredRecords = records.filter(_.ticker == ticker)
    assert(filteredRecords.length == 1)

    filteredRecords(0)
  }

  /** CALL BY VALUE RESULTS */
  println("-" * 50)
  makeMomentumBasedTradingDecision(getRecord("MSFT"), 1)

  /** Returns Accessing record for MSFT
   * Calculating percentage move
   * Sell MSFT */
  println("-" * 50)
  makeMomentumBasedTradingDecision(getRecord("TM"), 1)

  /** Accessing record for TM
   * Calculating percentage move
   * No call on TM */

  /** CALL BY NAME RESULTS */
  println("-" * 50)
  makeMomentumBasedTradingDecision(getRecord("MSFT"), 1)

  /** Calculating percentage move
   * Accessing record for MSFT
   * Accessing record for MSFT
   * Accessing record for MSFT
   * Accessing record for MSFT
   * Sell MSFT */
  println("-" * 50)
  makeMomentumBasedTradingDecision(getRecord("TM"), 1)

  /** Calculating percentage move
   * Accessing record for TM
   * Accessing record for TM
   * Accessing record for TM
   * Accessing record for TM
   * No call on TM */

  /** CALL BY NAME USING LAZY VAL */
  println("-" * 50)
  makeMomentumBasedTradingDecision(getRecord("MSFT"), 1)

  /** Returns Accessing record for MSFT
   * Calculating percentage move
   * Sell MSFT */
  println("-" * 50)
  makeMomentumBasedTradingDecision(getRecord("TM"), 1)

  /** Accessing record for TM
   * Calculating percentage move
   * No call on TM */
}
