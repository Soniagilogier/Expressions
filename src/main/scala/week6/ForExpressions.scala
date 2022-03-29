package week6

import week6.OtherCollections.isPrime

object ForExpressions extends App{

  /** For-Expression Example */

  case class Person(name: String, age: Int)

  // Let persons be a list of elements of class Person
  def persons: List[Person] = List(Person("Anna", 23), Person("Barbara", 21), Person("Caroline", 15), Person("Daenerys", 35), Person("Erin", 19))

  // to obtain the names of persons over 20 years old, you can write:
  def personsOver20 = for (p <- persons if p.age > 20) yield p.name
  // Which is equivalent to: persons filter (p => p.age > 20) map (p => p.name)

  // practising
  def allPersons = for (p <- persons) yield p.name

  println("The persons over 20 years old are: " + personsOver20)
  println("All of the persons in the list are " + allPersons)


  /** 2nd example with the same pairs case in CombinatorialSearch.scala file */
  val n = 7 // i.e.
  def result = for {
    i <- (1 until n)
    j <- (1 until i)
    if isPrime(i + j)
  } yield (i, j)

  println("Result of pairs example: " + result)

  /** 3rd example: different version of scalarProduct function in OtherCollections.scala file */
  def scalarProduct(xs: List[Double], ys: List[Double]): Double =
    (for( (x, y) <- xs zip ys) yield x * y).sum

  println("The scalar product of the 2 lists is: " + scalarProduct(List(1, 2, 3), List(1, 2, 3)))

}
