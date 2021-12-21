package com.pluralsight.courses.Scala_Methods_Functions.functions

import com.pluralsight.courses.Scala_Methods_Functions.StockRecord

object FunctionLiteralsAndPlaceholders extends App {
  /** Function literals in the source code get compiled into a class that is instantiated at runtime */
  var multiplyBy = (x: Int) => x * 100
  println(multiplyBy(3))
  println(multiplyBy(7))

  // multiplyBy = (x: String) => x.toUpperCase() // TYPE MISMATCH
  multiplyBy = (x: Int) => x * 1000
  println(multiplyBy(3))
  /** Function expression block which holds multiple statements within curly braces */
  var calculateResult = (x: Int, y: Int) => {
    val sum = x + y
    val diff = x - y
    val product = x * y
    val quotient = x / y

    (sum, diff, product, quotient) // <--- Tuple that returns result
  }

  println("------------- 10 and 5")
  println(calculateResult(10, 5))

  println("---------------- 40 and 8")
  println(calculateResult(40, 8))

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73)

  googStockPrices.foreach((price: Double) => println(price))

  val googStockPricesGreaterThan1400 =
    googStockPrices.filter((price: Double) => price > 1400)

    /** Function literals can be written in a shorter form if the type of the input can be inferred
     * this is called TARGET TYPING */
    googStockPrices.filter(price => price > 1400)

    /** Placeholders in Scala represented using the "_" symbol
     * hold one or more parameters to be passed into a function */
    googStockPrices.filter(_ > 1400)

  println(googStockPricesGreaterThan1400)

  val stockTickersInLowercase = List("goog", "ps", "tsla", "aapl", "msft")

  val stockTickers = stockTickersInLowercase.map(_.toUpperCase)
  println(stockTickers)

  val sayHello = () => println("Hello function literal!")
  val multiplyBy100 = (x: Int) => x * 100
  val addTwoNumbers = (x: Int, y: Int) => x + y
  val addThreeNumbers = (x: Int, y: Int, z: Int) => x + y + z

  sayHello() // ==== equivalent to sayHello.apply()  Function0[_]
  println(multiplyBy100(7)) // ==== equivalent to multiplyBy100.apply(7)  Function1[_,_]
  println(addTwoNumbers(7, 10)) // ==== equivalent to addTwoNumbers.apply(7, 10)  Function2[_,_,_]
  println(addThreeNumbers(7, 10, 3)) // ==== equivalent to addThreeNumbers.apply(7, 10, 3)  Function3[_,_,_,_]


  /** Takes data from GOOG file(N/A) and creates a StockRecord instance */
  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toString)
  }

  var data = readFinanceData()
  val priceDelta = (_: Double) - (_: Double)
  val getDailyDelta = (openPrice: Double, closePrice: Double,
                       delta: (Double, Double) => Double) => delta(openPrice, closePrice)
  val record = data.filter(_.date == "2020-01-03")
  print(getDailyDelta(record(0).open, record(0).close, priceDelta)) // when run stock falls by (-12.800048828125)
  print(getDailyDelta(record(0).open, record(0).close, _ - _))

  val getTotalNumberOfRows = () => data.size
  val getAvgCloseValue = () => data.map(_.close).sum / data.size
  val getMinCloseValue = () => data.map(_.close).min
  val getMaxCloseValue = () => data.map(_.close).max
  val getCloseValueOnDate = (givenDate: String) => {
    val filteredClose = data.filter(_.date == givenDate)

    filteredClose.map(_.close).head
  }

  println(s"Dataset size:  ${getTotalNumberOfRows()}")
  println(s"Average close: ${getAvgCloseValue()}")
  println(s"Min close: ${getMinCloseValue()}")
  println(s"Max close: ${getMaxCloseValue}")

  val date = "2020-01-03"
  println(s"Close value on $date: ${getCloseValueOnDate(date)}")

}
