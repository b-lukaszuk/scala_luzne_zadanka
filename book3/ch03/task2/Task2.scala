object Task2:
  def swapOddAndEvenEltsOfArray[A](array1: Array[A]): IndexedSeq[A] =
    // for yield with ifs, see Ichoran answer in:
    // https://users.scala-lang.org/t/if-else-in-for-comprehension-when-calculating-monadic-expression/7301
    for (i <- 0 until array1.length) yield
      if (i % 2 == 0)
        if (i != (array1.length - 1))
          array1(i + 1)
        else
          array1(i)
      else
        array1(i - 1)

  def main(args: Array[String]): Unit =
    println("-" * 30)
    println("Task2.")
    println(
      s"Swapping elements of array: ${Array[Int](1, 2, 3, 4).mkString(", ")}"
    )
    println(
      s"Result: ${swapOddAndEvenEltsOfArray(Array[Int](1, 2, 3, 4)).mkString(", ")}"
    )
    println(
      s"Swapping elements of array: ${Array[Int](1, 2, 3, 4, 5).mkString(", ")}"
    )
    println(
      s"Result: ${swapOddAndEvenEltsOfArray(Array[Int](1, 2, 3, 4, 5)).mkString(", ")}"
    )
    println(s"Swapping elements of array: ${Array[Char]('a', 'b', 'c').mkString(", ")}")
    println(s"Result: ${swapOddAndEvenEltsOfArray(Array[Char]('a', 'b', 'c')).mkString(", ")}")
    println("That's all. Goodbye!")
    println("-" * 30)
