object Task2_3 {
  def main(args: Array[String]) = {

    val nums: Array[Int] = Array(1, 6, 23, 8, 4, 98, 3, 7, 3, 98, 4, 98)

    def getMinMax(arr: Array[Int]): Array[Int] = {
      if (arr.length == 0) {
        throw new ArithmeticException(
          "cannot compute min and max of empty array"
        )
      }
      @scala.annotation.tailrec
      def getMinMax2(min: Int, max: Int, arr: Array[Int]): Array[Int] = {
        if (arr.length == 0) {
          Array(min, max)
        } else {
          val fstVal: Int = arr.head
          getMinMax2(
            if (fstVal < min) fstVal else min,
            if (fstVal > max) fstVal else max,
            arr.tail
          )
        }
      }
      getMinMax2(arr.head, arr.head, arr.tail)
    }

    val Array(min, max) = getMinMax(nums)

    println("-" * 50)
    println("Task 2.3")
    println("Given the numbers:")
    nums.foreach { n => print(n.toString() + " ") }
    println("\nThe min and max are:")
    println(s"Min: ${min}, Max: ${max}")
    println("That's it goodbye!")
    println("-" * 50)
  }
}
