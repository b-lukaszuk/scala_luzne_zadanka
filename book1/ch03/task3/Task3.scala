object Task3:
    def putNumToRange(
        number: Float,
        rangeMinIncl: Int = 0,
        rangeMaxIncl: Int = 255
    ): Int = number match
      case number if (number < rangeMinIncl) => rangeMinIncl
      case number if (number > rangeMaxIncl) => rangeMaxIncl
      case _                                 => Math.round(number)

    def printProgramDescription(): Unit =
      println("Hello. This is a toy program.")
      println("The program asks user to enter four digits.")
      println("The digits represent colors in computer ARGB format.")
      println("Each digit is an integer in range 0-255 (incl-incl).")
      println("Next, the program will display ARGB32 value.")
      println("Try to provide correct input otherwise the program may crash.")
      println("NO GUARANTEE OF ITS ACCURACY. Still, I hope it'll work fine.")
      println("All clear. Then let's begin.")

    def getUserInputForCanal(cannalName: String): Int =
      var colorValue: Int = 0
      var numberAcquired: Boolean = false
      while (!numberAcquired)
        try
          println(s"\nEnter value [integer 0-255] for cannal ${cannalName}:")
          println("Incorrect numbers are rounded to the closest correct value")
          colorValue = putNumToRange(scala.io.StdIn.readFloat())
          println(s"Value read: ${colorValue}")
          numberAcquired = true
        catch
          case e: NumberFormatException =>
            println("That was not a number. Try again.")
      colorValue

    def IntToHex(number: Int): String =
      val result: String = number.toHexString
      "0" * (2 - result.length) + result

    def handleUserInputAndAnswer(): Unit =
      var cannals: Array[String] = Array("A", "R", "G", "B")
      var argb32hex: String = ""
      cannals.foreach((cannal) =>
        argb32hex += IntToHex(getUserInputForCanal(cannal))
      )
      println(s"\nThe color ARGB32 (hex): ${argb32hex}")

    def main(args: Array[String]): Unit =
      println("-" * 30)
      println("Task 3\n")
      printProgramDescription()
      handleUserInputAndAnswer()
      println("\nThat's all. Goodbye!")
      println("-" * 30)
