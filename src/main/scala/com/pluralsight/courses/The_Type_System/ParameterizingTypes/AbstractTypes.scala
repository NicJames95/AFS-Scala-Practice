package com.pluralsight.courses.The_Type_System.ParameterizingTypes

trait AlgebraicOperationsP[T]{
  def add(a: T, b: T): T
  def sub(a: T, b: T): T
  def mul(a: T, b: T): T
}

object IntegerOpsP extends AlgebraicOperationsP[Int] {
  type T = Int
  def add(a: T, b: T): T = a + b
  def sub(a: T, b: T): T = a - b
  def mul(a: T, b: T): T = a * b
}

trait OperationGenerator[In] {
  type Out

  def operation: Out
}

object AbstractTypes extends App {
  import IntegerOpsP._

  type OperationInputType = String

  val capitalizer = new OperationGenerator[OperationInputType] {
    override type Out = OperationInputType => String

    override def operation: Out =
      (str: OperationInputType) => str.capitalize
  }

  val listOfStrings = List("first", "second", "third", "fourth")
  listOfStrings.map(capitalizer.operation) foreach println

  //println(add(1,2))
  //println(mul(1,2))
}
