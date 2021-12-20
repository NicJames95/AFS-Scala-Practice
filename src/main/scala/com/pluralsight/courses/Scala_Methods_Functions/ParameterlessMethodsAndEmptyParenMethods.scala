package com.pluralsight.courses.Scala_Methods_Functions
/** GOOG File Although works with the stockMarketData File  */
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

  /** Parameterless methods are used when an attribute could have been implemented
   * EITHER AS A FIELD OR A METHOD. Based on the "UNIFORM ACCESS PRINCIPLE" client code should NOT
   * be affected by this decision*/

  private val data = financeData()

  /** An EMPTY-PAREN method is recommended when there are no parameters and the method accesses
   * but does not change mutable state I.E. by reading fields of the contained object */
  // These also could be changed to parameterless vals
  def numberOfRows: Int = data.size
  def minimumCloseValue: Double = data.map(_.close).min
  def maximumCloseValue: Double = data.map(_.close).max
  def averageCloseValue: Double = data.map(_.close).sum / data.size

  println(s"Number of rows: " + numberOfRows)
  println(s"Minimum close value: " + minimumCloseValue)
  println(s"Maximum close value: " + maximumCloseValue)
  println(s"Average close value: " + averageCloseValue)

}
