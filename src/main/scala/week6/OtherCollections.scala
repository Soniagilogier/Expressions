package week6

object OtherCollections extends App {

  /**
   *   Collections tree:
   *
   *                              Iterable             * VECTOR supports the same operations as lists with the exception of :: (instead it uses +: or :+)
   *                             /   |   \             * ARRAYS and STRINGS come from Java and support the same operations as Seq and can implicitly be converted to seqs
   *                           /     |    \            * A RANGE represents a sequence of evenly spaced integers and it has 3 operators:
   *      String ....        /       |     \              -> to (inclusive)
   *                 ..... Seq       Set    Map           -> until (exclusive)
   *       Array ....    / | \                            -> by (to determine step value)
   *                   /   |  \
   *                 /     |   \
   *              List  Range  Vector
   *
   */

  // (1 to M) flatMap (x => (1 to N) map (y => (x, y)))
  def combine(xs: Vector[String], ys: Vector[String]): Vector[(Char, Char)] = {
    xs.flatten flatMap(x => ys.flatten map (y => (x, y)))
  }

  def pair(xs: Vector[String], ys: Vector[String]): Vector[(Char, Char)] = {
    xs.flatten zip ys.flatten
  }

  // testing combine and pair to compare
  println("All combinations of the vectors: " + combine(Vector("hello world!"), Vector("HELLO WORLD!")))
  println("All pairs of the vectors: " + pair(Vector("hello world!"), Vector("HELLO WORLD!")))


  // scalar product of two vectors
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

  // We can also write the scalar product function with pattern matching function value
  def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{ case (x, y) => x * y }.sum  /// it is equivalent to x => x match { case p1 => e1 ... case pn => en }

  // isPrime function will tell us if a number is prime
  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)  // remember that 'until' is exclusive!
}
