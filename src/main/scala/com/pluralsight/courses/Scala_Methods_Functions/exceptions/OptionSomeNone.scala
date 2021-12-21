package com.pluralsight.courses.Scala_Methods_Functions.exceptions

object OptionSomeNone extends App {

//  def convertToFloat(someString: String): Any = {
//    try {
//      val floatVal = someString.toFloat
//
//      floatVal
//    } catch {
//      case e: NumberFormatException => null
//    }
//  }

  /** An Option can be an instance of the Some class or the None class -
   * Some and None are both children of Option */
  def convertToFloat(someString: String): Option[Float] = {
    try {
      Some(someString.toFloat)
    } catch {
      case e:NumberFormatException => None
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf",
  "1393.33", "1404.31", "1419.82", "1429.73")

  val googStockPricesFloat = googStockPrices.map(convertToFloat)

  /** The flatMap() combinator automatically just maps the valid values
   * so the result can be used directly in mathematical expressions */
//  println("Average price: " + (googStockPricesFloat.sum / googStockPricesFloat.size))

  println(googStockPricesFloat.map(_.getOrElse(0)))

//  for (optionPrice <- googStockPricesFloat) {
//    println(optionPrice.getOrElse(-1))
//  }

//  for (optionPrice <- googStockPricesFloat) {
//    optionPrice match {
//      case Some(price) => println(price)
//      case None => println("Skipping over None")
//    }
//  }

}
