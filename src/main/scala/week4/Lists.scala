package week4

object Lists {

  def insert(x: Int, xs: List[Int]): scala.List[Int] = xs match {
    case List() => List(x)
    //case y: Any :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  /*def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  } */



}
