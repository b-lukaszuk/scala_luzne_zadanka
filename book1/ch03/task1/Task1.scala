object Task1:
    var userInputX: Double = 0
    var userInputY: Double = 0

    def calculateDistanceFromX0Y0(x: Double, y: Double): Double =
      // c^2 = a^2 + b^2
      val cSquared: Double =
        scala.math.pow(x - 0, 2) + scala.math.pow(y - 0, 2)
      scala.math.pow(cSquared, 0.5)

    def isPointInUnitCircle(x: Double, y: Double): Boolean =
      calculateDistanceFromX0Y0(x, y) <= 1

    def printProgramDescription(): Unit =
      println(
        "Hello. This program will determine does a point given by user is inside the unit circle"
      )
      println("(a circle centered on the origin with radius 1)")
      println("Still, I make no promisses, that the program works correctly")
      println(
        "Caution again. Follow the instructions closely, since, e.g. incorrect input may crash the program\n"
      )

    def handleUsersInput(): Unit =
      println(
        "Enter the X coordinate (Double) of a point of interest and press Enter"
      )
      userInputX = scala.io.StdIn.readDouble()
      println(
        "Enter the Y coordinate (Double) of a point of interest and press Enter"
      )
      userInputY = scala.io.StdIn.readDouble()

    def printResultOfEvaluation(): Unit =
      print("\nDoes the point (%.2f, %.2f)".format(userInputX, userInputY))
      println(
        s" lies inside the unit circle? ${isPointInUnitCircle(userInputX, userInputY)}"
      )

    def main(args: Array[String]): Unit =
      println("-" * 30)
      println("Task 1\n")
      printProgramDescription()
      handleUsersInput()
      printResultOfEvaluation()
      println("\nThat's all. Goodbye!")
      println("-" * 30)
