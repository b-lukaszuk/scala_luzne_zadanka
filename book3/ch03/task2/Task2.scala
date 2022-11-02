object Task2 {
  def swapEltsOfEvenLengthArray(nums: Array[Int]) = {
    // for yield with ifs, see Ichoran answer in:
    // https://users.scala-lang.org/t/if-else-in-for-comprehension-when-calculating-monadic-expression/7301
    for (i <- 0 until nums.length) yield {
      if (i % 2 == 0) {
        if (i != (nums.length - 1)) {
          nums(i + 1)
        } else {
          nums(i)
        }
      } else {
        nums(i - 1)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task2.")
    println(
      s"Swapping elements of array ${Array[Int](1, 2, 3, 4).mkString(", ")}"
    )
    println(
      s"Result: ${swapEltsOfEvenLengthArray(Array[Int](1, 2, 3, 4)).mkString(", ")}"
    )
    println(
      s"Swapping elements of array ${Array[Int](1, 2, 3, 4, 5).mkString(", ")}"
    )
    println(
      s"Result: ${swapEltsOfEvenLengthArray(Array[Int](1, 2, 3, 4, 5)).mkString(", ")}"
    )
    println("That's all. Goodbye!")
    println("-" * 30)
  }
}
