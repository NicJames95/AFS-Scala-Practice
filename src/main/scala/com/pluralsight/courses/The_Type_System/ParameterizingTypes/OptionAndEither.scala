package com.pluralsight.courses.The_Type_System.ParameterizingTypes

object OptionAndEither extends App{

  import scala.util.control.NonFatal

  def safeNumber(possibleNumber: String): Int = {
    try {
      possibleNumber.toInt
    } catch {
      case NonFatal(_) => throw new Exception
    }
  }

  println(s"Converted number is ${safeNumber("12")}")

  def double(number: Int): Int = number * 2
  val doubled12 = double(safeNumber("12"))
  println(s"Doubled number is $doubled12")

  def saferNumber(possibleNumber: String): Option[Int] = {
    try {
      Some(possibleNumber.toInt)
    } catch {
      case NonFatal(_) => println(s"Could not convert $possibleNumber to a Number"); None
    }
  }

  val number = saferNumber("foo").getOrElse(0)
  println(s"Converted number is $number")

  saferNumber("12")
    .map(double)
    .map(doubled12 => println(s"Doubled number is: $doubled12"))

  saferNumber("12") match {
    case Some(number) => println(s"The number: $number")
    case None => println("Could not convert the number")
  }

  def eitherNumber(possibleNumber: String): Either[String, Int] = {
    try {
      Right(possibleNumber.toInt)
    } catch {
      case e: Throwable =>
        Left(s"${e.getMessage}")
    }
  }

  eitherNumber("12") match {
    case Right(number) => println(s"The number: $number")
    case Left(exceptionMsg) => println(s"Something went wrong: $exceptionMsg")
  }

  eitherNumber("12")
    .map(number => println(s"The number: $number"))
}
