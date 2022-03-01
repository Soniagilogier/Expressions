package week5

object TuplesAndPairs extends App {

  // msort implementation splits a list into 2 equal part, sorts each of them and merges them again
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if (n == 0) xs
    else {
      def merge (xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      }
      // tuple of the two halves of the list
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

  val nums = List(2, -4, 5, 7, 1)
  println(msort(nums))

}


//
// The merge method before applying the pair pattern
//
// def merge (xs: List[Int], ys: List[Int]): List[Int] = xs match {
//  case Nil => ys
//  case x :: xs1 => ys match {
//    case Nil => xs
//    case y :: ys1 => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
//  }
//}
