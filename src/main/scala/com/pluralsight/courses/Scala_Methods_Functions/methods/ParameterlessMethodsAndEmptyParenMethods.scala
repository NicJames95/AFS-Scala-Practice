package com.pluralsight.courses.Scala_Methods_Functions.methods

import com.pluralsight.courses.Scala_Methods_Functions.{GOOGRecord, StockRecord}

/** GOOG File Although works with the stockMarketData File */
object ParameterlessMethodsAndEmptyParenMethods extends App {
  /** Parameterless method - the method takes in no input arguments so we eliminate the parenthesis */
  def financeData(): Vector[StockRecord] = {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  def googleData(): Vector[GOOGRecord] = {
    val source = io.Source.fromFile("src/main/resources/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield GOOGRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)
  }

  /** Parameterless methods are used when an attribute could have been implemented
   * EITHER AS A FIELD OR A METHOD. Based on the "UNIFORM ACCESS PRINCIPLE" client code should NOT
   * be affected by this decision */

  private val data = financeData()
  private val googData = googleData()

  /** An EMPTY-PAREN method is recommended when there are no parameters and the method accesses
   * but does not change mutable state I.E. by reading fields of the contained object */
  // These also could be changed to parameterless vals
  def numberOfRows: Int = data.size
  def numberOfGoogRows: Int = googData.size

  def minimumCloseValue: Double = data.map(_.close).min
  def minimumGoogCloseValue: Double = googData.map(_.close).min

  def maximumCloseValue: Double = data.map(_.close).max
  def maximumGoogCloseValue: Double = googData.map(_.close).max

  def averageCloseValue: Double = data.map(_.close).sum / data.size
  def averageGoogCloseValue: Double = googData.map(_.close).sum / googData.size

  println(s"Number of rows: " + numberOfRows)
  println(s"Minimum close value: " + minimumCloseValue)
  println(s"Maximum close value: " + maximumCloseValue)
  println(s"Average close value: " + averageCloseValue)

  println("-" * 50)

  println(s"Number of google rows: " + numberOfGoogRows)
  println(s"Minimum google close value: " + minimumGoogCloseValue)
  println(s"Maximum close value: " + maximumGoogCloseValue)
  println(s"Average close value: " + averageGoogCloseValue)

}
