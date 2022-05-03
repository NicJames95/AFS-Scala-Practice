package com.udemy.scala.programming_in_depth.traitsDemo
// written by xyz developer, open source,
// whenever you extend CarD, you should also extend FourWheelerD and VehicleD
abstract class VehicleD {

}

trait FourWheelerD {

}

trait CarD {
  this: FourWheelerD with VehicleD => {

  }
}

// written by abc developer
class MercedesD extends VehicleD with FourWheelerD with CarD { // if you extend CarD, 
  // make sure you extend FourWheelerD and VehicleD
}

object DemoDTrait extends App{
  val m1 = new MercedesD
}
