package scalaDemo

object experiments {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  2+2                                             //> res0: Int(4) = 4
  
  if (2 > 1) "ok" else "no"                       //> res1: String = ok
  
  try  10 / 0  catch { case e: ArithmeticException => 42 }
                                                  //> res2: Int = 42
   
   {
		println("working")
		42
   }                                              //> working
                                                  //| res3: Int = 42
  
  def a = 42                                      //> a: => Int
  val b = 42                                      //> b  : Int = 42
  var c = 42                                      //> c  : Int = 42
  lazy val d = { println("working");  42 }        //> d: => Int
  
  d                                               //> working
                                                  //| res4: Int = 42
   d                                              //> res5: Int = 42
   
   def divRem(x: Int, y: Int): (Int, Int) = {
   	 (x / y, x % y)
   }                                              //> divRem: (x: Int, y: Int)(Int, Int)
   
   val (_, rem) = divRem(5, 2)                    //> rem  : Int = 1
   
   val c1 = new Complex(1, 1)                     //> c1  : scalaDemo.Complex = scalaDemo.Complex@1b23b8f7
   val c2 = new Complex(2, 1)                     //> c2  : scalaDemo.Complex = scalaDemo.Complex@46446e0c
   
   c1 < c2                                        //> res6: Boolean = true
   c1 > c2                                        //> res7: Boolean = false
   c1 <= c2                                       //> res8: Boolean = true
   c1 >= c2                                       //> res9: Boolean = false
   
   val c3 = new Complex(8, 5) with Rectangle {
   	def width = x.toInt
   	def height = j.toInt
   }                                              //> c3  : scalaDemo.Complex with scalaDemo.Rectangle = scalaDemo.experiments$$an
                                                  //| onfun$main$1$$anon$1@69e8c998
   c3.draw                                        //> res10: String = "
                                                  //| ========
                                                  //| ========
                                                  //| ========
                                                  //| ========
                                                  //| ========"
}