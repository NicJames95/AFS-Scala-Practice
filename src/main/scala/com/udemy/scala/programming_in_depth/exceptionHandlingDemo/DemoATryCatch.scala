package com.udemy.scala.programming_in_depth.exceptionHandlingDemo

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import java.lang.ArithmeticException
// C:\Users\nicolas.james\IdeaProjects\afs-scala-practice\src\main\scala\com\udemy\scala\programming_in_depth\exceptionHandlingDemo
object DemoATryCatch {
  def main(args: Array[String]): Unit = {
    try {
      val f = new FileReader("C:\\Users\\nicolas.james\\IdeaProjects\\afs-scala-practice\\src\\main\\scala\\" +
        "com\\udemy\\scala\\programming_in_depth\\exceptionHandlingDemo\\input.txt")

      val a = 10/5
      println(a)

      val array = Array(10)
      println(array(9))

    } catch {
      case z: FileNotFoundException => {
        println("File is not Found - Exception received " + z)
      }
      case e: IOException => {
        println("Error while reading file - Exception received")
      }
      case e: ArithmeticException => {
        println("Arithmetic Exception received")
      }
      case _: Exception => {
        println("It will catch all unhandled exceptions")
      }
    } finally {
      println("It will always be executed irrespective of Exception or not")
    }
  }
}
