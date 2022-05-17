object Task3_2 {
  def main(args: Array[String]): Unit = {

    val nums: Array[Int] = Array(1, 6, 23, 8, 4, 8, 3, 7)

    def getSumFstLast(someNums: Array[Int]): Int = {
      someNums(0) + someNums(someNums.length - 1)
    }

    println("-" * 50)
    println("Task 3.2")
    println("The sum of the first and last element of the array:")
    println(nums.mkString(", "))
    println("is:")
    println(getSumFstLast(nums))
    println("That's it goodbye!")
    println("-" * 50)
  }
}
