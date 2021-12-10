package scala.courses.percipio.constructors_fields_objects_inheritance

import scala.math.Pi

class Exercise1 {

  /*
  - Create a class that has one parameter, two fields and an empty-parenthesis method
  - Create a subclass and override a field and a method from the superclass
  - Create a companion object that will act as the entry point to the Scala application
    - Declare the companion object
    - Define a main method in the body of the companion object
  */

  //  class Animal(val typeOfAnimal: String) {
  //    var name: String = typeOfAnimal
  //    var color: String = _
  //    def description(): Unit ={
  //      println(s"This $color animal is a $name")
  //    }
  //  }
  //
  //  class Tiger(override val typeOfAnimal: String) extends Animal(typeOfAnimal) {
  //    var animalName: String = "Tyson"
  //    var animalColor: String = "Orange"
  //    override def description(): Unit = {
  //      println(s"$animalName is an $animalColor $typeOfAnimal")
  //    }
  //  }
  //
  //  object Animal {
  //    def main(args: Array[String]): Unit = {
  //      val tyson = new Tiger("Tiger")
  //      tyson.description()
  //    }
  //  }

  // Course Example
  class Shape3D (val height: Double) {
    var h: Double = height
    var result: Double = _
    def volume(): Unit = {
      result = h * h * h
      println(s"Volume of shape (cube): $result cm3")
    }
  }

  class Cylinder(override val height: Double, val radius: Double) extends Shape3D(height){
    var r: Double = radius
    override def volume(): Unit ={
      result = Pi * r * r * h
      println(s"Volume of cylinder: $result cm3")
    }
  }

  object Shape3D extends App {
    
      val shape = new Cylinder(20, 10)
      shape.volume()
    
  }

}
