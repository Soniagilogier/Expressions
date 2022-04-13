package week6

object nqueens extends App {

  /** The eight queens problem is to place eight queens on a chessboard so that no queen is threatened by another
   *  (That is, there can't be two queens in the same row, column or diagonal)
   *
   *  Here we solve the problem for n queens to be placed on a chessboard of size (n x n)
   */

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens

    placeQueens(n)
  }

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queensWithRow = (row - 1 to 0 by -1) zip queens
    queensWithRow forall {
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }

  def show(queens: List[Int]) = {
    val lines =
      for (col <- queens.reverse)
      yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n \n" + (lines mkString "\n")
  }

  println(queens(10) take 4 map show)

}
