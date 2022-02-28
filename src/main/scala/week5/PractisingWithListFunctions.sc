import scala.language.postfixOps

//Lists creation
val listA = List(1,2,3,4,5)
val listB = List(6,7,8,9,10)
val listC = List(1)


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

