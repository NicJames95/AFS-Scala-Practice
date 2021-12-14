def transform(numbers: Seq[Int], f: Int => Int): Seq[Int] =
  numbers.map(number => f(number))

val someNumbers = Seq(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
// variations of function literal syntax
// function literal (x: Int) => x + 1
val numbersIncrementBy1 = transform(someNumbers, (x: Int) => x + 1)

// function literal without argument for x
val numbersSquared = transform(someNumbers, x => math.pow(x, 2).intValue())

// function literal with 2
val numbersMultipliedBy2 = transform(someNumbers, 2 * _)