object Task2_1 {
  def main(args: Array[String]): Unit = {

    val nums: Array[Int] = Array(1, 6, 23, 8, 4, 8, 3, 7)

    def getSum1(someNums: Array[Int]): Int = {
      var sum: Int = 0
      someNums.foreach { n => sum += n }
      sum
    }

    def getSum2(someNums: Array[Int]): Int = {
      @scala.annotation.tailrec
      def getSumHelper(acc: Int, someNums: Array[Int]): Int = {
        if (someNums.length == 0) {
          acc
        } else {
          getSumHelper(acc + someNums.head, someNums.tail)
        }
      }
      getSumHelper(0, someNums)
    }

    def getSum3(someNums: Array[Int]): Int = {
      someNums.reduce((a, b) => a + b)
    }

    println("-" * 50)
    println("Task 3.1")
    println("The sum of the nums in the array:")
    println(nums.mkString(", "))
    println("is")
    println(s"according to getSum1: ${getSum1(nums)}")
    println(s"according to getSum2: ${getSum2(nums)}")
    println(s"according to getSum3: ${getSum3(nums)}")
    println("That's it goodbye!")
    println("-" * 50)
  }
}
