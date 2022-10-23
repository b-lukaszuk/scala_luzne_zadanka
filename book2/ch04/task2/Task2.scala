object Task2 {
  def mean(xs: Seq[Double]): Option[Double] = {
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
  }

  def variance(xs: Seq[Double]): Option[Double] = {
    if (xs.isEmpty) {
      None
    } else {
      val average: Option[Double] = mean(xs)
      val deviations: Seq[Option[Double]] = xs.map(x =>
        average.flatMap((avg: Double) => Some(math.pow(x - avg, 2)))
      )
      Some(
        deviations
          .map((deviation: Option[Double]) => deviation.getOrElse(0: Double))
          .sum
      )
    }
  }

  def main(args: Array[String]) = {
    println()
    println("=" * 20)
    println("Solution to Task2.\n")
    val numbers1: Seq[Double] = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numbers2: Seq[Double] = Seq()
    println(s"variance(Seq(1,2,3,4,5,6,7,8,9,10)) = ${variance(numbers1)}")
    println(s"variance(Seq()) = ${variance(numbers2)}")
    println("\nThat's all. Goodbye!")
    print("=" * 20)
    println("\n")
  }
}
