val cars = Map("Mercedes"->"High End", "BMW"->"High End", "Toyota"->"Mid Range", "Jaguar"->"High End", "Nano"->"Low End")

val carCollection = scala.collection.mutable.Map("Mercedes"->"High End", "BMW"->"High End", "Toyota"->"Mid Range", "Jaguar"->"High End", "Nano"->"Low End")
carCollection += ("Suzuki"->"Mid Range")

cars.keys
cars.values
cars.isEmpty
cars.max
cars.min

val emptyMap : Map[String,String] = Map()
emptyMap.isEmpty

emptyMap += ("a"->"aaa")

cars.head
cars.tail

carCollection -= "Toyota"
carCollection.put("Toyota"->"Low End")
carCollection.put("a"->"b")
carCollection.remove("a")

cars.get("Mercedes")

val highAndMidEndCar = Map("Mercedes"->"High End", "BMW"->"High End", "Toyota"->"Mid Range")
val lowEndCar = Map("Nano"->"Low End", "M800"->"Low End")

val carShow = highAndMidEndCar ++ lowEndCar
carShow.keys.foreach{ key => println(s"Key is $key and value is ${carShow.get(key)}")}
carShow.keys.foreach{ key => println(s"Key is $key and value is ${carShow(key)}")}
carShow.foreach{car => println(s"Key is ${car._1} and value is ${car._2}")}
carShow.foreach{case(carName, carRange) => println(s"Key is $carName and value is $carRange")}
carShow.contains("Toyota")

carShow.valuesIterator.exists(_.equals("Mid Range"))
carShow.mapValues(value => value.toString.length)
carShow.transform((carName, carRange) => carRange.toString.length.toString)

val usedCars = scala.collection.SortedMap("Mercedes"->"High End", "BMW"->"High End", "Toyota"->"Mid Range", "Jaguar"->"High End", "Nano"->"Low End", "Mercedes"->"Low End")

val listedCars = scala.collection.ListMap("Mercedes"->"High End", "BMW"->"High End", "Toyota"->"Mid Range", "Jaguar"->"High End", "Nano"->"Low End", "Mercedes"->"Low End")

val carHash = scala.collection.HashMap("Mercedes"->"High End", "BMW"->"High End", "Toyota"->"Mid Range", "Jaguar"->"High End", "Nano"->"Low End", "Mercedes"->"Low End")