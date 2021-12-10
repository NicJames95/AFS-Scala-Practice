package scala.courses.percipio.constructors_fields_objects_inheritance

import scala.math.Pi

object SubTypeInheritance extends App {

  class Shape3D(val height: Double) {
    var h: Double = height
    var result: Double = _
    def volume(): Unit = {
      result = h * h * h
      println(s"Volume of shpae (cube): $result cm3")
    }
  }

  class Cylinder(override val height: Double, val radius: Double) extends Shape3D(height) {
    var r: Double = radius
    override def volume(): Unit ={
      result = Pi * r * r * h
      println(s"Volume of cylinder: $result cm3")
    }
  }

  val shape = new Cylinder(10, 4)
  shape.volume()

}
