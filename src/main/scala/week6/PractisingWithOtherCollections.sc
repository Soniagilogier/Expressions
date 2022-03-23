
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

//Practising
