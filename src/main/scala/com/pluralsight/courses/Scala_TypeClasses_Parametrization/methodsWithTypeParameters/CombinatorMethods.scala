package com.pluralsight.courses.Scala_TypeClasses_Parametrization.methodsWithTypeParameters

object CombinatorMethods {

  def map[T, U](option: Option[T], f: T => U): Option[U] =
    if (option.isDefined) Some(f(option.get)) else None

  def main(args: Array[String]): Unit = {

    val mayBeString: Option[String] = Some("one")

    val capitalized = map(mayBeString, (s: String) => s.capitalize)
    println(s"Capitalized String => $capitalized")

    val length = map(mayBeString, (s: String) => s.length)
    println(s"Length of String => $length")

    val countryNames: List[String] =
      List(
        "Austria", "belgium", "canada", "Denmark", "England",
        "Thailand", "india", "Singapore", "United States",
        "Australia", "china", "germany", "Russia"
      )
    countryNames
      .map(cName => cName.toUpperCase())
      //.foreach(cName => println(cName))

    // def filter(f: T => Boolean): List[T]

    countryNames
      .filter(cName => cName.length == 7)
      .map(cName => cName.toUpperCase())
      .foreach(c => println(c))
  }

}
