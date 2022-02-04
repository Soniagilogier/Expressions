
// Product function sums the squares of a numbers series
def product(f: Int => Int)(a: Int, b: Int): Int =
  if(a > b) 1
  else f(a) * product(f)(a + 1, b)

// testing product function
product(x => x * x)(3, 4)

// verifying that it works
(3*3)*(4*4)

// Factorial function based in product function
def fact(n: Int) = product(x => x)(1, n)

// testing factorial
fact(5)

// MapReduce function
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if(a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

// Product function based in MapReduce function
def productMR(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x * y, 1)(a, b)

// testing new product function
productMR(x => x * x)(3, 4)