package scalaDemo

abstract class Predicate {}
case class Not  (pred: Predicate) extends Predicate
case class And  (left: Predicate, right: Predicate) extends Predicate
case class Or   (left: Predicate, right: Predicate) extends Predicate
case class Expr (expr: Expression) extends Predicate
case class Compare (left: Expression, right: Expression, cmp: String) extends Predicate
case class Bool (value: Boolean) extends Predicate

abstract class Expression {}
case class Const (value: Int) extends Expression
case class BinOp (value1: Expression, value2: Expression, op: String) extends Expression

object Optimizer
{
  def optimize(expr: Expression): Expression = expr match {
    case BinOp(x, Const(0), "+") => optimize(x)
    case BinOp(x, Const(0), "-") => optimize(x)
    case BinOp(x, Const(0), "*") => Const(0)
    case BinOp(x, Const(1), "/") => optimize(x)
    case other => other
  }
  
  def optimize(pred: Predicate): Predicate = pred match {
    case Not(And(x, y)) => Or(optimize(Not(x)), optimize(Not(y)))
    case Not(Bool(true)) => Bool(false)
    case Not(Bool(false)) => Bool(true)
    case other => other
  }
}

object Evaluator
{
  def evaluate(expr: Expression): Int = ???
  
  def evaluate(pred: Predicate): Int = ???
}