import scala.collection.mutable.HashMap

object Task4:
    // Kepler's third law of planetary motion
    // p^2 = a^3; where
    // p - orbital period [years]
    // a - semi-major axis (kind of longer radius of the elipse) [astronomical units]

    val semiMajorAxesInAU: HashMap[String, Double] = HashMap(
      "Earth" -> 1,
      "Mars" -> 1.52368055,
      "Jupiter" -> 5.2038,
      "Pluto" -> 39.482
    )

    def getPeriod(semiMajorAxisInAu: Double): Double =
      scala.math.pow(scala.math.pow(semiMajorAxisInAu, 3), 0.5)

    def printResultsOfCalculationsForPlanets(
        planetsSemiMajorAxes: HashMap[String, Double]
    ): Unit =
      planetsSemiMajorAxes.foreach { case (key, value) =>
        println("---")
        println(s"${key}")
        println("semi-major axis: %.2f [AU]".format(value))
        println("orbital period %.2f [years]".format(getPeriod(value)))
      }

    def printIntro(): Unit =
      println("The program calculates a planets orbital period [years]")
      println("Based on the planet semi-major axis [astronomical units]")
      println(
        "The calculations are based on the Kepler's third law of planetary motion"
      )
      println("NO GUARANTEE OF CORRECT RESULTS. Still, let's begin.\n")

    def main(args: Array[String]): Unit =
      println("-" * 30)
      println("Task 4.\n")
      printIntro()
      printResultsOfCalculationsForPlanets(semiMajorAxesInAU)
      println("\nThat's all. Goodbye!")
      println("-" * 30)
