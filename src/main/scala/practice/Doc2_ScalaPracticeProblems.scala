package practice

object Doc2_ScalaPracticeProblems extends App {

  /*
  Topics
    • Mapping over iterables
    • Case classes
    • List Operations
    • Grouping By
  Question 1
  1. suppose you have the case class as follows:
  case class Food(name:String,
  weightInOunces: Int,
  pairedWine: Option[String])
  and the instances of this case class:
  val steak = Food("steak", 8, Some("merlot"))
  val fish = Food("fish", 6, Some("pinot"))
  val bacon = Food("bacon", 4, None)
  */
  case class Food(name: String, weightInOz: Int, pairedWine: Option[String])
  val steak = Food("steak", 8, Some("merlot"))
  val fish = Food("fish", 6, Some("pinot"))
  val bacon = Food("bacon", 4, None)
  /*
  A
  Make your own food object. List None for the paired wine.
  */
  val chicken = Food("chicken", 8, None)
  /*
  B
  Create a List with these four instances
  */
  val meats = Seq(steak, fish, bacon, chicken)
  /*
  C
  Using the list from (b), return a new list that contains just the weights.
  - expected result: Seq(8,6,4)
  */
  val ozList = meats.map(meat => meat.weightInOz)
  println(ozList)
  /*
  D
  Using the list from (b), return a new list that contains just the paired wines that exist
  - expected result: Seq("merlot", "pinot")
  */
  val wineList = meats.flatMap(_.pairedWine)
  println(wineList)
  /*
  E
  Determine the sum of the weights in the list of food.
  */
  val foodWeight = (meats.map(meat => meat.weightInOz)).sum
  println(foodWeight)
  /*
  F
  Assume you like "cabernet" wine. Make a copy of the steak variable and change the pairedWine to
  "cabernet"
  */
  val steakCabernet = steak.copy(pairedWine = Some("cabernet"))
  println(steakCabernet)
  /*
  G
  Using the list from (b), return a new list such that the pairedWine value for each Food instance is
  "cabernet"
  */
  val cabernetList = meats.map(meat => meat.copy(pairedWine = Some("cabernet")))
  println(cabernetList)
  /*
  H
  You are hungry. Using the list from (b), return a new list with the weightInOunces increased by 10 for
  each food.
  */
  val ozListAdd10 = meats.map(meat => meat.weightInOz + 10)
  println(ozListAdd10)
  /*
  I
  Using the list from (b), filter the list and return only those foods that weigh more than 6 ounces. Output
  only the "name" value of these foods.
    - hint: use filter and then map
    - expected result: Seq("steak", ...)
  */
  val filteredMeats = meats.filter(meat => meat.weightInOz > 6).map(meat => meat.name)
  println(filteredMeats)
  /*
  J *** - NEEDS TO BE APPENDED
  Using the list from (b), filter only on the foods that contain a pairedWine. Output only the name of these
  foods.
  */
  val pairedWineList = meats.flatMap(meat => meat.pairedWine)
  println(pairedWineList)

  /*
  Question 2: Basic List Operations:
  1. Suppose you have the lists:
  val list1 = Seq(1,2,3,4)
  val list2 = Seq(4,5,6,7)
  a. add these lists together to get:
    Seq(1,2,3,4,4,5,6,7)
  b. Add the value 8 to the list from (a).
    expected result: Seq(1,2,3,4,4,5,6,7,8)
  c. The lists have a value in common Write an expression that outputs the common value. (one liner)
  d. The lists Seq(1,2,3,4) and Seq(5,6,7,8) do not have a value in common. Write an expression that shows
  they have no value in common.
    Expected result: False
    Hint: the list of common values is empty.
  A
  add these lists together to get:
      Seq(1,2,3,4,4,5,6,7)
  */
  val list1 = Seq(1,2,3,4)
  val list2 = Seq(4,5,6,7)
  val combinedList = Seq(list1, list2).flatten
  println(combinedList)
  /*
  B
  Add the value 8 to the list from (a).
    expected result: Seq(1,2,3,4,4,5,6,7,8)
  */
  val addedList = combinedList.appended(8)
  println(addedList)
  /*
  C
  The lists have a value in common Write an expression that outputs the common value. (one liner)
  */
  println(addedList.diff(addedList.distinct).distinct)
  /*
  D
  The lists Seq(1,2,3,4) and Seq(5,6,7,8) do not have a value in common. Write an expression that shows
  they have no value in common.
    Expected result: False
    Hint: the list of common values is empty.
  Prerequisite
  The variable “list1” will be for Seq(1,2,3,4).
  The variable “list3” will be for Seq(5,6,7,8). This variable will be created for use in this test.
  */
  val list3 = Seq(5,6,7,8)
  val commonNumsList = Seq(list1, list3).flatten
  println(commonNumsList.diff(commonNumsList.distinct).distinct.isEmpty)
  /*
  Question 3
  “Group By”
  Information
  Assume you have the following case classes:
  case class Name(first: String,
  last: String)
  case class Book(title: String,
  numberOfPages: Int,
  genre: String,
  author: Name,
  coAuthors: Seq[Name])
  and the following Book instances:
  val cith = Book("Cat in the Hat", 20, "Children", Name("Dr.", Seuss"), Seq.empty[Name])
  val tgt = Book("The Giving Tree", 30, "Children", Name("Shel", "Silverstein"), Seq(Name("Bob", "Vance"),
  Name("Chris" "Evert")))
  val tdc = Book("The DaVinci Code", 350, "Mystery", Name("Dan", "Brown"), Seq.empty[Name])
  */
  case class Name(first: String, last: String)
  case class Book(title: String, numberOfPages: Int, genre: String, author: Name, coAuthors: Seq[Name], illustrators: Seq[Illustrator])
  val cith = Book("Cat in the Hat", 20, "Children", Name("Dr.", "Seuss"), Seq.empty[Name], Seq.empty[Illustrator])
  val tgt = Book("The Giving Tree", 30, "Children", Name("Shel", "Silverstein"), Seq(Name("Bob", "Vance"), Name("Chris", "Evert")), Seq.empty[Illustrator])
  val tdc = Book("The DaVinci Code", 350, "Mystery", Name("Dan", "Brown"), Seq.empty[Name], Seq.empty[Illustrator])
  /*
  A
  Create a new instance of Book in the "Mystery" genre.
  */
  val fttoi = Book("For The Thrill Of It", 447, "Mystery", Name("Simon", "Baatz"), Seq.empty[Name], Seq.empty[Illustrator])
  /*
  B
  Create a list containing all of these books
  */
  val books = Seq(cith, tgt, tdc, fttoi)
  /*
  C
  Using the list from (b), we will group these books by genre. Write the following and note the resulting
  object type:
  */
  println(books.groupBy(_.genre))
  /*
  D
  Create your own case class, and add it as a field in the Book case class.
  */
  case class Illustrator(first: String, last: String)
  /*
  E *** - NEEDS TO BE APPENDED
  Using the list from (b), output a list of author and coAuthor names naive implementation may involve
    -mapping over the list twice, but see if there is a better way!
    -expected output: Seq("Dr. Seuss", "Shel Silverstein", "Bob Vance", "Chris Evert", ...)
  */
  val authorsAndCoAuthors = Seq(books.map(book => book.author), books.map(books => books.coAuthors)).flatten
  println(authorsAndCoAuthors)




}
