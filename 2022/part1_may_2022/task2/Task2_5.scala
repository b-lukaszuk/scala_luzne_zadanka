object Task2_5 {
  def main(args: Array[String]) = {

    val nums: Array[Int] = Array(1, 6, 23, 8, 4, 98, 3, 7, 3, 98, 4, 98)

    def getMaxIndexes(someNums: Array[Int]): Array[Int] = {
      var maxIndexes: Array[Int] = Array(0)
      for (i <- 1 until someNums.length) {
        if (someNums(i) > someNums(maxIndexes(0))) {
          maxIndexes = Array(i)
        } else if (someNums(i) == someNums(maxIndexes(0))) {
          maxIndexes :+= i
        }
      }
      return maxIndexes
    }

    println("-" * 50)
    println("Task 2.5")
    println("Given the numbers:")
    nums.foreach { n => print(n.toString() + " ") }
    println("\nThe index of the index(es) of max value is/are:")
    println(getMaxIndexes(nums).mkString(", "))
    println("That's it goodbye!")
    println("-" * 50)
  }
}
