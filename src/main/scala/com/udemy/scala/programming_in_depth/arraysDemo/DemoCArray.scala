package com.udemy.scala.programming_in_depth.arraysDemo

object DemoCArray extends App{
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
}
