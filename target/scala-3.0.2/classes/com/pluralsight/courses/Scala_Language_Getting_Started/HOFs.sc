def square(n: Int): Int = n * n // Int => Int
def cube(n: Int): Int = n * n * n // Int => Int
def sum(a: Int, b: Int): Int = a + b // (Int, Int) => Int
def length(a: String): Int = a.length // String => Int


def transform(f: Int => Int, numbers: Int*): Seq[Int] = numbers.map(f)
// Int* shorthand for number sequence
transform(square, 1, 2, 3, 4)
transform(cube, 1, 2, 3, 4)

transform((n: Int) => n * n, 1, 2, 3) // function literal
// provide the literal implementation of square inside transform arguments
transform(n => n * n * n, 1, 2, 3) // function literal of cube
transform(x => 2 * x, 1, 2, 3)

val numbers = Array(1, 2, 3, 4, 5, 6, 7)
numbers.map(num => num * 2)
numbers.filter(num => num % 2 == 0)
numbers.filter(num => num % 2 == 1)