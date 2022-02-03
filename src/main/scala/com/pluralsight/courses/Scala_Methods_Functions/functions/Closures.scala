package com.pluralsight.courses.Scala_Methods_Functions.functions

import com.pluralsight.courses.Scala_Methods_Functions.GOOGRecord

object Closures extends App {

  def readFinanceData(): Vector[GOOGRecord] = {
    val source = io.Source.fromFile("src/main/resources/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield GOOGRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)

    /** cols(5).toFloat,
     * cols(6).toDouble DO NOT HAVE THE GOOG FILE */
  }

  val data = readFinanceData()

  val getDecisionMakerFunction = (records: Vector[GOOGRecord], date: String) => {

    val currDate = date
    val currRecords = records

    /** The function value created at runtime from this function literal is called a CLOSURE
     * where the values of the FREE VARIABLES referenced from within the function are captured */
    val makeDecision = (percentDelta: Float) => {
      val filteredRecords = currRecords.filter(_.date == currDate)
      assert(filteredRecords.length == 1)

      val record = filteredRecords.head

      val percentageMove = ((record.close - record.open) / record.open) * 100

      if (percentageMove > percentDelta) {
        println(s"Buy based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      } else if (percentageMove < -percentDelta) {
        println(s"Sell based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      } else {
        println(s"No call based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      }
    }

    /** This returned function is a closure which contains references to values defined outside the function */
    makeDecision
  }

  println("-" * 50)
  val decisionMaker = getDecisionMakerFunction(data, "2020-01-13")
  decisionMaker(5) // No call based on date "2020-05-15, percentage move 1.7177734"

  val decisionMaker2 = getDecisionMakerFunction(data, "2020-01-02")
  decisionMaker2(0) // Buy based on date "2020-03-18, percentage move 3.813503"
}
