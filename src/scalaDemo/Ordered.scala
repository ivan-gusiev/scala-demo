package scalaDemo

trait Ordered[T <: Ordered[T]] { this: T =>

  def < (that: T): Boolean
  def > (that: T): Boolean = that < this
  def <=(that: T): Boolean = !(this > that)
  def >=(that: T): Boolean = !(this < that)
  
}