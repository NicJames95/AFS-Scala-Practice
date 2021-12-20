package com.pluralsight.courses.Scala_Methods_Functions

object PartiallyAppliedFunctions extends App{

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73)

  def checkPriceGreaterThan1400(price: Double): Boolean = price > 1400
  val checkPricesGreaterThan1400Function = checkPriceGreaterThan1400 _

  val googStockPricesGreaterThan1400 =
    googStockPrices.filter((price) => checkPriceGreaterThan1400(price))
    googStockPrices.filter(checkPriceGreaterThan1400 _)
    /** The "_" is a placeholder for an entire parameter list. This is a PARTIALLY APPLIED FUNCTION,
     * where you do not supply all of the arguments the function needs, you specify either SOME OR NONE OF THE ARGUMENTS */
    googStockPrices.filter(checkPriceGreaterThan1400)
    /** A partially applied function where you leave off all parameters can be expressed in this concise way */
    googStockPrices.filter(checkPricesGreaterThan1400Function)
  println(googStockPricesGreaterThan1400)

  def checkPriceInRange(price: Double, lower: Double, upper: Double): Boolean =
    price >= lower && price <= upper

  val googStockPricesInRangeFunction = checkPriceInRange _
  val googStockPricesInRangeFunction2 =
    checkPriceInRange(_: Double, _: Double, 1410)
  val googStockPricesInRangeFunction3 =
    checkPriceInRange(_: Double, 1390, 1410)

  val googStockPricesInRange =
    googStockPrices.filter((price) => googStockPricesInRangeFunction(price, 1390, 1410))
    googStockPrices.filter((price) => googStockPricesInRangeFunction2(price, 1390))
    googStockPrices.filter(googStockPricesInRangeFunction3)
  println(googStockPricesInRange)
}
