package week4

/** Expression object definition with classification and access methods
 *  Drawbacks: quadratic explosion
 */
object ExpressionsClassificationAndAccessMethods extends App {

  /** Trait Expr defines the structure of any kind of expressions**/
  trait Expr {
    def isNumber: Boolean // classification methods
    def isSum: Boolean
    def isProduct: Boolean
    def isVariable: Boolean

    def numValue: Int     // accessor methods
    def varValue: String
    def leftOp: Expr
    def rightOp: Expr
  }

  /** Definition of the expression type Number **/
  class Number(n: Int) extends Expr {
    def isNumber: Boolean = true
    def isSum: Boolean = false
    def isProduct: Boolean = false
    def isVariable: Boolean = false

    def numValue: Int = n
    def varValue: String = throw new Error("Number.varValue")
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")
  }

  /** Definition of the expression type Sum **/
  class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = true
    def isProduct: Boolean = false
    def isVariable: Boolean = false

    def numValue: Int = throw new Error("Sum.numValue")
    def varValue: String = throw new Error("Sum.varValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }


  /** Definition of the expression type Product **/
  class Prod(e1: Expr, e2: Expr) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = false
    def isProduct: Boolean = true
    def isVariable: Boolean = false

    def numValue: Int = throw new Error("Prod.numValue")
    def varValue: String = throw new Error("Prod.varValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }

  /** Definition of the expression type Variable **/
  class Var(x: String) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = false
    def isProduct: Boolean = false
    def isVariable: Boolean = true

    def numValue: Int = throw new Error("Var.numValue")
    def varValue: String = x
    def leftOp: Expr = throw new Error("Var.leftOp")
    def rightOp: Expr = throw new Error("Var.rightOp")
  }


  /** Eval function evaluates if the given expression is of type Number or Sum
   * @param e is an expression of any kind
   * @return the value if it is a Number or a Variable and the operation result if it is a Sum or a Product, otherwise it returns an error
   */
  def eval(e: Expr): Int = {
    if(e.isNumber) e.numValue
    else if(e.isVariable) throw new Error(e + " is a variable")
    else if(e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else if(e.isProduct) eval(e.leftOp) * eval(e.rightOp)
    else throw new Error("Unknown expression " + e)
  }

  // Testing methods
  val e1 = new Number(4)
  val e2 = new Number(5)
  val e3 = new Var("x")

  val firstSum = new Sum(e1, e2)
  val firstProd = new Prod(e1, e2)

  println("first number: " + e1.numValue)
  println("second number: " + e2.numValue)
  println("Variable: " + e3.varValue)

  println("The Sum operation is: " + firstSum.leftOp.numValue + " + " + firstSum.rightOp.numValue)
  println("And the result is: " + eval(firstSum))

  println("The Product operation is: " + firstProd.leftOp.numValue + " * " + firstProd.rightOp.numValue)
  println("And the result is: " + eval(firstProd))

}
