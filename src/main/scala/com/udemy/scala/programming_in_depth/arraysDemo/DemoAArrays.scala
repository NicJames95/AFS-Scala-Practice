package com.udemy.scala.programming_in_depth.arraysDemo

object DemoAArrays extends App{
  var marks = Array(58,36,98,18,56,45,95,37,76,82,19,2,100)
  for (mark <- marks) {     // Accessing each elements of an array marks
    println(mark)
  }

  // Average marks
  var totalMarks = 0
  var averageMarks = 0
  for(mark <- marks) {
    totalMarks = totalMarks + mark
  }
  averageMarks = totalMarks / marks.length
  println(s"Average is: $averageMarks")

  totalMarks = 0
  for (i <- 0 to (marks.length - 1)) {
    totalMarks = totalMarks + marks(i)
  }

  averageMarks = totalMarks / marks.length
  println(s"Average is: $averageMarks")


}
