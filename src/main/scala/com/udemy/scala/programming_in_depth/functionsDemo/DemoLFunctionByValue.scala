package com.udemy.scala.programming_in_depth.functionsDemo

object DemoLFunctionByValue extends App{
  // Points to remember
  // 1. It will first execute the inside function "time()" and then execute the outside function "exec(7895721604100)"
  // 2. Since inside function "time()" gets executed first, it calls outside function "exec(7895721604100)"
  // using the value 7895721604100, it is called as "Function by Value"
  def time(): Long = {
    println("Inside time function")
    return System.nanoTime()
  }

  def time2(): Long = {
    println("Inside time2 function")
    return System.nanoTime()
  }

  def exec(t: Long, u: Long): Long = {
    println("Inside exec function")
    println(s"Time from time(): $t")
    println(s"Time from time2(): $u")
    println("Exiting from time function")
    return t
  }

  println(s"Main Function: ${exec(time(), time2())}")
}
