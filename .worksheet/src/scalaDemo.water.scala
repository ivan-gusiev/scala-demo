package scalaDemo

object water {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet")
      
  type Hill = List[Int];$skip(75); 
  
  val myHill: Hill = List(1, 3, 5, 3, 7);System.out.println("""myHill  : scalaDemo.water.Hill = """ + $show(myHill ));$skip(80); 
  
  def draw(hill: Hill): String = {
  	hill.map( "=" * _ ).mkString("\n")
  }

  type WetHill = List[(Int, Int)];System.out.println("""draw: (hill: scalaDemo.water.Hill)String""");$skip(147); 
  
  def drawWet(hill: WetHill): String = {
  	hill.map { case (g, w) => "=" * g + "|" * w }.mkString("\n")
  };System.out.println("""drawWet: (hill: scalaDemo.water.WetHill)String""");$skip(107); 
  
  def countWater(hill: WetHill): Int = {
  	hill.map { case (g, w) => w }.reduce( (a, b) => a + b )
  };System.out.println("""countWater: (hill: scalaDemo.water.WetHill)Int""");$skip(71); 
  
  def nullRain(hill: Hill): WetHill = {
    hill.map ( (_, 0) )
  };System.out.println("""nullRain: (hill: scalaDemo.water.Hill)scalaDemo.water.WetHill""");$skip(54); 
  
  val prevHill = (0 :: myHill).take(myHill.length);System.out.println("""prevHill  : List[Int] = """ + $show(prevHill ));$skip(43); 
	val nextHill = myHill.drop(1) ::: List(0);System.out.println("""nextHill  : List[Int] = """ + $show(nextHill ));$skip(38); 
	val indices = 0 to myHill.length - 1;System.out.println("""indices  : scala.collection.immutable.Range.Inclusive = """ + $show(indices ));$skip(69); 
	
	val records = List(prevHill, myHill, nextHill, indices).transpose;System.out.println("""records  : List[List[Int]] = """ + $show(records ));$skip(230); 
                                               
  var maxima = records.filter( record =>
  	(record(0) < record(1) && record(1) >= record(2)) ||
  	(record(1) > record(2) && record(0) <= record(1)))
  				            .map( _(3) );System.out.println("""maxima  : List[Int] = """ + $show(maxima ));$skip(632); 
  
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
  };System.out.println("""localMaxima: (hill: scalaDemo.water.Hill)List[Int]""");$skip(81); 
  
  def pairs(lst: List[Int]): List[(Int, Int)] = {
  	lst.zip(lst.drop(1))
  };System.out.println("""pairs: (lst: List[Int])List[(Int, Int)]""");$skip(821); 
  
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
  };System.out.println("""rain: (hill: scalaDemo.water.Hill)scalaDemo.water.WetHill""");$skip(334); 
  
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
  };System.out.println("""testHills: (hills: List[scalaDemo.water.Hill])String""");$skip(71); val res$0 = 
  
  testHills(List(myHill, List(1, 0, 1, 0, 1), List(2, 0, 3, 0, 2)));System.out.println("""res0: String = """ + $show(res$0))}
  
}
