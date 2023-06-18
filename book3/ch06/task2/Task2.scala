abstract class UnitConversion:
  def convert(num: Double): Double

object InchesToCm extends UnitConversion:
  def convert(inches: Double): Double =
    inches * 2.54

object GallonsToLiters extends UnitConversion:
  def convert(gallons: Double): Double =
    gallons * 3.785411784

object MilesToKm extends UnitConversion:
  def convert(miles: Double): Double =
    miles * 1.609344

object Task2:
  def main(args: Array[String]): Unit =
    println("-" * 30)
    println("Task2. Conversions.")
    println("No guarantee of conversion accuracy.")
    val differentValues: Array[Double] = Array(1, 2, 3, 4)
    for (num <- differentValues)
      println()
      println(s"${num} [inch] = ${InchesToCm.convert(num)} [cm]")
      println(s"${num} [gallon] = ${GallonsToLiters.convert(num)} [L]")
      println(s"${num} [mile] = ${MilesToKm.convert(num)} [km]")
    println("\nThat's all. Goodbye!")
    println("-" * 30)
