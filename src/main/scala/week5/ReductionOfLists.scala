package week5

object ReductionOfLists {

  /**
   * sum function sums the elements of a list of Ints and returns an Int as the result
   */
  // sum using reduceLeft
  def sum(xs: List[Int]): Int = (0 :: xs).reduceLeft((x, y) => x + y)

//
//  sum using pattern matching
//
//  def sum(xs: List[Int]): Int = xs match {
//    case Nil => 0
//    case y :: ys => y + sum(ys)
//  }
}
