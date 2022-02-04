import scala.annotation.tailrec

// Class Rational represents a rational number
class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  // Alternative constructor to create rational numbers with denom = 1
  def this(x: Int) = this(x, 1)

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  // method for comparing rational numbers
  def less(that: Rational) = numer * that.denom < that.numer * denom

  // method that returns the maximum of two rational numbers
  def max(that: Rational) = if(this.less(that)) that else this

  // method for addition of rational numbers
  def add(that: Rational) = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  }

  // method for getting the negative of a rational number
  def neg: Rational = new Rational(-numer, denom)

  // method for subtraction of rational numbers
  def sub(that: Rational) = add(that.neg)

  // method for multiplication of rational numbers
  def mul(that: Rational): Rational = {
    new Rational(
      numer * that.numer, denom * that.denom)
  }

  // method for division of rational numbers
  def div(that: Rational): Rational = {
    new Rational(
      numer * that.denom, denom * that.numer)
  }

  // method to represent a rational number
  override def toString = numer + "/" + denom
}


// alternative method for addition of rational numbers
def addRational(r: Rational, s: Rational): Rational =
  new Rational(
    r.numer * s.denom + s.numer * r.denom,
    r.denom * s.denom)

// alternative method for subtraction of rational numbers
def subRational(r: Rational, s: Rational): Rational = {
  new Rational(
    r.numer * s.denom - s.numer * r.denom,
    r.denom * s.denom)
}

// alternative method for representation of rational numbers
def makeString(r: Rational) =
  r.numer + "/" + r.denom



// Testing and comparing
val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)
x.numer
x.denom

makeString(addRational(new Rational(1,2), new Rational(2,3)))
makeString(subRational(new Rational(1,2), new Rational(2,3)))

x.add(y)
x.sub(y)

x.sub(y).sub(z)
y.add(y)

x.mul(y)
x.div(z)

x.less(y)
x.max(y)

new Rational(2)