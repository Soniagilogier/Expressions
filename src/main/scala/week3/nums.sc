  abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat
    def + (that: Nat): Nat
    def - (that: Nat): Nat
  }

  class Succ(n: Nat) extends Nat{
    def isZero: Boolean = false
    def predecessor: Nat = n
    def successor: Nat = new Succ(this)
    def + (that: Nat): Nat = new Succ(n + that)
    def - (that: Nat): Nat = if (that.isZero) this else n - that.predecessor
    override def toString = s"Succ($n)"
  }

  object Zero extends Nat{
    def isZero: Boolean = true
    def predecessor: Nat = ???
    def successor: Nat = new Succ(this)
    def + (that: Nat): Nat = that
    def - (that: Nat): Nat = if (that.isZero) this else ???
    override def toString = "Zero"
  }

  val two = new Succ(new Succ(Zero))
  val one = new Succ(Zero)
  two + one
  two - one
  two - two
  one - two

