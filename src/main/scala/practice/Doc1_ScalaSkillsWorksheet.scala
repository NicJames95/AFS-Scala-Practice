package practice

object ScalaWork_Questions extends App {

  /*
  Question 1
  Assume I have a map val testMap = Map(1 -> “one”, 2 -> “two”, 3 -> “three”). Extract the value “two”
  from this map.
  */
  val testMap = Map(1 -> "one", 2 -> "two", 3 -> "three")
  println(testMap(2)) // Answer println(testMap(2))
  /*
  Question 2
  Define a sequence with the values “cat”, “dog”, “pig”, “skunk”, “cardinal”. Then filter that sequence to
  only output “cardinal” and “dog”
  */
  val animalSeq = Seq("cat", "dog", "pig", "skunk", "cardinal")
  val filterForDogAndCardinal = animalSeq.filter(animal => (animal == "dog" || animal == "cardinal"))
  println(filterForDogAndCardinal)
  /*
  Question 3
  Using this sequence of animals, add the word “big” in front of each
  Hint: use the “.map” method
  */
  val listWithBig = animalSeq.map(animal => s"big$animal")
  println(listWithBig)
  /*
  Question 4
  Define a case class for a Person with the following properties:
    • Age
    • First Name
    • Last Name
    • Height in Inches
    • List of Hobbies
    • Likes Chocolate
  */
  case class Person(age: Int, firstName: String, lastName: String, heightInInches: Double, listOfHobbies: Seq[String], likesChocolate: Boolean)
  /*
  Question 5
  Create a list/sequence of several people using the case class above, and
  A. filter on people who only like chocolate (output the result)
  B. filter on people above age 40 (output the result)
  */
  val peopleList =
    Seq(Person(25,"John","Witherspoon",66.4,Seq("Basketball", "Video Games", "Swimming"),false),
      Person(45,"Greg", "Witherspoon", 63.9,Seq("Basketball", "Hunting", "Fishing", "Football"), false),
      Person(41, "Mary", "Witherspoon", 62.2, Seq("Basketball", "Football", "Dancing", "Poetry"), true),
      Person(23, "Jean", "Johnson", 59.8, Seq("Basketball", "Music", "Dancing"), true))
  val peoplelikeChocolate = peopleList.filter(person => person.likesChocolate == true)
  println(peoplelikeChocolate)
  val peopleAbove40 = peopleList.filter(person => person.age > 40)
  println(peopleAbove40)
  /*
  Question 6
  Change the last name of each person in this case class to “Smith” (and store in a new list)
  */
  val theSmiths = peopleList.map(person => person.copy(lastName = "Smith"))
  println(theSmiths)
  /*
  Question 7
  Output the full list of hobbies for all members.
  Hint: May need to use .flatMap
  */
  val hobbyList = peopleList.flatMap(_.listOfHobbies)
  println(hobbyList)
  /*
  Question 8
  Create the following Optional value: val myTestOpt = Some(“123456”)
  a. Check whether this optional is empty
  b. Check whether the value inside the option is equal to “123456”
  c. Check whether the value inside the option is equal to “7890”
  d. Check whether the String inside the option contains “5”
  Prerequisite
  Make the following Optional value:
  */
  val myTestOpt = Some("123456")
  println(myTestOpt.isEmpty)
  println(myTestOpt.contains("123456"))
  println(myTestOpt.contains("7890"))
  println(myTestOpt.getOrElse("").contains("5"))
  /*
  Question 9
  Using the Person list, Create a new list with the following properties:
  a. If the person likes chocolate, add the string “He loves chocolate!” to the list.
  b. If the person does not like chocolate, add the string “He hates chocolate…” to the list.
  */
  val lovesOrHatesChocolateList = peopleList.map(person => if person.likesChocolate then s"He/She loves chocolate" else "He/She hates chocolate")
  println(lovesOrHatesChocolateList)




}
