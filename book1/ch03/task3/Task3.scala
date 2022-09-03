object Task3 {
  def main(args: Array[String]): Unit = {

    def putIntTo0and255range(
        number: Int,
        minIncl: Int = 0,
        maxIncl: Int = 255
    ): Int = number match {
      case number if (number < minIncl) => minIncl
      case number if (number > maxIncl) => maxIncl
      case _                            => number
    }

    def printProgramDescription(): Unit = {
      println(
        "Hello. The program will ask you for the four digits (integers in range 0-255)"
      );
      println("The digits represent colors in computer ARGB format");
      println(
        "Then it will return a single digit in range 0-255 (kind of summary of the four digits given by you)"
      );
      println(
        "Be careful to provide correct input otherwise the program may crash"
      );
      println(
        "Remember there is no guarantee that the program works correctly (although I hope it should)\n"
      );
    }

    def handleUserInput(cannalName: String): Int = {
      var colorValue: Int = 0;
      println(
        s"Enter value [integer 0-255 (inclusive-inclusive)] for cannal ${cannalName}:"
      );
      println(
        "If outside the range a value will be placed within the given boundary (0-255)"
      )
      colorValue = putIntTo0and255range(scala.io.StdIn.readInt());
      println(s"Value read: ${colorValue}");
      putIntTo0and255range(colorValue);
    }

    def IntToHex(number: Int): String = {
      val result: String = number.toHexString;
      "0" * (2 - result.length) + result;
    }

    def handleUserInputAndAnswer(): Unit = {
      var cannalsNames: Array[String] = Array("A", "R", "G", "B");
      var result: String = "";
      cannalsNames.foreach((cannalName) =>
        result += IntToHex(handleUserInput(cannalName))
      )
      println(s"The color in hex is: ${result}");
    }

    println("-" * 30);
    println("Task 3\n");
    printProgramDescription();
    handleUserInputAndAnswer();
    println("\nThat's all. Goodbye!");
    println("-" * 30);
  }
}
