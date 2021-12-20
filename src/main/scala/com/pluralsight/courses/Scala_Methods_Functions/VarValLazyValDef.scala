package com.pluralsight.courses.Scala_Methods_Functions

object VarValLazyValDef extends App{

  var stockPrice = 14
  lazy val volume = {println("Assigning lazy val"); 100}

  def finalValue = stockPrice * volume
  println(s"Final value is: $finalValue")

  val data = {println("Array is initialized"); Array(
    "MSFT", "GOOG", "TM"
  )}

  println("Before accessing data")
  data.foreach(println)

  println("-" * 50)
  var data2 = {println ("New Array is initialized"); Array("AAPL")}
  data(2) = "AAPL"
  data(0) = "TSLA"
  data.foreach(println)
  println("-" * 50)
  data2.foreach(println)
}
