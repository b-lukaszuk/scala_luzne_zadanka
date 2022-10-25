object Task4 {
  def getBmrKcal(
      weightKg: Double,
      heightCm: Double,
      ageYrs: Double,
      sexFemale: Boolean
  ): Double = {
    val BmrBase: Double = 10 * weightKg + 6.25 * heightCm - 5 * ageYrs
    if (sexFemale) BmrBase - 161
    else BmrBase + 5
  }

  def main(args: Array[String]): Unit = {
    println(getBmrKcal(90, 180, 30, false))
    println(getBmrKcal(67, 170, 30, true))
  }
}
