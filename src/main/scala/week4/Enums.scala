package week4


object Enums {

  // using scala traits as enums
  sealed trait Expr {
    case class Var(s: String) extends Expr
    case class Number(n: Int) extends Expr
    case class Sum(e1: Expr, e2: Expr) extends Expr
    case class Prod(e1: Expr, e2: Expr) extends Expr
  }

  // Scala 3 offers also the enum type
  /**
  enum Expr:
  case Var(s: String)
  case Number(n: Int)
  case Sum(e1: Expr, e2: Expr)
  case Prod(e1: Expr, e2: Expr)
   **/

  // enum with simple values
  object Col extends Enumeration {
    type Color = Value
    val Red, Green, Blue = Value
  }

  var skyColor: Col.Value = Col.Blue
}
