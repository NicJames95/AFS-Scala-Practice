package practice

object Doc4_AnimalClassPractice extends App {

  /*
  case class Animal(name: String, carnivore: Boolean)
  val animalList = Seq(Animal("dog", true), Animal("cat", true), Animal("rhino", false))
    // say I want a new list where every animal is now named "fish"
    // desired result: Seq(Animal("fish", true), Animal("fish", true), Animal("fish", false))
  */
  case class Animal(name: String, carnivore: Boolean)
  val animalList = Seq(Animal("dog", true), Animal("cat", true), Animal("rhino", false))
  val fishList = animalList.map(animal => animal.copy(name = "fish"))
  /*
  val cheetah = Animal("cheetah", true)
  val fish = cheetah.copy(name = "fish")
    // ^^ i want to do this for every animal in the list
  val fishList = animalList.map(animal => animal.copy(name = "fish"))

    adds "tiny" before the input animal
  */
  def makeTiny(animal: Animal): String = {
    s"tiny$animal"
  }
  val groundhog = new Animal("groundhog", false)
  println(makeTiny(groundhog))

  // SHIFT FROM PRACTICE PROBLEMS TO SCALA EXCERCISES WEBSITE

  // Add groundhog to the list
  val appendedAnimalList = animalList.appended(groundhog)
  println(appendedAnimalList)
  // create an herbivoreList
  val herbivoreList = appendedAnimalList.filter(animal => animal.carnivore == false)
  println(herbivoreList)
  println(herbivoreList.contains(groundhog)) // true
  println(herbivoreList.contains("groundhog")) // false

  val hexString = 16.toHexString
  println(16.toHexString)
  println(hexString)
  val contains = (0 until 10).contains(10)
  println(contains)
  val foo = "foo".drop(1)
  val bar = "bar".take(2)
  println(foo)
  println(bar)
  /*
  To compute sqrt(x):

  Start with an initial estimate y (let's pick y = 1).
  Repeatedly improve the estimate by taking the mean of y and x/y.
    Example: Evaluation of the square root of 2 (x = 2):

  Estimation          Quotient              Mean
  1                   2 / 1 = 2             1.5
  1.5                 2 / 1.5 = 1.333       1.4167
  1.4167              2 / 1.4167 = 1.4118   1.4142
  1.4142              ...                   ...
  */

  def square(x: Double) = x * x
  def sumOfSquares(x: Double, y: Double) = square(x) + square(y)
  println(sumOfSquares(3, 2 + 2))

  def abs(x: Double) = if (x >= 0) x else -x
  def improve(guess: Double, x: Double) = (guess + x / guess) / 2
  def isGoodEnough(guess: Double, x: Double) = abs(guess * guess - x) < 0.001

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def factorial(n: Int): Int =
    if (n == 1) 1
    else factorial(n - 1) * n

  println(factorial(3))

  def bettersqrt(x: Double) = {
    def betterSqrtIter(guess: Double, x: Double): Double =
      if (betterIsGoodEnough(guess, x)) guess
      else betterSqrtIter(betterImprove(guess, x), x)

    def betterImprove(guess: Double, x: Double) =
      (guess + x / guess) / 2

    def betterIsGoodEnough(guess: Double, x: Double) =
      abs(square(guess) - x) < 0.001

    betterSqrtIter(1.0, x)
  }

  val x = 0
  def f(y: Int) = y + 1
  val result = {
    val x = f(3)
    x * x
  } + x

  def bestSqrt(x: Double) = {
    def bestSqrtIter(guess: Double): Double =
      if (bestIsGoodEnough(guess)) guess
      else bestSqrtIter(bestImprove(guess))

    def bestImprove(guess: Double) =
      (guess + x / guess) / 2

    def bestIsGoodEnough(guess: Double) =
      abs(square(guess) - x) < 0.001

    bestSqrtIter(1.0)
  }

  /*
  First, consider gcd, a method that computes the greatest common divisor of two numbers.

  Here's an implementation of gcd using Euclid's algorithm.

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  gcd(14, 21) is evaluated as follows:

  gcd(14, 21)
    if (21 == 0) 14 else gcd(21, 14 % 21)
   if (false) 14 else gcd(21, 14 % 21)
  gcd(21, 14 % 21)
  gcd(21, 14)
    if (14 == 0) 21 else gcd(14, 21 % 14)
    if (false) 21 else gcd(14, 21 % 14)
  gcd(14, 7)
  gcd(7, 14 % 7)
  gcd(7, 0)
    if (0 == 0) 7 else gcd(0, 7 % 0)
    if (true) 7 else gcd(0, 7 % 0)
  7
  */
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

}
