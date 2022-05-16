object Task2_7 {
  def main(args: Array[String]): Unit = {

    val nums: Array[Double] = Array(1, 6, 23, 8, 4, 98, 3, 7, 3, 98, 4, 98)

    def getAvgOfNumsAtEvenIndexes(someNums: Array[Double]): Double = {
      if (someNums.length < 3) {
        throw new ArithmeticException("No even indexes => no average")
      } else {
        var numsAtEvenInds: Array[Double] = Array()
        for (i <- 2 until someNums.length by 2) {
          numsAtEvenInds :+= someNums(i)
        }
        numsAtEvenInds.sum / numsAtEvenInds.length
      }
    }

    println("-" * 50)
    println("Task 2.7")
    println("Given the numbers:")
    println(nums.mkString(", "))
    println("The average of numbers at even indexes is:")
    println(getAvgOfNumsAtEvenIndexes(nums))
    println("That's it goodbye!")
    println("-" * 50)
  }
}
