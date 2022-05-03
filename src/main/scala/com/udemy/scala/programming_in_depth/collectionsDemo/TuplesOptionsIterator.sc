val tuple1 = (1,"String Data", 2.3)
tuple1.getClass
val tuple2 = new Tuple5(1,"String Data",2.3,5,5.6)
tuple2._1
tuple2._2
tuple2._3

tuple2.productIterator.foreach(i => println("value is " + i))
tuple2.toString()
tuple2.getClass
tuple2.swap

val carList = List(("Mercedes", "High End"), ("Suzuki", "Mid Range"), ("Jaguar", "High End"), ("BMW", "High Range"))
carList.foreach(
case ("Jaguar", range) =>
println("Car is Jaguar and the range is " + range)
case _ =>
)

val student = (1,"xyz","abc")

case class Student(rollNo: Int, firstName: String, lastName: String)

val student1 = Student(1, "xyz", "abc")

val options1 = Some(10)
val options2 = None

val cars = Map("Mercedes"->"High End", "BMW"->"High End", "Suzuki"->"Mid Range")
cars.get("BMW")
cars.get("Jaguar")

def removeSome(x: Option[String]) =
  | x match {
  | case Some(y) => y
    | case None => "Not Found"
    |}

removeSome(cars.get("Jaguar"))
removeSome(cars.get("BMW"))
removeSome(cars.get(" "))

val option1 = Some(101)
option1.get

option1.getOrElse(0)

val iterator1 = Iterator("Hello World", "Hello India", "Hello Singapore", "Hello US")
iterator1.next()
iterator1.hasNext

while(iterator1.hasNext){
  println(iterator1.next)
}

iterator1.max
iterator1.min
iterator1.length

val bufferedIterator = iterator1.buffered
bufferedIterator.head

iterator1.swap