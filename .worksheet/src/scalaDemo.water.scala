package scalaDemo

object water {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet")
      
  type Hill = List[Int];$skip(75); 
  
  val myHill: Hill = List(1, 3, 5, 3, 7);System.out.println("""myHill  : scalaDemo.water.Hill = """ + $show(myHill ));$skip(40); 
  
  def draw(hill: Hill): String = ???







  type WetHill = List[(Int, Int)];System.out.println("""draw: (hill: scalaDemo.water.Hill)String""");$skip(112); 
  
  def nullRain(hill: Hill): WetHill = {
    hill.map ( (_, 0) )
  };System.out.println("""nullRain: (hill: scalaDemo.water.Hill)scalaDemo.water.WetHill""");$skip(107); 
  
  def countWater(hill: WetHill): Int = {
  	hill.map { case (g, w) => w }.reduce( (a, b) => a + b )
  };System.out.println("""countWater: (hill: scalaDemo.water.WetHill)Int""");$skip(46); 
  
  def drawWet(hill: WetHill): String = ???;System.out.println("""drawWet: (hill: scalaDemo.water.WetHill)String""");$skip(366); 
  
  
  
  
  
  
  
  
	def updateLevel(wetHill: WetHill, left: Int, right: Int, waterLevel: Int) = {
  	  var curIndex = -1
  		wetHill.map {
  			case (g, w) =>
  			  curIndex = curIndex + 1
  			  if (curIndex >= left && curIndex <= right) {
  			  	val newW = if (g >= waterLevel) 0 else waterLevel - g
  			  	(g, newW)
  			  }
  			  else (g, w)
  		}
  	};System.out.println("""updateLevel: (wetHill: scalaDemo.water.WetHill, left: Int, right: Int, waterLevel: Int)List[(Int, Int)]""")}
  
  
/*  def testHills(hills: List[Hill]) = {
  	val newLine = "\n"
  	val result = hills.map( h => {
  		val wet = rain(h)
  		val pic = draw(h)
  		val wetPic = drawWet(wet)
  		val count = countWater(wet)
  		newLine + pic + newLine * 2 + wetPic + newLine * 2 + count
  	} ).mkString(newLine * 2)
  	
  	newLine + result + newLine
  }
  
  testHills(List(myHill, List(1, 0, 1, 0, 1), List(2, 0, 3, 0, 2)))*/
  
}
