package week5

object HigherOrderListFunctions extends App {

  /**
  *   scaleList multiplies each element of a list by the same factor
  */
  // scaleList using map:
  def scaleList(xs: List[Double], factor: Double): List[Double] =
    xs.map(x => x * factor) // we could also write: xs map (x => x * factor)

//
//  scaleList using pattern matching:
//
//  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
//    case Nil => xs
//    case y :: ys => y * factor :: scaleList(ys, factor)
//  }
//

  /**
   *  squareList squares each element of a list
   */
  // squareList using map:
  def squareList(xs: List[Int]): List[Int] =
    xs.map(x => x * x) // we could also write: xs map (x => x * x)

//
//  squareList using pattern matching:
//
//  def squareList(xs: List[Int]): List[Int] = xs match {
//    case Nil => Nil
//    case y :: ys => y * y :: squareList(ys)
//  }

  /**
   * posElems selects all positive integers of a given list
   * (this is an example of the selection of elements of a given list satisfying a given condition)
   */
  // posElems using filter
  def posElems(xs: List[Int]): List[Int] =
    xs.filter(x => x > 0) // we would also write: xs filter (x => x > 0)


//
//  posElems using pattern matching
//
//  def posElems(xs: List[Int]): List[Int] = xs match {
//    case Nil => xs
//    case y :: ys => if(y > 0) y :: posElems(ys) else posElems(ys)
//  }

  /**
   * pack function packs consecutive duplicates of list elements into sublists
   */
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs.span(y => y == x)
      first :: pack(rest)
      // another valid solution would be: List(xs.takeWhile(y => y == x)) ::: pack(xs1.dropWhile(y => y == x))
  }

  // testing pack function
  val data = List("a", "a", "a", "b", "c", "c", "a")
  println(pack(data))

  /**
   *  encode produces the run-length encoding of a list (using pack function)
   */
  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs).map(x => (x.head, x.length))

//
//  We could also have applied the pattern matching as follows:
//
//  def encode[T](xs: List[T]): List[(T, Int)] = xs match {
//    case Nil => Nil
//    case x :: xs1 => (x, pack(xs).head.length):: encode(xs1.dropWhile(y => y == x))
//  }

  // testing pack function
  println(encode(data))

}


//
//  Generalization of List class:
//
//  abstract class List[T] {

//    // Simple way to define map of the List  class
//    def map[U](f: T => U): List[U] = this match {
//      case Nil => this
//      case x :: xs => f(x) :: xs.map(f)
//    }
//
//    // generalization of the pattern matching method to select all elements matching a given condition by filter method
//    def filter(p: T => Boolean): List[T] = this match {
//      case Nil => this
//      case x :: xs => if(p(x)) x :: xs.filer(p) else xs.filter(p)
//    }
//  }