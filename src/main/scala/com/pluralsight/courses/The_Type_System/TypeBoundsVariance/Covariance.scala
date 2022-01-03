package com.pluralsight.courses.The_Type_System.TypeBoundsVariance

abstract class Employee

case class Developer(name: String) extends Employee
case class SalesAssociate(name: String) extends Employee

object Covariance extends App{

  // Collection of all the employees
  val employees = new scala.collection.mutable.ArrayBuffer[Employee]

  val developers: List[Developer] = List(Developer("Allen"), Developer("Bob"))

  val salesAssociates: List[SalesAssociate] = List(SalesAssociate("Chris"), SalesAssociate("David"))

  def addEmployees(es: List[Employee]): Unit = employees.appendAll(es)

  addEmployees(developers)
  addEmployees(salesAssociates)

  employees foreach println
}
