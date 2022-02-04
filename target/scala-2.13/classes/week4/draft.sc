import week4.ExpressionsPatternMatching
import week4.ExpressionsPatternMatching._

object Expressions {

  def show(e: ExpressionsPatternMatching.Expr): String = {
    e match {
      case number: Number => number.numValue.toString
      case _: Var => e.varValue
      case sum: Sum => eval(sum.leftOp) + " + " + eval(sum.rightOp)
      case prod: Prod => show(prod.leftOp) + " * " + show(prod.rightOp)
      case _ => throw new Error("Unknown expression " + e)
    }
  }

  println {
    show(new Sum(new Number(1), new Number(44)))
  }



}