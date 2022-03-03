import scala.language.postfixOps

//Lists creation
val listA = List(1,2,3,4,5)
val listB = List(6,7,8,9,10)
val listC = List(1)
val nums = List(2, -4, 5, 7, 1)
val fruits = List("pear", "apple", "pineapple", "orange", "coconut")


// Sublists and element access
listA.length
listB.last
listA.init
listA.take(2)
listA.drop(2)
listA(2)

// Creating new lists
listA ++ listB
listA.reverse
listA.updated(0, 2)

// Finding elements
listA.indexOf(3)
listA.contains(3)

listC.init
listC.last

// Pair definition
val pair = ("Answer", 24)

// We could write:
val (label, value) = pair

// or...
val label = pair._1
val value = pair._2

// practising with pairs
val splitList = listA.splitAt(3)
splitList._1
splitList._2

val (_, second) = splitList

// practising with list methods
nums.sorted
fruits.sorted

nums.filter(x => x > 0)
fruits.filter(x => x.contains("apple"))

nums.map(x => x * x)
fruits.map(x => x + "s")

nums.filterNot(x => x > 0)
fruits.filterNot(x => x.contains("ea"))

nums.partition(x => x < 5)
fruits.partition(x => x.startsWith("p"))

nums.takeWhile(x => x < 3)
fruits.takeWhile(x => !x.startsWith("o"))

nums.dropWhile(x => x < 3)
fruits.dropWhile(x => !x.startsWith("o"))

nums.span(x => x < 3)
fruits.span(x => !x.startsWith("o"))

