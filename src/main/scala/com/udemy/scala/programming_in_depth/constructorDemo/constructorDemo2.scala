package com.udemy.scala.programming_in_depth.constructorDemo
// Default parameters in constructor
class demoClass2(val a: Int = 99, val b: Double = 88.88, val c: String = "Hello Scala") {
  val x = a
  val y = b
  val z = c

  def add() = {
    x + y
  }

  println(s"x = ${x} and y = ${y} and z = ${z}")
}

object constructorDemo2 {
  def main(args: Array[String]): Unit = {
    val demoObject1 = new demoClass2(5, 7.2, "Hello World!")
    val demoObject2 = new demoClass2()
    val demoObject3 = new demoClass2(25)
    val demoObject4 = new demoClass2(c = "Hello")
    val demoObject5 = new demoClass2(c = "Hello", a = 5, b = 6.6)
    val demoObject6 = new demoClass2(_, _, "hello")

    println(demoObject1.x)
    println(demoObject1.y)
    println(demoObject1.z)
    var result = demoObject1.add()
    println(s"result = ${result}")
  }
}
