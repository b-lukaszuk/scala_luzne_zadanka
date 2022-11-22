object Task1 {
  def myMin1(numbers: Int*): Int = {
    var minimum: Int = Int.MaxValue
    for (number <- numbers) {
      minimum = if (number < minimum) number else minimum
    }
    minimum
  }

  def myMin2(numbers: Int*): Int = {
    var minimum: Int = Int.MaxValue
    for (number <- numbers) {
      minimum = number.min(minimum)
    }
    minimum
  }

  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task1.")
    println("\nExamples of fns returning minimum (variable number of args):")
    println(s"myMin1(1, 10, -4, -33, 0) = ${myMin1(1, 10, -4, -33, 0)}")
    println(s"myMin2(1, 10, -4, -33, 0) = ${myMin2(1, 10, -4, -33, 0)}")
    println(s"myMin1(0, 1, 5, 0) = ${myMin1(0, 1, 5, 0)}")
    println(s"myMin2(1, 5, 0, 10) = ${myMin2(1, 5, 0, 10)}")
    println("\nThat's all. Goodbye.")
    println("-" * 30)
  }
}
