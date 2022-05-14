object Task2_2 {
  def main(args: Array[String]) = {

    val nums: Array[Int] = Array(1, 6, 23, 8, 4, 98, 3, 7, 3, 98, 4, 98)

    def isOdd(someNum: Int): Boolean = {
      someNum % 2 == 1
    }

    def sum(arr: Array[Int]): Int = {
      @scala.annotation.tailrec
      def sum2(acc: Int, arr: Array[Int]): Int = {
        if (arr.length == 0) {
          acc
        } else {
          sum2(acc + arr.head, arr.tail)
        }
      }
      sum2(0, arr)
    }

    def getSumOfOddNums(arr: Array[Int]): Int = {
      sum(arr.filter(n => isOdd(n)))
    }

    println("-" * 50)
    println("Task 2.2")
    println("Given the numbers:")
    println(nums.mkString(", "))
    println("The sum of the odd numbers is equal to:")
    println(getSumOfOddNums(nums).toString())
    println("That's it goodbye!")
    println("-" * 50)
  }
}
