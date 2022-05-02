package week6

object Maps extends App {

  /**
   *  A MAP of type Map[Key, Value] is a data structure that associates keys of type Key with values of type Value.
   */

  // Examples of Map collections:
  val romanNumerals = Map("I" -> 1, "II" -> 2, "III" -> 3, "IV" -> 4, "V" -> 5, "VI" -> 6, "VII" -> 7, "VIII" -> 8, "IX" -> 9, "X" -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern", "Catalonia" -> "Barcelona")

  // We can ask for a key's value as follows
  capitalOfCountry("Catalonia")
  romanNumerals("V")

  /*
   BUT if we do it with an non existing key such as "capitalOfCountry("Andorra")" it will throw a notSuchElement exception
   So we can use get function as follows
   */
  val capitalOfAndorra = capitalOfCountry get "Andorra" // returns None
  val capitalOfUS = capitalOfCountry get "US" // returns Some

  /**
   *  The expression "map get key" returns:
   *    None -> if map does not contain the given key or
   *    Some(x) -> if map associates the given key with the value x.
   *
   *  This is because the result type of that function is an Option, which is a trait defined as follows:
   *
   *    trait Option[+A]
   *    case class Some[+A](value: A) extends Option[A]
   *    object None extends Option[Nothing]
   */

  // Since options are defined as case classes, they can be decomposed using pattern matching
  // Therefore, we can define a function to get the capitals of a given country as follows
  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(capital) => capital
    case None => "unknown"
  }

  // Testing
  println("The capital of US is: " + showCapital("US"))
  println("The capital of Andorra is: " + showCapital("Andorra"))

  /**
   *  A Polynomial can be seen as a map from exponents to coefficients
   *  For instance, x(exp 3) - 2x + 5 can be represented with the map: Map(0 -> 5, 1 -> -2, 3 -> 1)
   */

  // based on this, let's design a class that represents polynomials as maps

  class Poly(val terms0: Map[Int, Double]){
    def this(bindings: (Int, Double)*) = this(bindings.toMap) // we can redefine the constructor with bindings so we can avoid using "Map" when creating a new Poly
    val terms = terms0 withDefaultValue(0.0) // withDefaultValue prevents the map to throw an exception in case of non existing value

    // sum method with concatenation
//    def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
//    def adjust(term: (Int, Double)): (Int, Double) = {
//      val (exp, coeff) = term
//      exp -> (coeff + terms(exp))
//    }

    // sum method with foldLeft (more efficient)
    def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }


    override def toString =
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
  }

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0) // here we are using redefined constructor
  println(p1)
  println(p2)
  println(p1 + p2)
  println(p1.terms(7)) // testing withDefaultValue

}
