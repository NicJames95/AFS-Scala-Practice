package com.pluralsight.courses.The_Type_System.TypeBasics

object CaseClassAmount extends App {

  case class Amount(value: Double, currency: String)

  val twoDollars = Amount(2, "USD")
  val anotherTwoDollars = Amount(2, "USD")

  def checkIfDollar(amount: Amount): Boolean =
    amount.currency match {
      case "USD" => println("It's a Dollar"); true
      case _ => println(s"It ain't a Dollar, it's ${amount.currency}."); false
    }

  println(twoDollars)
  println(twoDollars.value)
  println(twoDollars.currency)
  println(twoDollars == anotherTwoDollars)

  checkIfDollar(twoDollars)
  checkIfDollar(Amount(2, "INR"))

}
