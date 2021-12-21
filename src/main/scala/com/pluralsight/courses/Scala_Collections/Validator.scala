package com.pluralsight.courses.Scala_Collections

object CCValidator extends App {

  def validate(number: String): Boolean = {
    val sum = number
      .map(_.asDigit)
      .reverse
      .zipWithIndex
      .map { case (digit, index) => if (index % 2 == 0) digit else digit * 2 }
      .flatMap(number => List(number / 10, number % 10))
      .sum
    sum % 10 == 0
  }

  println(validate("49927398716"))    // valid
  println(validate("79927398711"))    // invalid

}
