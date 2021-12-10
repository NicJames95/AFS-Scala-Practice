package scala.courses.percipio.constructors_fields_objects_inheritance

object Traits extends App {

  trait Shape {
    def area(): Unit ={
      println(s"Area of shape depends on the type of shape")
    }
  }

  class Circle extends Shape {
    override def toString = "circle"
  }

  val myCircle = new Circle
  myCircle.area()

  val c: Shape = myCircle
  c.area()

  class Cuboid {

  }

  class Cube extends Cuboid with Shape {
    override def toString = "cube"
    override def area(): Unit ={
      println(s"Surface area of cube = 6 * pow(w,2)")
    }
  }

  val myCube = new Cube
  myCube.area()

  trait Prism {
    def volume(): Unit ={
      println(s"Volume of a prism is length * width * height")
    }
  }

  class SpecialCube extends Cuboid with Shape with Prism {
    override def toString = "special cube"
  }

  val mySC = new SpecialCube
  mySC.volume()

}
