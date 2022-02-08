package week3



  abstract class IntSet {
    def incl(x: Int): IntSet

    def contains(x: Int): Boolean

    def union(other: IntSet): IntSet
  }

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean = {
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true
    }

    def incl(x: Int): IntSet = {
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(elem, left, right incl x)
      else this
    }

    override def toString: String = "{" + left + elem + right + "}"

    def union(other: IntSet): IntSet =
      ((left union right) union other) incl elem
  }

  class Empty extends IntSet {
    def contains(x: Int): Boolean = false

    def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

    override def toString = "."

    def union(other: IntSet): IntSet = other
  }

  object IntSet {
    def apply(): IntSet = new Empty
    def apply(x: Int): IntSet = new Empty incl x
    def apply(x: Int, y: Int): IntSet = new Empty incl x incl y
  }

