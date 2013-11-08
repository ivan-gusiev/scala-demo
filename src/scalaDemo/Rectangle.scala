package scalaDemo

trait Rectangle {
	
  def height: Int
  def width:  Int
  
  def draw: String = {
    (1 to height).map( _ => "=" * width  ).mkString("\n", "\n", "")
  }
  
}