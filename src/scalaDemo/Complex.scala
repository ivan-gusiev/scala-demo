package scalaDemo

class Complex(val x: Double, val j: Double) { 

  def length: Double = math.sqrt( x * x + j * j )
  
}