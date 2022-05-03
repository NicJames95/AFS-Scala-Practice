package com.udemy.scala.programming_in_depth.exceptionHandlingDemo

import scala.util.control.Exception.catching
import DemoBTrySuccessFailure._

object DemoCCatching extends App{
  //val catchExceptions = catching(classOf[ArithmeticException]).withApply(e => println("Arithmetic Exception occurred"))
  val catchExceptions = catching(classOf[ArithmeticException]).withApply(e => errorHandlingFunction(e))
  val catchingExceptions = catching(classOf[ArrayIndexOutOfBoundsException]).withApply(e => println("Out of Bounds"))

  val a = catchExceptions(10/4)

  if(a != ()){
    println(a)
  }
}
