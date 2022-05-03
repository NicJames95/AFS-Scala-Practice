package com.udemy.scala.programming_in_depth.learningScala

import com.udemy.scala.programming_in_depth.learningScala.Car

class Car{
  var topClassExtraCost = 0
  private var roadTax = 100
  protected var xyz = 10

  def cost(basicCost: Int) = basicCost + topClassExtraCost + roadTax
  def checkTax() = {
    roadTax = 10
    roadTax
  }
  def printTax = roadTax
}

class smallCar extends Car {
  print(xyz)
}

object demoClassObject {

  def main(args: Array[String]): Unit = {
    var bmw = new Car
    //  println(bmw.roadTax)
    //  bmw.roadTax = 200
    //  println(bmw.roadTax)
    bmw.topClassExtraCost = 500
    var result = bmw.cost(10000)
    println(s"Total cost of car is $result")
    println(s"Road Tax is ${bmw.checkTax()}" )

    var a = new Car
    println(a.topClassExtraCost)
    // println(bmw.xyz)

  }

  // Class => { Collection of variables & methods }
  // object => _instance of Class

}
