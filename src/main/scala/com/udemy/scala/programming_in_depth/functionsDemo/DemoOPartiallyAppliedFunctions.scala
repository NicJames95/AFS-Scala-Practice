package com.udemy.scala.programming_in_depth.functionsDemo

object DemoOPartiallyAppliedFunctions extends App{
//  def fourWheeler(vehicleName: String, vehicleType: String, vehicleCost: Int) = {
//    println(s"Vehicle name is: $vehicleName, Vehicle type is: $vehicleType, Vehicle cost is: $vehicleCost")
//  }

  val fourWheeler = (vehicleName: String, vehicleType: String, vehicleCost: Int) => {
    println(s"Vehicle name is: $vehicleName, Vehicle type is: $vehicleType, Vehicle cost is: $vehicleCost")
  }

  val car = fourWheeler(_: String, "Car", 20000)  // partially implemented function
  val truck = fourWheeler(_: String, "Truck", 500000)

  fourWheeler("Mercedes", "Car", 200000)
  car("Volkswagen")
  truck("Mercedes AMG")
}
