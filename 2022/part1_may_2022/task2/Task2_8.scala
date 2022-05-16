object Task2_8 {
  def main(args: Array[String]): Unit = {

    val nums: Array[Int] = Array(1, 6, 23, 8, 4, 98, 3, 7, 3, 98, 4, 98)

    def addValsAtEvenIndsSubtrAtOddInds(someNums: Array[Int]): Int = {
      // like in Task2.7 (see task description) I assume that
      // 0 is neither odd nor even
      if (someNums.length < 2) {
        throw new ArithmeticException("Array must be at least 2 elements long")
      } else {
        var result: Int = 0;
        for (i <- 1 until someNums.length) {
          if (i % 2 == 0) {
            result += someNums(i)
          } else {
            result -= someNums(i)
          }
        }
        result
      }
    }

    println("-" * 50)
    println("Task 2.8")
    println("Given the numbers:")
    println(nums.mkString(", "))
    println("I start at 0")
    println("I add numbers at even indexes and subtract numbers at odd indexes")
    println("(indexing starts at 0, 0 is neither odd nor even)")
    println("In the end I get:")
    println(addValsAtEvenIndsSubtrAtOddInds(nums).toString())
    println("That's it goodbye!")
    println("-" * 50)
  }
}
