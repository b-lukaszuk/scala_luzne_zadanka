object Task2 {

  def sumDigitsInInt(number: Int): Int = {
    number.toString.split("").map(_.toInt).sum
  }

  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task2.")
    println("\nExamples of summing digits in a number (integer)")
    println(s"sumDigitsInInt(123) = ${sumDigitsInInt(123)}")
    println(s"sumDigitsInInt(723) = ${sumDigitsInInt(723)}")
    println(s"sumDigitsInInt(1185) = ${sumDigitsInInt(1185)}")
    println("\nThat's all. Goodbye.")
    println("-" * 30)
  }
}
