package week4

object ExpressionsOODecomposition extends App {

  /** Trait Expr defines the structure of any kind of expressions**/
  trait Expr {
    def numValue: Int     // accessor methods only
    def varValue: String
    def leftOp: Expr
    def rightOp: Expr

    def eval: Int
  }

  /** Definition of the expression type Number **/
  class Number(n: Int) extends Expr {
    def numValue: Int = n
    def varValue: String = throw new Error("Number.varValue")
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")

    def eval: Int = n
  }

  /** Definition of the expression type Sum **/
  class Sum(e1: Expr, e2: Expr) extends Expr {
    def numValue: Int = throw new Error("Sum.numValue")
    def varValue: String = throw new Error("Sum.varValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2

    def eval: Int = e1.eval + e2.eval
  }


  /** Definition of the expression type Product **/
  class Prod(e1: Expr, e2: Expr) extends Expr {
    def numValue: Int = throw new Error("Prod.numValue")
    def varValue: String = throw new Error("Prod.varValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2

    def eval: Int = e1.eval * e2.eval
  }

  /** Definition of the expression type Variable **/
  class Var(x: String) extends Expr {
    def numValue: Int = throw new Error("Var.numValue")
    def varValue: String = x
    def leftOp: Expr = throw new Error("Var.leftOp")
    def rightOp: Expr = throw new Error("Var.rightOp")

    def eval: Int = throw new Error(x + " is not a number but a variable")
  }



  // Testing methods
  val e1 = new Number(4)
  val e2 = new Number(5)
  val e3 = new Var("x")

  val firstSum = new Sum(e1, e2)
  val firstProd = new Prod(e1, e2)

  println("first number: " + e1.eval)
  println("second number: " + e2.eval)
  println("Variable: " + e3.varValue)

  println("The Sum operation is: " + firstSum.leftOp.numValue + " + " + firstSum.rightOp.numValue)
  println("And the result is: " + firstSum.eval)

  println("The Product operation is: " + firstProd.leftOp.numValue + " * " + firstProd.rightOp.numValue)
  println("And the result is: " + firstProd.eval)
}
