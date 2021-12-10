package scala.courses.percipio.constructors_fields_objects_inheritance

object SingletonObjects extends App {

  class Car(milesPerGallon: Int, gallonsPerTank: Int) {
    var mpg: Int = milesPerGallon
    var gpt: Int = gallonsPerTank
    var mpt: Int = _

    def milesPerTank(): Unit ={
      mpt = mpg * gpt
      println(s"Number of Miles Per Tank: $mpt")
    }
  }

  Volvo // calls the singleton object and calls all inside including the sedan.milesPerTank
  // (Example used main method in Volvo)

  object Volvo {
    val sedan = new Car(40, 18)
    sedan.milesPerTank()
  }

}
