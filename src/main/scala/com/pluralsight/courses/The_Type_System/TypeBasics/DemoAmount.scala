package com.pluralsight.courses.The_Type_System.TypeBasics

object DemoAmount extends App {

  class Amount(val value: Double, val currency: String) {
//    val amountValue = this.value
//    val amountCurrency = this.currency
    override def toString: String = s"Amount(${this.value}, ${this.currency})"
  }

  object Amount {
    def apply(value: Double, currency: String): Amount = new Amount(value, currency)

    def apply(value: Double): Amount = new Amount(value, "USD")
  }

  object AmountUtils {
    // Converts an amount from the given value to the provided currency.
    def convert(from: Amount, to: String): Amount = {
      // Some currencyConversionRates service call which can give the conversion rates
      val conversionRate = 69.45 //Assuming it to be 69.45
      new Amount(from.value * conversionRate, to)
    }
  }

  val twoDollars = new Amount(2, "USD")
  val twoUSDollars = Amount(2)
  val twoDollarsEqINR = AmountUtils.convert(twoDollars, "INR")
  println(s"Two Dollars in INR is: $twoDollarsEqINR")

  println(twoDollars.value)
  println(twoDollars.currency)

  println(twoDollars equals twoUSDollars)

}
