object Expressions {

  trait Expr {
    def isNumber: Boolean // classification methods

    def isSum: Boolean // classification methods

    def numValue: Int // accessor methods

    def leftOp: Expr // accessor methods

    def rightOp: Expr // accessor methods
  }

  class Number(n: Int) extends Expr {
    def isNumber: Boolean = true

    def isSum: Boolean = false

    def numValue: Int = n

    def leftOp: Expr = throw new Error("Number.leftOp")

    def rightOp: Expr = throw new Error("Number.rightOp")
  }

  class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber: Boolean = false

    def isSum: Boolean = true

    def numValue: Int = throw new Error("Sum.numValue")

    def leftOp: Expr = e1

    def rightOp: Expr = e2
  }


  val e1 = new Number(4)
  val e2 = new Number(5)

  new Sum(e1, e2)


  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }

}