package com.pluralsight.courses.Scala_Methods_Functions.exceptions

import scala.util.{Failure, Success, Try}
import scala.io.{BufferedSource, Source}
import java.io.{BufferedReader, FileReader}
/** Utility for performing AUTOMATIC RESOURCE MANAGEMENT -
 * after the opereation is complete it releases resources in reverse order of creation */
import scala.util.Using

object TrySuccessFailure extends App {
  /** Represents a computation that may either result in an exception or successfully compute a value */
  def getLinesFromFile(filename: String): Try[BufferedSource] = {
    Try(Source.fromFile(filename))
  }

  val trySourcePath:Try[BufferedSource] =
    getLinesFromFile("src/main/resources/dividendStocks.csv")

  trySourcePath match {
    case Success(sourcePath) => sourcePath.getLines.toList.foreach(println)

    case Failure(exception) => println(exception.getMessage)
  }

//  val lines: List[String] =
//    Using.resource(new BufferedReader(new FileReader(
//      "src/main/resources/dividendStocks.csv"
//    ))) {
//      reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
//    }
//  lines.foreach(println)

  val lines: Try[List[String]] =
    Using(new BufferedReader(new FileReader(
      "src/main/resources/dividendStocks.csv"
    ))) {
      reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
    }
    
  lines match {
    case Success(lines) => lines.foreach(println)
    case Failure(exception) => println(exception.getMessage)
  }  
}
