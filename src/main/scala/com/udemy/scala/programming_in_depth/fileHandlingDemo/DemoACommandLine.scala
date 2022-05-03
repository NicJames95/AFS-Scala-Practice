package com.udemy.scala.programming_in_depth.fileHandlingDemo
// Read from Comand Line scala.io._
object DemoACommandLine extends App{
  println("Enter your name")
  val name = scala.io.StdIn.readLine()
  println(s"Hello $name")

  println(s"Hello $name, Enter phone number")
  val number = scala.io.StdIn.readLine()
  println(s"Phone Number is $number")

  println(s"Hello $name, Enter an age")
  val age = scala.io.StdIn.readLine()
  println(s"Age is $age")
}
