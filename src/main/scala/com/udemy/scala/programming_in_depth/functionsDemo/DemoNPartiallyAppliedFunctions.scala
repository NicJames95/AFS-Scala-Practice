package com.udemy.scala.programming_in_depth.functionsDemo

import java.util.Date
// Note: Without partially applied function
object DemoNPartiallyAppliedFunctions extends App{
  def log(date: Date, msg: String) = {
    println(msg + date)
  }

  val logWithDate = log(date, _ : String) // Partially Applied Functions, 
                                          // the parameter that is expected by partially applied functions

  val date = new Date()
  log(date, "Hello 1 ")

  Thread.sleep(6000)
  log(date, "Hello 2 ")

  Thread.sleep(2000)
  log(date, "Hello 3 ")

  Thread.sleep(2000)
  logWithDate("Hello 4 ")
}
