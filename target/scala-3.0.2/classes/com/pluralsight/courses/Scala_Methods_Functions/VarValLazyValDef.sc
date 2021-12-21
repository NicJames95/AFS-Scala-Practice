val volume = 1000
volume
println(s"Volume is: $volume")

var stockPrice = 79
println(s"Stock price is: $stockPrice")
stockPrice = 70
println(s"Stock price is now: $stockPrice")

def volume2: Int = 1000
def stockPrice2: Int = 79
def finalValue: Int = stockPrice2 * volume2
finalValue

val faceValue = 5
lazy val lazyFaceValue = 5
faceValue
lazyFaceValue
/** lazv val is immutable but is evaluated lazily i.e.
it is evaluated the first time it is referenced in code */