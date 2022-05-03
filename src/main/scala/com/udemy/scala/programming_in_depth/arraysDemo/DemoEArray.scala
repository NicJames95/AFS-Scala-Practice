package com.udemy.scala.programming_in_depth.arraysDemo
// Multi-dimensional Arrays

import Array._

object DemoEArray extends App{
  var matrixEg = ofDim[Int](5,5) // multi-dimensional 2D Array

  for (row <- 0 to 4) {
    for (column <- 0 to 4) {
      // matrixEg(row)(column) = column + 3
      if (row == column) {
        matrixEg(row)(column) = 1
      }
      else {
        matrixEg(row)(column) = 0
      }
    }
  }

  for (row <- 0 to 4) {
    for (column <- 0 to 4) {
      print(matrixEg(row)(column))
    }
    println(" ")
  }
}
