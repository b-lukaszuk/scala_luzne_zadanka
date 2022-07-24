import scala.io.Source

object Task1 {
  def main(args: Array[String]): Unit = {

    val decimals: Array[Int] = Array(0, 1, 2, 3, 4, 10, 12, 24, 33);

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

    def decimalToBinaryString(decimal: Int): String = {
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
        println(s"My function: ${decimalToBinaryString(decimal)}");
        println(s"Build-in function: ${decimal.toBinaryString}\n");
      })
    }

    println("-" * 30);
    println("Task 1.");
    println("Decimal <-> Binary converter\n");
    declareConvertionToBinary(decimals);
    println("\nThat's all. Goodbye!")
    println("-" * 30);
  }

}
