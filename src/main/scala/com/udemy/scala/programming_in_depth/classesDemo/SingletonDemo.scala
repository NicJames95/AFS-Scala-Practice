package com.udemy.scala.programming_in_depth.classesDemo

class DemoClassA {
  val x = 2
  val y = 5.5

  def add() = x + y

  println(s"x = ${x} , y = ${y}")
}

class DemoClassB(a: Int, b: Double) {
  val x = a
  val y = b

  def add() = x + y

  println(s"x = $x , y = $y")
}

object SingletonDemo {
  def main(args: Array[String]): Unit = {
    val demoObjectA = new DemoClassA
    println(demoObjectA.x)
    println(demoObjectA.y)
    val result = demoObjectA.add()
    println(result)

    var demoObjectC = new DemoClassB(5, 7.7)
    println(demoObjectC.x)
    println(demoObjectC.y)
    var resultC = demoObjectC.add()
    println(resultC)

    demoObjectC = new DemoClassB(3, 2.2)
    println(demoObjectC.x)
    println(demoObjectC.y)
    resultC = demoObjectC.add()
  }
}
