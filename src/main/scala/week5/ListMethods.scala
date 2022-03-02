package week5

import scala.annotation.tailrec

object ListMethods extends App {

  // Implementation of last
  @tailrec
  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }

  // Implementation of init
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  // Implementation of concatenation
  def concat[T](xs: List[T], ys: List[T]): Any = xs match {
    case List() => ys
    case z :: zs => List(z, concat(zs, ys))
  }

  // Implementation of reverse
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y)
  }

  // removeAt method removes the element in index number n
  def removeAt[T](n: Int, xs: List[T]): List[Any] = (xs take n) ::: (xs drop n+1)

  // alternative removeAt method
  def removeAt2[T](n: Int, xs: List[T]): Any = xs match {
    case Nil => Nil
    case y :: ys =>
      if (n == 0) ys
      else List(y, removeAt2(n-1, ys))
  }

  // Implementation of flatten list
  def flatten(xs: Any): List[Any] = xs match {
    case Nil => Nil
    case y :: ys => flatten(y) ++ flatten(ys)
    case _ => xs :: Nil
  }

  // Testing flatten method
  println(flatten(List(List(1, 2), 3, List(4,5))))
}
