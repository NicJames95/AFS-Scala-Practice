var countries : Set[String] = Set("India", "Singapore", "US")
countries.head
countries.tail
countries.isEmpty

val developedCountries = Set("Singapore", "US")

val developingCountries = Set("India", "Malaysia")

val allCountries = developedCountries ++ developingCountries

val numberSet = Set(2,23,67,8,3)
numberSet.min
numberSet.max

numberSet += (4,5)

numberSet -= (2, 3)

numberSet.add(9)
numberSet.remove(9)

val passStudentRollNoSet = Set(1,3,4,5,6,8,9,10,12,13)
passStudentRollNoSet.contains(3)
passStudentRollNoSet.contains(4)

passStudentRollNoSet.toArray
passStudentRollNoSet.toList

val numberSortedSet = scala.collection.SortedSet(1,31,14,45,26,81,49,101,132,13)
val numberLinkedHashSet =scala.collection.LinkedHashSet(1,31,14,45,26,81,49,101,132,13)

val mutableNumberSet = scala.collection.mutable.Set(1,31,14,45,26,81,49,101,132,13)

val numberQueue = scala.collection.mutable.Queue(1,31,14,45,26,81,49,101,132,13)
numberQueue += 31

numberQueue.dequeueFirst //returns first element which satisfies predicate, then removes it

numberQueue.dequeue
// 1

numberQueue.dequeue
// 31

numberQueue.dequeueAll(x => x%2 == 0)

numberQueue.enqueue(25,19,20)

numberQueue.dequeueAll(_%2 == 0)
numberQueue.dequeueAll(_%3 == 0)