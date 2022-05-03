package com.udemy.scala.programming_in_depth.functionsDemo

object DemoMFunctionByName extends App{
  // Points to remember
  // 1. First executes the OUTSIDE function "exec()" and then executes the INSIDE
  // function "time()" every time t is being referred.
  // 2. Since the OUTSIDE function "exec()" gets executed first, it calls INSIDE function "time()"
  // using the REFERENCED VARIABLE t, it is called as "Function by Name"
  def time(): Long = {
    println("Inside time function")
    return System.nanoTime()
  }

  def time2(): Long = {
    println("Inside time2 function")
    return System.nanoTime()
  }

  def exec(t: => Long, u: => Long): Long = {
    println("Inside exec function")
    println(s"Time from time(): $t")
    println(s"Time from time2(): $u")
    println("Exiting from time function")
    return t
  }

  println(s"Main Function: ${exec(time(), time2())}")
}
