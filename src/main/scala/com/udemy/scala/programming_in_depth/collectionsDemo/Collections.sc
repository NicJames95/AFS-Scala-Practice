val x = scala.collection.mutable.ArrayBuffer(2, 4, 6, 8)
x += 10
x.map(i => i + 1)
// reassignment to val
// x = x.map(i => i + 1)

val y = scala.collection.immutable.List(2,4,6,8)
// y += 10

val z = y :+ 10
y.map(i => i + 1)

val a = y.map(i => i + 1)
a :+ 10