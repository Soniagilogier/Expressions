package week4

import week3.IntSet


object SubtypingAndGenerics {

  def assertAllPos[S <: IntSet] (r: S): S = ???

  /**
   * In the method defined above we can see "[S < : IntSet]" which means that S is subtype of IntSet
   * If, instead, we had "[S >: NonEmpty < : IntSet]" it would mean that S is supertype of NonEmpty and subtype of IntSet
   *
   * The Barbara Liskov's substitution principle (LSP) states that 'A' is a subtype of 'B' if anything that one can do
   * with a value of type 'B' one can also do with a value of type 'A'
   *
   */

}
