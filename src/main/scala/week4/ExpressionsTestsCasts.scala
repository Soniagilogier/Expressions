package week4

/** Expression object definition with Tests and Casts
 *  Drawbacks: unsafe, low-level
 */
object ExpressionsTestsCasts extends App {

  /** Trait Expr defines the structure of any kind of expressions**/
  trait Expr {
    def numValue: Int     // accessor methods only
    def varValue: String
    def leftOp: Expr
    def rightOp: Expr
  }

  /** Definition of the expression type Number **/
  class Number(n: Int) extends Expr {
    def numValue: Int = n
    def varValue: String = throw new Error("Number.varValue")
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")
  }

  /** Definition of the expression type Sum **/
  class Sum(e1: Expr, e2: Expr) extends Expr {
    def numValue: Int = throw new Error("Sum.numValue")
    def varValue: String = throw new Error("Sum.varValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }


  /** Definition of the expression type Product **/
  class Prod(e1: Expr, e2: Expr) extends Expr {
    def numValue: Int = throw new Error("Prod.numValue")
    def varValue: String = throw new Error("Prod.varValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }

  /** Definition of the expression type Variable **/
  class Var(x: String) extends Expr {
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
    if(e.isInstanceOf[Number]) e.asInstanceOf[Number].numValue
    else if(e.isInstanceOf[Var]) throw new Error(e + " is a variable")
    else if(e.isInstanceOf[Sum]) eval(e.asInstanceOf[Sum].leftOp) + eval(e.asInstanceOf[Sum].rightOp)
    else if(e.isInstanceOf[Prod]) eval(e.asInstanceOf[Prod].leftOp) * eval(e.asInstanceOf[Prod].rightOp)
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
