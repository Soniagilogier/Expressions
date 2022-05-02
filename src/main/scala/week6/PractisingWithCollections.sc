
// Vectors definition
val nums = Vector(1, 2, 3, -88)
val people = Vector("Bob", "James", "Peter")

// Vector supports the same operations as lists
// with the exception of :: (instead it uses +: or :+)
nums :+ 4   // adds the number to the end of the list
4 +: nums   // adds the number as head of the list


// Arrays & Strings definitions
val xs = Array(1, 2, 3)
val ys = "Hello world!"

// Arrays and Strings come from Java
// and support the same operations as Seq
// and can implicitly be converted to seqs
xs map (x => 2 * x)
ys filter (_.isUpper)
ys.toUpperCase()


// Range definitions
val r = 1 until 5
val s = 1 to 5

// A RANGE represents a sequence of evenly spaced integers
// and it has 3 operators: to, until and by
1 to 10 by 3
6 to 1 by -2
1 until 10 by 3
r.toArray

// Some more sequences operations
xs exists (x => x == 2)
(xs map (x => 2 * x)) forall (x => x % 2 == 0)
xs zip ys
(xs zip ys).unzip
ys flatMap (c => List(c.toUpper))
Seq("Hello", "World", "!").flatMap(_.toUpperCase())
xs.sum
xs.product
xs.max
xs.min
ys.max

//Practising with pairs
val n = 7 // i.e.
val pairs = (1 until n) map (i =>
  (1 until i) map (j => (i, j)))

val combinedPairs = ((1 until n) map (i =>
  (1 until i) map (j => (i, j)))).flatten

val flatMappedPairs = (1 until n) flatMap  (i => (1 until i) map (j => (i, j)))

// Sets definitions
val fruit = Set("apple", "banana", "pear", "pineapple")
val numSet = (1 to 6).toSet

// Practising with sets
s map (_ + 2)
fruit filter (_.startsWith("app"))
s.nonEmpty
fruit.contains("banana")

// Examples of Map collections:
val romanNumerals = Map("I" -> 1, "II" -> 2, "III" -> 3, "IV" -> 4, "V" -> 5, "VI" -> 6, "VII" -> 7, "VIII" -> 8, "IX" -> 9, "X" -> 10)
val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern", "Catalonia" -> "Barcelona")

// We can ask for a key's value as follows
capitalOfCountry("Catalonia")
romanNumerals("V")

// but if we do it with an unexisting key such as
// capitalOfCountry("Andorra")
// it will throw a notSuchElement exception
// So we can use get function as follows
capitalOfCountry get "Andorra" // returns None
capitalOfCountry get "US" // returns Some


// Two useful operations of SQL queries in addition to for-expressions are:
// groupBy and orderBy.

// orderBy on a collection can be expressed by:
// sortWith and sorted
val fruits = fruit.toList
fruits.sortWith(_.length < _.length) // custom word size order
fruits.sorted // alphabetical order

// groupBy on a collection can be expressed the same way
// it partitions a collection into a map of collections according to a
// discriminator function f
fruits.groupBy(_.head)
// the groupBy above is mapping the content of the list by the first letter
// (or head) of each element

// playing with maps
val map1 = Map("red" -> 1, "green" -> 2)
val map2 = map1 + ("green" -> 3)
val map3 = Map("blue" -> 3, "green" -> 1)
val map4 = map1 ++ map3
val map5 = Map("blue" -> 3, "yellow" -> 4)
val map6 = map1 ++ map5