package week5

object ReasoningAboutMap {

  /**
   * Law of Map proved by structural induction
   *     (xs ++ ys) map f = (xs map f) ++ (ys map f)
   */

  // Implementation of map with pattern matching
  def map[T,U](xs: List[T], f: T => U): List[U] = xs match {
    case Nil => Nil
    case x :: xs => f(x) :: xs.map(f)
  }

  // Base case: Nil --> (Nil ++ ys) map f = (Nil map f) ++ (ys map f)
  //
  // For the left-hand side: (Nil ++ ys) map f  -> by 1st clause of concat we can reduce it to: ys map f
  //
  // For the right-hand side: (Nil map f) ++ (ys map f) -> by 1st clause of map we can reduce it to: ys map f
  //
  // So we have: ys map f = ys map f
  //
  // The base case is established.


  // Induction step: (x :: xs) --> ((x :: xs) ++ ys) map f = ((x :: xs) map f) ++ (ys map f)
  //
  // For the left-hand side: ((x :: xs) ++ ys) map f -> by 2nd clause of concat we can reduce it to: (x :: (xs ++ ys)) map f
  //                                                 -> by 2nd clause of map we can reduce it to: (f(x) :: (xs map f)) ++ (ys map f)
  //                                                 -> by induction hypotesis we can reduce it to: f(x) :: ((xs map f) ++ (ys map f))
  // For the right-hand side: ((x :: xs) map f) ++ (ys map f) -> by 2nd clause of concat we can reduce it to: f(x) :: ((xs map f) ++ (ys map f))
  //
  // So we have: f(x) :: ((xs map f) ++ (ys map f)) = f(x) :: ((xs map f) ++ (ys map f))
  //
  // The property is established.

}
