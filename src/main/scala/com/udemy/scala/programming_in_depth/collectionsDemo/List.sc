val colors: List[String] = List("Red", "Green", "Yellow")

val evenNumbers = List(2, 4, 6, 8)

val numbers = List(2.0, 4, 6.5, 8)

val list = List(2, 5.2, "Hello")

val matrix = List(
  List(1,2,3),
  List(4,5,6),
  List(7,8,9)
)

val matrix2 = List(
  List(1,2,3),
  List(4.1,5.2,6.3),
  List("Hello", "World")
)

evenNumbers(0)
// evenNumbers(1) = 7

val evenNumbersArray = Array(2, 4, 6, 8)
evenNumbersArray(1) = 7
evenNumbersArray

val bgp = "Blue" :: ("Green" :: ("Purple" :: Nil))

val oddNumbers = 1 :: (3 :: (5 :: (7:: Nil)))

val consMatrix = (1::(2::(3::Nil))) :: (4::(5::(6::Nil))) :: (7::(8::(9::Nil))) :: Nil

val numbersRange = List.range(1, 100)

val evenNumbersRange = List.range(2,100,2)

val oddNumbersRange = List.range(1,100,2)

val oddNumbersRange2 = (1 to 100 by 2).toList

colors.head
colors.tail

val red = Nil

red.isEmpty
colors.isEmpty
colors.size
red.size

val availableColors = colors.mkString(",")
val availableColors2 = colors.mkString("We are having these colors: ", "," , " only. Please pick among these.")

// colors = colors :+ "Blue"

var colors2 = List("Red", "Green", "Yellow")

colors2 = colors2 :+ "Blue"
//
colors2 = "Orange" +: colors2

colors2 = "Violet" :: colors2