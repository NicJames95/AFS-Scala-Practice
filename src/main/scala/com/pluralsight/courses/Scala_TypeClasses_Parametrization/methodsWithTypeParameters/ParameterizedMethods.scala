package com.pluralsight.courses.Scala_TypeClasses_Parametrization.methodsWithTypeParameters

object ParameterizedMethods {

  def add(a: Int, b: Int): Int = a + b
  def sub(a: Int, b: Int): Int = a - b

  def operation(a: Int, b: Int, op: (Int, Int) => Int): Int = op(a, b)

  def operationP[T](a: T, b: T, op: (T, T) => T): T = op(a, b)

  def main(args: Array[String]): Unit = {
    val addition = operation(2, 1, add)
    val subtraction = operation(2, 1, sub)

    val intAddition: Int = operationP(22, 11, add)
    val longAddition: Long = operationP(22L, 11L, (a: Long, b: Long) => a + b)

    println(s"Calling add op => $addition")
    println(s"Calling sub op => $subtraction")
    println(s"Calling add opP for Int => $intAddition")
    println(s"Calling add opP for Long => $longAddition")
  }

}
