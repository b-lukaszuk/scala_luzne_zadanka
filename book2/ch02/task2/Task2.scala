object Task2:
  private val arr1: Array[Int] = Array(6, 4, 3, 2, -1)
  private val arr2: Array[Int] = Array(6, 4, -3, 2, 1)
  private val arr3: Array[Char] = Array('a', 'b', 'd', 'f', 'z')
  private val arr4: Array[Char] = Array('z', 'f', 'd', 'b', 'a')
  private val arr5: Array[Double] = Array(1.1, 1.2, 1.4, 1.01, 1.5)
  private val arr6: Array[Double] = Array(8, 3.14, 0, -1, -1.2)

  private def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean =
    @annotation.tailrec
    def isEltAtXGreaterThanEltAtY(
        xInd: Int,
        yInd: Int,
        gt: (A, A) => Boolean
    ): Boolean =
      if (yInd >= as.length) true
      else if (!gt(as(xInd), as(yInd))) false
      else isEltAtXGreaterThanEltAtY(yInd, yInd + 1, gt)
    isEltAtXGreaterThanEltAtY(0, 1, gt)

  def main(args: Array[String]) =
    println("\nHi. The program tests if an array is sorted (desc)")
    println("Let's test it out.\n")

    for (arr <- Array(arr1, arr2)) {
      println(s"Testing array: [${arr.mkString(", ")}] for being sorted (desc)")
      println(s"result: ${isSorted(arr, (x: Int, y: Int) => x > y)}\n")
    }

    for (arr <- Array(arr3, arr4)) {
      println(s"Testing array: [${arr.mkString(", ")}] for being sorted (desc)")
      println(s"result: ${isSorted(arr, (x: Char, y: Char) => x > y)}\n")
    }

    for (arr <- Array(arr5, arr6)) {
      println(s"Testing array: [${arr.mkString(", ")}] for being sorted (desc)")
      println(s"result: ${isSorted(arr, (x: Double, y: Double) => x > y)}\n")
    }

    println("That's all. Goodbye!\n")
