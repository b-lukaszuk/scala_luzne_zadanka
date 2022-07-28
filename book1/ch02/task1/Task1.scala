object Task1 {
  def main(args: Array[String]): Unit = {

    val decimals: Array[Int] = Array(0, 1, 2, 3, 4, 10, 12, 24, 33);
    val binaries: Array[String] =
      Array("0010 0101", "0001", "0101 1010", "0010", "0011 0101", "0000");

    // condition: binaryString.length % 4 = 0
    def insertSpaceEvery4Chars(binaryString: String): String = {
      var result: String = "";
      val shift: Int = 4;
      for (i <- 0 to (binaryString.length - shift) by shift) {
        result += (
          binaryString.substring(i, i + shift) +
            (if (i + shift == binaryString.length) "" else " ")
        );
      }
      result;
    }

    def formatBinaryString(binaryString: String): String = {
      val rest: Int = binaryString.length % 4;
      var result: String =
        if (rest != 0) ("0" * (4 - rest) + binaryString) else binaryString;
      insertSpaceEvery4Chars(result);
    }

    def formatDecimalToBinaryString(decimal: Int): String = {
      var result: String = if (decimal == 0) "0" else "";
      var afterDivision: Int = decimal;
      while (afterDivision != 0) {
        result += (afterDivision % 2).toString;
        afterDivision /= 2;
      }
      return formatBinaryString(result.reverse);
    }

    def declareConvertionToBinary(decimals: Array[Int]): Unit = {
      decimals.foreach((decimal) => {
        println(s"Converting ${decimal} (decimal) to binary");
        println(s"My function: ${formatDecimalToBinaryString(decimal)}");
        println(s"Build-in function: ${decimal.toBinaryString}\n");
      })
    }

    def convertBinaryStringToDecimal(binaryString: String): Int = {
      val reversedBinaryString: String =
        binaryString.replaceAll("\\s", "").reverse;
      var result: Double = 0;
      for (i <- 0 to (reversedBinaryString.length - 1)) {
        result += (reversedBinaryString.substring(i, i + 1).toInt * scala.math
          .pow(2, i));
      }
      result.toInt;
    }

    def declareConvertionToDecimal(binaries: Array[String]): Unit = {
      binaries.foreach((binary) => {
        println(s"Converting ${binary} (binary) to decimal");
        println(s"My function: ${convertBinaryStringToDecimal(binary)}");
        println(
          s"Build-in function: ${Integer.parseInt(binary.replaceAll("\\s", ""), 2)}\n"
        );
      })
    }

    println("-" * 30);
    println("Task 1.");
    println("Decimal <-> Binary converter\n");
    println("First, Decimal -> Binary\n");
    declareConvertionToBinary(decimals);
    println("Now, Binary -> Decimal\n");
    declareConvertionToDecimal(binaries);
    println("That's all. Goodbye!")
    println("-" * 30);
  }
}
