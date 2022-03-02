package week5

import math.Ordering

object TuplesAndPairs extends App {

  // msort splits a list into 2 equal part, sorts each of them and merges them again

  // STEP 5: polymorphic implementation with implicit parameter or as Scala.math.Ordering[T] as ordering function for any kind of data
  //         So we can now remove the explicit ord parameter when calling the msort method as the compiler already infers it. (see previous steps below)
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
        val n = xs.length/2
        if (n == 0) xs
        else {
          def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
            case (Nil, ys) => ys
            case (xs, Nil) => xs
            case (x :: xs1, y :: ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
          }
          // tuple of the two halves of the list
          val (fst, snd) = xs splitAt n
          merge(msort(fst), msort(snd))
        }
      }

  // Testing it with a list of numbers
  val nums = List(2, -4, 5, 7, 1)
  println(msort(nums))

  // Testing it with a list of strings
  val fruits = List("pear", "apple", "pineapple", "orange", "coconut")
  println(msort(fruits))

}

//
//  STEP 4: polymorphic implementation with Scala.math.Ordering[T] as ordering function for any kind of data
//          (passing around lt or ord values is cumbersome. We can avoid this by making ord an implicit parameter. See step 5 above)
//
//  def msort[T](xs: List[T])(ord: Ordering[T]): List[T] = {
//    val n = xs.length/2
//    if (n == 0) xs
//    else {
//    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
//    case (Nil, ys) => ys
//    case (xs, Nil) => xs
//    case (x :: xs1, y :: ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
//    }
//    // tuple of the two halves of the list
//    val (fst, snd) = xs splitAt n
//    merge(msort(fst)(ord), msort(snd)(ord))
//    }
//    }


//
//  STEP 3: msort polymorphic implementation which needs a specific ordering function for each kind of data type
//
//  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
//    val n = xs.length/2
//    if (n == 0) xs
//    else {
//    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
//    case (Nil, ys) => ys
//    case (xs, Nil) => xs
//    case (x :: xs1, y :: ys1) => if (lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
//    }
//    // tuple of the two halves of the list
//    val (fst, snd) = xs splitAt n
//    merge(msort(fst)(lt), msort(snd)(lt))
//    }
//    }

//  // Testing it with a list of numbers
//  val nums = List(2, -4, 5, 7, 1)
//  println(msort(nums)((x, y) => x < y))
//
//  // Testing it with a list of strings
//  val fruits = List("pear", "apple", "pineapple", "orange", "coconut")
//  println(msort(fruits)((x, y) => x.compareTo(y) < 0))





//
// STEP 2: msort implementation with the pair pattern in the merge method AND before generalizing it by making it polymorphic (see step 3)
//
//  def msort(xs: List[Int]): List[Int] = {
//    val n = xs.length/2
//    if (n == 0) xs
//    else {
//      def merge (xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
//        case (Nil, ys) => ys
//        case (xs, Nil) => xs
//        case (x :: xs1, y :: ys1) => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
//      }
//      // tuple of the two halves of the list
//      val (fst, snd) = xs splitAt n
//      merge(msort(fst), msort(snd))
//    }
//  }



//
// STEP 1: The merge method within msort before applying the pair pattern (see step 2)
//
// def merge (xs: List[Int], ys: List[Int]): List[Int] = xs match {
//  case Nil => ys
//  case x :: xs1 => ys match {
//    case Nil => xs
//    case y :: ys1 => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
//  }
//}
