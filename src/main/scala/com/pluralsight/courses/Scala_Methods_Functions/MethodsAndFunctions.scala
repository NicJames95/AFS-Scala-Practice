package com.pluralsight.courses.Scala_Methods_Functions

object MethodsAndFunctions extends App{

  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def getNumRowsMethod(): Int = data.length
  /** A method in Scala is defined using the def keyword. It is part of a class, it has a name, signature,
   * some annotations, and bytecode. */

  val getNumRowsFunction = () => data.length
  /** A function is a complete object by itself, an instance of a class which implements traits, contains its own methods */

  println("Total number of rows (method): " + getNumRowsMethod())
  //println(getNumRowsMethod) // ALSO WORKS
  println("Total number of rows (function): " + getNumRowsFunction())
  println(getNumRowsFunction)
  /** Without the parenthesis you get hashCode referencing the object  */

  println(getNumRowsMethod().getClass) // Returns the class int because the final expression is an Int
  println(getNumRowsFunction.apply())
  println(getNumRowsFunction.isInstanceOf[Function0[_]])

  /** Another Example */

  def existsMethod(ticker: String): Boolean = data.contains(ticker)

  val existsFunction = (ticker: String) => data.contains(ticker)

  println("Does PS exist (method): " + existsMethod("PS"))
  println("DOES TM exist (function): " + existsFunction("TM"))

  val exists = existsMethod /** Create a function object from a method, this uses partially applied functions */
  println(exists("MSFT"))

}
