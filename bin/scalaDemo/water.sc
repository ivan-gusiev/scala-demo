package scalaDemo

object water {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
      
  type Hill = List[Int]
  
  val myHill: Hill = List(1, 3, 5, 3, 7)          //> myHill  : scalaDemo.water.Hill = List(1, 3, 5, 3, 7)
  
  def draw(hill: Hill): String = ???              //> draw: (hill: scalaDemo.water.Hill)String







  type WetHill = List[(Int, Int)]
  
  def nullRain(hill: Hill): WetHill = {
    hill.map ( (_, 0) )
  }                                               //> nullRain: (hill: scalaDemo.water.Hill)scalaDemo.water.WetHill
  
  def countWater(hill: WetHill): Int = {
  	hill.map { case (g, w) => w }.reduce( (a, b) => a + b )
  }                                               //> countWater: (hill: scalaDemo.water.WetHill)Int
  
  def drawWet(hill: WetHill): String = ???        //> drawWet: (hill: scalaDemo.water.WetHill)String
  
  
  
  
  
  
  
  
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
  	}                                         //> updateLevel: (wetHill: scalaDemo.water.WetHill, left: Int, right: Int, water
                                                  //| Level: Int)List[(Int, Int)]
  
  
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