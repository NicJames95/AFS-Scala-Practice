package com.udemy.scala.programming_in_depth.arraysDemo

object DemoGArray extends App{
  var marks1 = Array(5,8,9)
  var marks2 = Array(5,9,7)
  var marks3 = Array(5,9,4)

  var marks = Array(marks1, marks2, marks3)

  for (marka <- marks) {
    for (markb <- marka) {
      print(s"$markb ")
    }
  }
}
