package scalaDemo

object water {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
      
  type Hill = List[Int]
  
  val myHill: Hill = List(1, 3, 5, 3, 7)          //> myHill  : scalaDemo.water.Hill = List(1, 3, 5, 3, 7)
  
  def draw(hill: Hill): String = {
  	hill.map( "=" * _ ).mkString("\n")
  }                                               //> draw: (hill: scalaDemo.water.Hill)String

  type WetHill = List[(Int, Int)]
  
  def drawWet(hill: WetHill): String = {
  	hill.map { case (g, w) => "=" * g + "|" * w }.mkString("\n")
  }                                               //> drawWet: (hill: scalaDemo.water.WetHill)String
  
  def countWater(hill: WetHill): Int = {
  	hill.map { case (g, w) => w }.reduce( (a, b) => a + b )
  }                                               //> countWater: (hill: scalaDemo.water.WetHill)Int
  
  def nullRain(hill: Hill): WetHill = {
    hill.map ( (_, 0) )
  }                                               //> nullRain: (hill: scalaDemo.water.Hill)scalaDemo.water.WetHill
  
  val prevHill = (0 :: myHill).take(myHill.length)//> prevHill  : List[Int] = List(0, 1, 3, 5, 3)
	val nextHill = myHill.drop(1) ::: List(0) //> nextHill  : List[Int] = List(3, 5, 3, 7, 0)
	val indices = 0 to myHill.length - 1      //> indices  : scala.collection.immutable.Range.Inclusive = Range(0, 1, 2, 3, 4)
                                                  //| 
	
	val records = List(prevHill, myHill, nextHill, indices).transpose
                                                  //> records  : List[List[Int]] = List(List(0, 1, 3, 0), List(1, 3, 5, 1), List(3
                                                  //| , 5, 3, 2), List(5, 3, 7, 3), List(3, 7, 0, 4))
                                               
  var maxima = records.filter( record =>
  	(record(0) < record(1) && record(1) >= record(2)) ||
  	(record(1) > record(2) && record(0) <= record(1)))
  				            .map( _(3) )
                                                  //> maxima  : List[Int] = List(2, 4)
  
  def localMaxima(hill: Hill): List[Int] = {
    hill.length match {
    	case 0 => List()
    	case 1 => List(0)
    	case 2 => if (hill(0) > hill(1)) List(0) else List(1)
    	case _ =>
    		val prevHill = (0 :: hill).take(hill.length)
    		val nextHill = hill.drop(1) ::: List(0)
    		val indices  = 0 to hill.length - 1
    		
    		val records = List(prevHill, hill, nextHill, indices).transpose
    		
			  var maxima = records.filter( record =>
			  	(record(0) < record(1) && record(1) >= record(2)) ||
			  	(record(1) > record(2) && record(0) <= record(1)))
  				            .map( _(3) )
  			
				maxima
    }
  }                                               //> localMaxima: (hill: scalaDemo.water.Hill)List[Int]
  
  def pairs(lst: List[Int]): List[(Int, Int)] = {
  	lst.zip(lst.drop(1))
  }                                               //> pairs: (lst: List[Int])List[(Int, Int)]
  
  def rain(hill: Hill): WetHill = {
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
  	}
  
  	def rainImpl(hill: Hill, maxPairs: List[(Int, Int)], currentHill: WetHill): WetHill = maxPairs match {
  		case Nil => currentHill
  		case (left, right) :: tail =>
  			val modifiedHill = {
  				val waterLevel = math.min(hill(left), hill(right))
  				updateLevel(currentHill, left, right, waterLevel)
  			}
  			
  			rainImpl(hill, tail, modifiedHill)
  	}
    
    rainImpl(hill, pairs(localMaxima(hill)), nullRain(hill))
  }                                               //> rain: (hill: scalaDemo.water.Hill)scalaDemo.water.WetHill
  
  def testHills(hills: List[Hill]) = {
  	val newLine = "\n"
  	val result = hills.map( h => {
  		val wet = rain(h)
  		val pic = draw(h)
  		val wetPic = drawWet(wet)
  		val count = countWater(wet)
  		newLine + pic + newLine * 2 + wetPic + newLine * 2 + count
  	} ).mkString(newLine * 2)
  	
  	newLine + result + newLine
  }                                               //> testHills: (hills: List[scalaDemo.water.Hill])String
  
  testHills(List(myHill, List(1, 0, 1, 0, 1), List(2, 0, 3, 0, 2)))
                                                  //> res0: String = "
                                                  //| 
                                                  //| =
                                                  //| ===
                                                  //| =====
                                                  //| ===
                                                  //| =======
                                                  //| 
                                                  //| =
                                                  //| ===
                                                  //| =====
                                                  //| ===||
                                                  //| =======
                                                  //| 
                                                  //| 2
                                                  //| 
                                                  //| 
                                                  //| =
                                                  //| 
                                                  //| =
                                                  //| 
                                                  //| =
                                                  //| 
                                                  //| =
                                                  //| |
                                                  //| =
                                                  //| |
                                                  //| =
                                                  //| 
                                                  //| 2
                                                  //| 
                                                  //| 
                                                  //| ==
                                                  //| 
                                                  //| ===
                                                  //| 
                                                  //| ==
                                                  //| 
                                                  //| ==
                                                  //| ||
                                                  //| ===
                                                  //| ||
                                                  //| ==
                                                  //| 
                                                  //| 4
                                                  //| "
  
}