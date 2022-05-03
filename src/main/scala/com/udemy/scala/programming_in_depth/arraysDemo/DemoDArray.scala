package com.udemy.scala.programming_in_depth.arraysDemo

object DemoDArray extends App{
  var marks = Array(21.0,25,39,58,79,64,52,94,34)
  var avg = marks.reduceLeft((x,y) => (x + y) / 2)

  var avg2 = marks.reduceRight((x,y) => {
    println(s"value of x is: $x and y is: $y average is: " + (x + y) / 2)
    (x+y) / 2
  })

  var avg3 = marks.reduceLeft(_ / 2 + _ / 2)

  println(avg)
  println(avg2)
  println(avg3)

  var totalMarks = marks.reduceLeft(_ + _)
  println(s"Total Marks is: $totalMarks")

  var maxMarks = marks.reduceLeft(_ max _)
  println(s"Max marks is: $maxMarks")

  var maxMarks2 = marks.reduceRight((x,y) => x max y)
  println(s"Max marks is: $maxMarks2")

  var minMarks = marks.reduceLeft(_ min _)
  println(s"Min marks is: $minMarks")

  var minMarks2 = marks.reduceRight((x,y) => x min y)
  println(s"Min marks is: $minMarks2")
}
