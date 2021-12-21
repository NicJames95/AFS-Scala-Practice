package com.pluralsight.courses.Scala_Methods_Functions.exceptions
/** Try-Success-Failure can be used to pipeline or chain
 * operations catching exceptions along the way */
import scala.io.StdIn
import scala.util.{Failure, Success, Try}
import com.pluralsight.courses.Scala_Methods_Functions.DividendRecord

object TrySuccessFailureWithCombinators extends App {

  def readCSVFile(filePath: String): Seq[DividendRecord] = {
    val source = io.Source.fromFile(filePath)

    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield DividendRecord(cols(0), cols(1), cols(2).toFloat, cols(3).toFloat)
  }

  val records = readCSVFile("src/main/resources/dividendStocks.csv")

  @scala.annotation.tailrec
  def calculateDividendYield(): Try[Double] = {

    val ticker = StdIn.readLine("Enter ticker: ")
    val currentPrice = Try(StdIn.readLine("Enter current price: ").toDouble)

    val faceValue: Try[Double] = Try(
      records.filter(_.ticker == ticker).map(_.face_value).head.toDouble)
    val dividendRate: Try[Double] = Try(
      records.filter(_.ticker == ticker).map(_.dividend).head * 0.01)
    /** Combinators such as map() and flatMap() either pass off a
     * successful computation wrapped in a Success type
     * or an exception wrapped in a Failure type further down the chained pipeline*/

    val dividendPerShare: Try[Double] = faceValue.flatMap(
      fv => dividendRate.map(divRate => fv * divRate))
    val dividendYield: Try[Double] = dividendPerShare.flatMap(
      divPerShare => currentPrice.map(currPrice => divPerShare / currPrice * 100))

    dividendYield match {
      case Success(divYield) =>
        println(s"Dividend yield of $ticker is: ${divYield}%")
        Success(divYield)

      case Failure(exception) =>
        println("----" + exception.getMessage)
        println("An error occurred along the way, try again!")
        calculateDividendYield()
    }
  }

  calculateDividendYield()

}
