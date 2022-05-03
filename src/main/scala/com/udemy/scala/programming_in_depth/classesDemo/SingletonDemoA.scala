package com.udemy.scala.programming_in_depth.classesDemo
// Singleton object
object DemoObjectB { // Instead of class object
  val x = 2
  val y = 5.5

  def add() = x + y

  println(s"x = ${x} , y = ${y}")
}

object SingletonDemoA {
  def main(args: Array[String]): Unit = {
    // val demoObjectB = new DemoClassB // can't create an object from an object
    val result = DemoObjectB.add() // Note: Access method/function as objectName.method
    println(result)
  }
}
