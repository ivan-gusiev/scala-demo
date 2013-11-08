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
  def optimize(expr: Expression): Expression = ???
  
  def optimize(pred: Predicate): Predicate = ???
}

object Evaluator
{
  def evaluate(expr: Expression): Int = ???
  
  def evaluate(pred: Predicate): Int = ???
}