package week6

import week6.OtherCollections.isPrime

object CombinatorialSearch extends App {

  /**
   *  Nested loops example:
   *
   *  Given a positive integer n, find all pairs of positive integers i and j, with 1 <= j < i < n such that i+j is prime.
   *
   *  A natural way to do this is to:
   *    1 -> Generate the sequence of all pairs of integers (i, j) such that 1 <= j < i < n.
   *    2 -> Filter the pairs for which i+j is prime.
   *
   *  One natural way to do the first step is to:
   *    1.1 -> Generate all the integers i between 1 and n (excluded).
   *    1.2 -> For each integer i, generate the list of pairs (i, 1), ..., (i, i-1).
   *
   */

  // This can be achieved by combining until and map:
    val n = 7 // i.e.
    def pairs = (1 until n) map (i => (1 until i) map (j => (i, j)))

  // Pairs returns an Indexed Sequence (vector of vectors) as follows:
  // val res20: IndexedSeq[IndexedSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)), Vector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((6,1), (6,2), (6,3), (6,4), (6,5)))
  // The reason is that we start from a Range (1 until n), which is a subtype of Sequence, that got transformed with a map producing a sequence of pairs.
  // Sequences of pairs ar not element of Range and, therefore, some other representation was needed.
  // The Indexed Sequence sits between Sequence and Range, so it is the next best type higher than Range in the hierarchy, and if we take the economically implementation of it,
  // which is a vector's. So that's how we ended up with vectors of vectors.

  /**
   *  The previous step gave a sequence of sequences (xss)
   *  For the second step, we can combine all the sub-sequences xss using foldRight with ++: (xss foldRight Seq[Int]())(_ ++ _)
   *  Or, equivalently, we can use the built-in method flatten: xss.flatten
   */

  def combinedPairs = ((1 until n) map (i => (1 until i) map (j => (i, j)))).flatten

  /**
   *  Useful law: xs flatMap f = (xs map f).flatten
   */

  // taking the law into account, the above expression can be simplified to:
  def flatMappedPairs = (1 until n) flatMap  (i => (1 until i) map (j => (i, j)))

  /**
   *  At this point we have step 1 done, and we can continue to step 2 -> Filter the pairs for which i+j is prime.
   *
   */

  // we can use isPrime function defined in OtherCollections.scala
  def result = flatMappedPairs filter (pair => isPrime(pair._1 + pair._2))

  println(result)

}
