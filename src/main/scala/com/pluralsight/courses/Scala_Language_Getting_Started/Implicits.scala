package com.pluralsight.courses.Scala_Language_Getting_Started

case class Currency(code: String, amount: Double, toUSD: Double)
object Implicits extends App {
  // money "USD 100"
  implicit def stringToCurrency(money: String): Currency = {
    val Array(code: String, value: String) = money.split("\\s")
    val amountAsDouble = value.toDouble
    code match {
      case "USD" => Currency("USD", amountAsDouble, amountAsDouble)
      case "NZD" => Currency("USD", amountAsDouble, (amountAsDouble * (1/1.5)))
      case "CAD" => Currency("USD", amountAsDouble, (amountAsDouble * (1/1.3)))
    }
  }
  println(stringToCurrency(money = "USD 100"))
  println(stringToCurrency(money = "NZD 100"))
 // println(stringToCurrency(money = "CAD 100")) below val does the same

   val cad: Currency = "CAD 100" // implicit allows this to work behind the scenes compiler sees a string
  // where a currency is needed and the uses the stringToCurrency method to calculate conversion
   println(cad)

}
