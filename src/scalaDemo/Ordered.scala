package scalaDemo

trait Ordered[T <: Ordered[T]] { this: T =>

  def < (that: T): Boolean
  def > (that: T): Boolean
  def <=(that: T): Boolean
  def >=(that: T): Boolean
  
}