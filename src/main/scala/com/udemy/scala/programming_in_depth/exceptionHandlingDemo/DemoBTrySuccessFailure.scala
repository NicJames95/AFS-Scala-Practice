package com.udemy.scala.programming_in_depth.exceptionHandlingDemo

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object DemoBTrySuccessFailure extends App{
  val a = Try(10/0)

  a match {
    case Success(value) => println(value)
    case Failure(exception) => errorHandlingFunction(exception)
  }

  def errorHandlingFunction(exception: Throwable) = {
    println(exception)
    if (exception.toString.equals("java.lang.ArithmeticExcpetion: / by zero")) {
      println("hello, arithmetic exception has occurred")
    }
  }
}
