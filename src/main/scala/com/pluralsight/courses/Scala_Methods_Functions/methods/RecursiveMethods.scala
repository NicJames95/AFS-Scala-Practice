package com.pluralsight.courses.Scala_Methods_Functions.methods

import com.pluralsight.courses.Scala_Methods_Functions.StockRecord

import scala.annotation.tailrec

/** Supposed to use GOOG.csv */
object RecursiveMethods extends App {

  def readFinanceData(): Vector[StockRecord] = {
    val source = io.Source.fromFile("src/main/resources/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  private val data = readFinanceData()

  def rollingAverage(numDays: Int): Unit = {
    /** Using VAR rather than VAL makes the program less functional and more imperative */
    var records = readFinanceData();
    while (records.length >= numDays) {
      val averageClose = records.map(_.close).take(numDays).sum / numDays
      println(s"Rolling average close for $numDays days " + 
        s"date ${records.head.date}: $averageClose")

      records = records.drop(1)
    }
    println("Execution Completed !")
  }


  /** A new stack frame will not be built for each recursive call -
   * all calls will be exectuted in a SINGLE STACK FRAME
   * by simply updating the input arguments to the recursive call */
  @tailrec
  def rollingAverage(records: Vector[StockRecord], numDays: Int): Unit = {

    if (records.length < numDays) {
      println("Execution Completed !")
    } else {

      val averageClose = records.map(_.close).take(numDays).sum / numDays

      println(s"Rolling average close for $numDays days " +
        s"date ${records.head.date}: $averageClose")

      val updatedRecords = records.drop(1)
      rollingAverage(updatedRecords, numDays)

      /** In order to apply the tail recursion optimization,
       * the recursive call has to be the LAST CALL in a method */
    }
  }

  rollingAverage(readFinanceData(), 7)


}
