package com.pluralsight.courses.Scala_TypeClasses_Parametrization.methodsWithTypeParameters

object TypeErasure {

  def listOf[T](list: List[T]): String = {
    list match {
      case ofInt: List[Int] =>  "Integer"
      case ofString: List[String] =>  "String"
      case _ => "Any"

    }
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3)
    println(listOf(numbers))

    val words = List("one", "two", "three")
    println(listOf(words)) // returns integer due to type erasure
    
  }

}
