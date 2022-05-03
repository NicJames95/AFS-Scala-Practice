package com.udemy.scala.programming_in_depth.constructorDemo
// Auxillary Constructor
class demoClass3(val a: Int, val b: Double, val c: String) {
  val x = a
  val y = b
  val z = c

  println(s"Primary constructor: x = ${x} and y = ${y} and z = ${z}")

  def add() = {
    x + y
  }

  def this() = {
    this(99, 88.88, "Hello Scala")
    println("Auxillary constructor with 0 parameters")
  }

  def this(a: Int) = {
    this(a, 88.88, "Hello Scala")
    println("Auxillary constructor with 1 parameter")
  }

  def this(a: Int, b: Double) = {
    this(a, b, "Hello Scala")
    println("Auxillary constructor with 2 parameters")
  }
}

object constructorDemo3 {
  def main(args: Array[String]): Unit = {
    val demoObject1 = new demoClass3(5, 7.2, "Hello World!")
    val demoObject2 = new demoClass3()
    val demoObject3 = new demoClass3(7)
    val demoObject4 = new demoClass3(7, 9.87)
  }
}
