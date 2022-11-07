object Conversions {
  def inchesToCm(inches: Double): Double = {
    inches * 2.54
  }

  def gallonsToLiters(gallons: Double): Double = {
    gallons * 3.785411784
  }

  def milesToKm(miles: Double): Double = {
    miles * 1.609344
  }
}

object Task1 {
  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task1. Conversions.")
    println("No guarantee of conversion accuracy.")
    val differentValues: Array[Double] = Array(1, 2, 3, 4)
    for (num <- differentValues) {
      println()
      println(s"${num} [inch] = ${Conversions.inchesToCm(num)} [cm]")
      println(s"${num} [gallon] = ${Conversions.gallonsToLiters(num)} [L]")
      println(s"${num} [mile] = ${Conversions.milesToKm(num)} [km]")
    }
    println("\nThat's all. Goodbye!")
    println("-" * 30)
  }
}
