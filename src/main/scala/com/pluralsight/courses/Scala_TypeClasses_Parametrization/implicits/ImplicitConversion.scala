package com.pluralsight.courses.Scala_TypeClasses_Parametrization.implicits

object StringConversions{
  implicit def tokenizer2(str: String): List[String] = str.split(" ").toList
}

object ImplicitConversion {

  import StringConversions._

  def capitalizer(words: List[String]): List[String] = words.map(w => w.capitalize)

  def tokenizer(str: String): List[String] = str.split(" ").toList

  def main(args: Array[String]): Unit = {

    val words = List("This", "is", "simply", "awesome")
    println(capitalizer(words))

    val title = "scala Implicits - why, what and how"
    println(capitalizer(tokenizer(title)).mkString(" "))

    println(capitalizer(title).mkString(" "))
  }

}
