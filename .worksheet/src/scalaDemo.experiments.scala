package scalaDemo

object experiments {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  println("Welcome to the Scala worksheet");$skip(9); val res$0 = 
  
  2+2;System.out.println("""res0: Int(4) = """ + $show(res$0));$skip(31); val res$1 = 
  
  if (2 > 1) "ok" else "no";System.out.println("""res1: String = """ + $show(res$1));$skip(62); val res$2 = 
  
  try  10 / 0  catch { case e: ArithmeticException => 42 };System.out.println("""res2: Int = """ + $show(res$2));$skip(40); val res$3 = 
   
   {
		println("working")
		42
   };System.out.println("""res3: Int = """ + $show(res$3));$skip(16); 
  
  def a = 42;System.out.println("""a: => Int""");$skip(13); 
  val b = 42;System.out.println("""b  : Int = """ + $show(b ));$skip(13); 
  var c = 42;System.out.println("""c  : Int = """ + $show(c ));$skip(43); 
  lazy val d = { println("working");  42 };System.out.println("""d: => Int""");$skip(7); val res$4 = 
  
  d;System.out.println("""res4: Int = """ + $show(res$4));$skip(5); val res$5 = 
   d;System.out.println("""res5: Int = """ + $show(res$5));$skip(75); 
   
   def divRem(x: Int, y: Int): (Int, Int) = {
   	 (x / y, x % y)
   };System.out.println("""divRem: (x: Int, y: Int)(Int, Int)""");$skip(35); 
   
   val (_, rem) = divRem(5, 2);System.out.println("""rem  : Int = """ + $show(rem ));$skip(34); 
   
   val c1 = new Complex(1, 1);System.out.println("""c1  : scalaDemo.Complex = """ + $show(c1 ));$skip(30); 
   val c2 = new Complex(2, 1);System.out.println("""c2  : scalaDemo.Complex = """ + $show(c2 ));$skip(15); val res$6 = 
   
   c1 < c2;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(11); val res$7 = 
   c1 > c2;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(12); val res$8 = 
   c1 <= c2;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(12); val res$9 = 
   c1 >= c2;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(105); 
   
   val c3 = new Complex(8, 5) with Rectangle {
   	def width = x.toInt
   	def height = j.toInt
   };System.out.println("""c3  : scalaDemo.Complex with scalaDemo.Rectangle = """ + $show(c3 ));$skip(11); val res$10 = 
   c3.draw;System.out.println("""res10: String = """ + $show(res$10))}
}
