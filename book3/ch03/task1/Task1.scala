object Task1 {
  def swapEltsOfEvenLengthArray(nums: Array[Int]): Array[Int] = {
    val result: Array[Int] = nums.map(identity)
    for (i <- 1 until nums.length by 2) {
      result(i-1) = nums(i)
      result(i) = nums(i-1)
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println("-"*30)
    println("Task1.")
    println(s"Swapping elements of array ${Array[Int](1, 2, 3, 4).mkString(", ")}")
    println(s"Result: ${swapEltsOfEvenLengthArray(Array[Int](1, 2, 3, 4)).mkString(", ")}")
    println(s"Swapping elements of array ${Array[Int](1, 2, 3, 4, 5).mkString(", ")}")
    println(s"Result: ${swapEltsOfEvenLengthArray(Array[Int](1, 2, 3, 4, 5)).mkString(", ")}")
    println("That's all. Goodbye!")
    println("-"*30)
  }
}
