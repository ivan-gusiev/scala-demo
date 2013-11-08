package scalaDemo

class Complex(val x: Double, val j: Double) extends Ordered[Complex] { 

  def length: Double = math.sqrt( x * x + j * j )
  
  def <(that: Complex) = this.length < that.length
  
}