package scala.courses.percipio.constructors_fields_objects_inheritance

object CompanionObjects extends App {

  class Car(milesPerGallon: Int, gallonsPerTank: Int){
    var mpg: Int = milesPerGallon
    var gpt: Int = gallonsPerTank
    var mpt: Int = _

    def milesPerTank(): Unit ={
      mpt = mpg * gpt
      println(s"Number of Miles Per Tank: $mpt")
    }
  }
  Car
  // Companion object is basically the same as singleton object except that the companion object has the same name
  // as its companion class and the companion object must be defined in the same source file as its companion class
  // The main point of creating a singleton object is to either store utility methods together in one location or
  // to store a main method , so that the singleton may act as the entry point to a scala application
  // Here we've created a companion object that will store the main method of the application
  // using extends APP, but the main method would be defined in the companion Car object
  object Car {
    val SUV = new Car(25, 20) // new keyword can only be used to instantiate a class so SUV is part of Car Class
    SUV.milesPerTank()
  }

}
