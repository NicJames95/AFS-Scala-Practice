package com.udemy.scala.programming_in_depth.arraysDemo

object DemoBArray extends App{
  var marks = Array(58,36,98,18,56,45,95,37,76,82,19,2,100)

  // foreach and map
  for (mark <- marks) {
    println(mark)
  }

  marks foreach println

  // Average marks
  var totalMarks = 0
  for (mark <- marks) {
    totalMarks = totalMarks + mark
  }
  var averageMarks = totalMarks / marks.length
  println(s"Average marks: $averageMarks")

  totalMarks = 0
  //  marks foreach(mark => totalMarks = totalMarks + mark)
  //  marks foreach(mark => totalMarks += mark)
  marks foreach(totalMarks += _)
  averageMarks = totalMarks / marks.length
  println(s"Average marks: $averageMarks")

  // map
  //  val newMarks = marks map(mark => mark + 10)
  var newMarks = marks map(_ + 10)
  newMarks foreach println

  // for-comprehension
  val result = for (mark <- marks) yield mark + 10
  result foreach println
}
