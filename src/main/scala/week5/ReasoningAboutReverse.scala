package week5

object ReasoningAboutReverse {

  /**
   * Law of Reverse proved by structural induction
   *     xs.reverse.reverse = xs
   */

  // Implementation of reverse with pattern matching
  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y)
  }

  // Base case: Nil.reverse = Nil
  //
  // For the left-hand side: Nil.reverse -> by 1st clause of reverse we can reduce it to: Nil
  //
  // For the right-hand side: Nil
  //
  // So we have: Nil = Nil
  //
  // The base case is established.


  // Induction step: (x :: xs).reverse.reverse = (x :: xs)
  //
  // For the left-hand side: (x :: xs).reverse.reverse -> by 2nd clause of reverse we can reduce it to: (xs.reverse ++ List(x)).reverse
  //
  // For the right-hand side: (x :: xs) -> by induction hypothesis: x :: xs = x :: xs.reverse.reverse
  //
  // So we have: (xs.reverse ++ List(x)).reverse = x :: xs.reverse.reverse
  //


  // We cannot prove it directly by induction, so we must try to generalize the equation. For any list ys = xs.reverse:
  //
  // (ys ++ List(x)).reverse = x :: ys.reverse


  // Base case: (Nil ++ List(x)).reverse = x :: Nil.reverse
  //
  // For the left-hand side: (Nil ++ List(x)).reverse -> by 1st clause of concat we can reduce it to: List(x).reverse
  //                                                  -> by definition of List we can reduce it to: (x :: Nil).reverse
  //                                                  -> by 2nd clause of reverse we can reduce it to: Nil.reverse ++ List(x) = Nil ++ (x :: Nil)
  //                                                  -> by 1st clause of concat we can reduce it to: x :: Nil
  //                                                  -> by 1st clause of reverse we can reduce it to: x :: Nil.reverse
  // For the right-hand side: x :: Nil.reverse
  //
  // So we have: (x :: Nil.reverse) = (x :: Nil.reverse)
  //
  // The base case is established.


  // Induction step: ((y :: ys) ++ List(x)).reverse = x :: (y :: ys).reverse
  //
  // For the left-hand side: ((y :: ys) ++ List(x)).reverse -> by 2nd clause of concat we can reduce it to: (y :: (ys ++ List(x))).reverse
  //                                                        -> by 2nd clause of reverse we can reduce it to: (ys ++ List(x)).reverse ++ List(y)
  //                                                        -> by the induction hypothesis we can reduce it to: (x :: ys.reverse) ++ List(y)
  //                                                        -> by 1st clause of concat we can reduce it to: x :: (ys.reverse ++ List(y))
  //                                                        -> by 2nd clause of reverse we can reduce it to: x :: (y :: ys).reverse)
  // For the right-hand side: x :: (y :: ys).reverse
  //
  // So we have: x :: (y :: ys).reverse = x :: (y :: ys).reverse
  //
  // The property is established.

}
