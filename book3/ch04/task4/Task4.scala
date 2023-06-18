import scala.util.Random.{nextInt}

object Task4:
  def get_n_ints(n: Int, maxExcl: Int = 30): Array[Int] =
    val randomInts: Array[Int] = new Array(n)
    for (i <- 0 until n) randomInts(i) = nextInt(maxExcl)
    randomInts

  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) =
    var lt: Int = 0; var eq: Int = 0; var gt: Int = 0
    for (num <- values)
      if (v > num) lt += 1
      if (v == num) eq += 1
      if (v < num) gt += 1
    (lt, eq, gt)

  def main(args: Array[String]): Unit =
    println("-" * 30)
    println("Task4.\n")
    val arr1: Array[Int] = get_n_ints(5)
    val arr2: Array[Int] = get_n_ints(5)
    println(s"arr1: ${arr1.mkString("[", ",", "]")}")
    println(s"arr1 (lt 5, eq 5, gt 5) = ${lteqgt(arr1, 5)}")
    println(s"arr2: ${arr2.mkString("[", ",", "]")}")
    println(s"arr2 (lt 10, eq 10, gt 10) = ${lteqgt(arr2, 10)}")
    println("\nThat's all. Goodbye!")
    println("-" * 30)
