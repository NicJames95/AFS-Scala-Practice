package com.udemy.scala.programming_in_depth.stringDemo

object StringDemoA {
  def main(args: Array[String]): Unit = {
    var greetings = "Hello World!"
    println(greetings)
    var greetingsNew: String = "Hello India!"
    println(greetingsNew)

    var lengthOfString = greetings.length()
    println("Length of String is " + lengthOfString)

    var var1 = "Hello "
    var var2 = "World"
    println(var1 + var2 + "!")
    println(var1.concat(var2))

    var var3 = var1 + var2 + "!"
    println(var3.length)

    println(var3.charAt(6))

    var varA = "Hello World!"
    var varB = "Hello World!"
    println(varA.equals(varB))
    println(varA == varB)

    println(varA.isEmpty)

    // String Formatting
    var nameOfCar: String = "Mercedes"
    var costOfCar: Int = 500000
    var mileageOfCar = 8.5

    printf("Name of Car is %s and cost of Car is %d and mileage of Car is %f", nameOfCar, costOfCar, mileageOfCar)

    // Multi Line Strings
    println(" ")
    var multiLineString =
      """Hello
        |World
        |How
        |are
        |you
        |""".stripMargin
    println(multiLineString)

    var multiLineStringA =
      """Hello
        World
        How
        are
        you
        """
    println(multiLineStringA)

    var name = "Modi"
    println("Hello " + name)
    println(s"Hello $name")
    println(s"Hello $name, How are you?")

    name = "PM Modi"
    var salary = 20000.2
    println(f"Name is $name%s and salary is $salary%8.2f and designation is PM")

    println(s"Hello World!\nHow are you?")
    println(raw"Hello World!\nHow are you?")


  }
}
