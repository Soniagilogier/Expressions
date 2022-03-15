package week5

object ReductionOfLists {

  /**
   * sum function sums the elements of a list of Ints and returns an Int as the result
   */
  // sum using foldLeft (more general than reduceLeft. It takes and accumulator z, which is returned when foldLeft is called on an empty list, and a function)
  def sum(xs: List[Int]): Int = xs.foldLeft(0)(_+_)

//
//  // sum using reduceLeft
//
//  def sum(xs: List[Int]): Int = (0 :: xs).reduceLeft((x, y) => x + y) // we could also write reduceLeft(_ + _)

//
//  // sum using pattern matching
//
//  def sum(xs: List[Int]): Int = xs match {
//    case Nil => 0
//    case y :: ys => y + sum(ys)
//  }

  /**
   * product function multiplies the elements of a list of Ints and returns an Int as the result
   */
  // product using foldLeft (more general than reduceLeft. It takes and accumulator z, which is returned when foldLeft is called on an empty list, and a function)
  def product(xs: List[Int]): Int = xs.foldLeft(1)(_*_)

//
//  // product using reduceLeft
//
//  def product(xs: List[Int]): Int = (1 :: xs).reduceLeft((x, y) => x * y) // we could also write reduceLeft(_ * _)

//
//  // product using pattern matching
//
//  def product(xs: List[Int]): Int = xs match {
//    case Nil => 1
//    case y :: ys => y * product(ys)
//  }
//

  // Concat using foldRight
  def concat[T](xs: List[T], ys: List[T]) = xs.foldRight(ys)(_ :: _)

  //
  //  // Concat using pattern matching
  //
  //  def concat[T](xs: List[T], ys: List[T]): Any = xs match {
  //    case List() => ys
  //    case z :: zs => List(z, concat(zs, ys))
  //  }

  // Reverse using
  def reverse[T](xs: List[T]): List[T] = xs.foldLeft(List[T]())((xs, x)=> x :: xs)

//
//  // Reverse using pattern matching
//
//  def reverse[T](xs: List[T]): List[T] = xs match {
//    case List() => List()
//    case y :: ys => reverse(ys) ++ List(y)
//  }


  // MapFun using foldRight
  def mapFun[T, U](xs: List[T], f: T => U): List[U] = (xs foldRight List[U]())((y, ys) => f(y) :: ys)

  // LengthFun using foldRight
  def lengthFun[T](xs: List[T]): Int = (xs foldRight 0)((y, n) => n + 1)
}
