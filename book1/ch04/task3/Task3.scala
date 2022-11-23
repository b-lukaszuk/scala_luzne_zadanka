// https://www.mathsisfun.com/polar-cartesian-coordinates.html
class Cartesian(x: Double, y: Double) {
  override def toString(): String = {
    f"{x: $x%.2f, y: $y%.2f}"
  }

  private def getLength(): Double = {
    Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
  }

  private def getAngle(): Double = {
    Math.atan(y / x)
  }

  def toPolar(): Polar = {
    new Polar(getLength(), getAngle().toDegrees)
  }
}

class Polar(length: Double, angle: Double) {
  override def toString(): String = {
    f"{length: $length%.2f, angleDeg: $angle%.2f}"
  }

  private def getX(): Double = {
    length * Math.cos(angle.toRadians)
  }

  private def getY(): Double = {
    length * Math.sin(angle.toRadians)
  }

  def toCartesian(): Cartesian = {
    new Cartesian(getX(), getY())
  }
}

object Task3 {
  def printCartesianPolarExamples(): Unit = {
    println("\nInfo:")
    println("Cartesian {x: Double, y: Double}")
    println("Polar {length: Double, angleDeg: Double}\n")
    println("Examples:")
    val ex1: Cartesian = new Cartesian(12, 5)
    val ex2: Polar = new Polar(10, 90)
    println(s"$ex1 => ${ex1.toPolar} => ${ex1.toPolar.toCartesian}")
    println(s"$ex2 => ${ex2.toCartesian} => ${ex2.toCartesian.toPolar}")
  }

  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task 3.")
    println("Conversion between Cartesian and Polar coordinate systems.")
    printCartesianPolarExamples()
    println("\nThat's all. Goodbye.")
    println("-" * 30)
  }
}
