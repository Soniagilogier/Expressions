import scala.annotation.tailrec

  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {

    @tailrec
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(2)
  sqrt(4)
  sqrt(1e-6)
  sqrt(1e60)


val x = 1

def f(y: Int) = y +1

val result = {
  val x = f(3)
  x * x
} + x

// Factorial function recursive
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n-1)

factorial(4)

// Factorial function tail recursive
def factorialB(n: Int): Int = {
  @tailrec
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)

  loop(1, n)
}

factorialB(4)



