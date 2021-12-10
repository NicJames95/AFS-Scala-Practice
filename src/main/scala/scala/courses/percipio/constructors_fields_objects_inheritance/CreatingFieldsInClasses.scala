package scala.courses.percipio.constructors_fields_objects_inheritance

object CreatingFieldsInClasses extends App {

  class SomeClass{
    var q = 0
  }
  val instA = new SomeClass
  val instB = new SomeClass
  instA.q
  instB.q
  instA.q = 5

  class AnotherClass{
    private var q = 0
  }
  val instC = new AnotherClass
  // println(instC.q) private; need to define public class methods that access the field 


}
