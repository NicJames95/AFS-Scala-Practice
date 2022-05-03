package com.udemy.scala.programming_in_depth.arraysDemo

import Array._

object DemoFArray extends App{
  var marks1 = Array(5,6,8,9,2,4,6)
  var marks2 = Array(5,9,2,6,4,2,6)

  var allMarks = concat(marks1, marks2)
  allMarks foreach println

  var rollNo = range(1, 100)
  rollNo foreach println

  println()

  var rollNox = range(2, 101, 2)
  // rollNox foreach print
  for (rolls <- rollNox) {
    print(s"$rolls, ")
  }
}
