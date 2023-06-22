object Task1:

  class Point(val x: Int, val y: Int):
    override def toString = s"($x, $y)"

  class Square(lBotCorn: Point, width: Int) extends
  java.awt.Rectangle(width, width, lBotCorn.x, lBotCorn.y):

    def this(width: Int) =
      this(new Point(0, 0), width)

    def this() =
      this(0)

    override def toString = s"Sq[left bottom corner: $lBotCorn, width: $width]"

  def main(args: Array[String]) =
    println("-" * 30)
    println("Square constructors examples.")
    val sq1: Square = new Square(new Point(3, 3), 3)
    val sq2: Square = new Square(4)
    val sq3: Square = new Square()
    println(s"Square defined with primary constructor $sq1")
    println(s"Square defined with 1st auxiliary constructor $sq2")
    println(s"Square defined with 2nd auxiliary constructor $sq3")
    println("That's all. Goodbye.")
    println("-" * 30)
