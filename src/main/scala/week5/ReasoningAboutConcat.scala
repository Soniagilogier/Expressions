package week5

object ReasoningAboutConcat {

  /**
   * Laws of Concat proved by structural induction
   *     (xs ++ ys) ++ zs = xs ++ (ys ++ zs)
   */

  // Implementation of Concat with pattern matching
  def concat[T](xs: List[T], ys: List[T]): Any = xs match {
    case List() => ys                           // 1st Clause -> Nil ++ ys = ys
    case z :: zs => List(z, concat(zs, ys))     // 2nd Clause -> (x :: xs1) ++ ys = x :: (xs1 ++ ys)
  }

  // Base case: Nil --> (Nil ++ ys) ++ zs = Nil ++ (ys ++ zs)
  //
  // For the left-hand side: (Nil ++ ys) ++ zs -> by 1st clause of concat we can reduce it to: ys ++ zs
  //
  // For the right-hand side: Nil ++ (ys ++ zs) -> by 1st clause of concat we can reduce it to: ys ++ zs
  //
  // So we have: ys ++ zs = ys ++ zs
  //
  // The base case is established.


  // Induction step: x :: xs --> ((x :: xs) ++ ys) ++ zs = (x :: xs) ++ (ys ++ zs)
  //
  // For the left-hand side: ((x :: xs) ++ ys) ++ zs -> by 2nd clause of concat we can reduce it to:
  //                                                                                step 1 --> (x :: (xs ++ ys)) ++ zs
  //                                                                                step 2 --> x :: ((xs ++ ys) ++ zs)
  //                                                 -> by induction hypothesis:
  //                                                                                step 3 --> x :: (xs ++ (ys ++ zs))
  //
  // For the right-hand side: (x :: xs) ++ (ys ++ zs) -> by 2nd clause of concat we can reduce it to: x :: (xs ++ (ys ++ zs))
  //
  // So we have: x :: (xs ++ (ys ++ zs)) = x :: (xs ++ (ys ++ zs))
  //
  // The property is established.



}
