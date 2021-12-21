List("A", "B", "C")
Map("a" -> 1, "b" -> 2)
Iterable("x", "y", "z")
Set(4, 6, 2, 1)
Vector("a", "b", "c", "e")
Array(("a", 1), ("b", 2))
Seq(Map("A" -> 1), Map("B" -> 2))

import scala.collection.{immutable, mutable}
val a = Set(1, 2, 3)
val b = a.to(mutable.Set)
val c = b to immutable.Set
/** Choosing what Collection
 * Seq, Set and Map
 * Big O
 * Vector as an all rounder
 * Scala prefers immutability
 * Mutable and immutable versions
 * Packages for both
 * Convert using the to method */
