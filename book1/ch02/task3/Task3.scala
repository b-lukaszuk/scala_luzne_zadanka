object Task3:
    val bulletV0meterPerSecond: Double = 400
    val heightPerpendicualrInMeters: Double = 1
    val gravityMeterPerSecondSquared: Double = 9.8

    // how to calculate that, starting point:
    // https://sciencing.com/calculate-bullet-trajectory-5185428.html

    def degreeToRadian(degree: Double): Double =
      // PI * Rad = 180 Deg
      degree * scala.math.Pi / 180

    def getDistanceBulletFalls(
        velocityXTime0MetersPerSecond: Double,
        heightMeters: Double,
        gravityMeterPerSecondSquared: Double
    ): Double =
      velocityXTime0MetersPerSecond * scala.math.pow(
        2 * heightMeters / gravityMeterPerSecondSquared,
        0.5
      )

    def main(args: Array[String]): Unit =
        println("-" * 30)
        println("Task 3.\n")
        print("A bullet is shot perpendicularly to the ground (height ")
        print(s"${heightPerpendicualrInMeters} [m]) with ")
        println(s"V0 = ${bulletV0meterPerSecond} [m/s]")
        println(
            s"Gravity is equal ${gravityMeterPerSecondSquared} [m/s^2]. "
          )
        println("Other forces are ignored in calculations")
        println(
            "It will land after approximatery %.2f meters".format(
                getDistanceBulletFalls(
                    bulletV0meterPerSecond,
                    heightPerpendicualrInMeters,
                    gravityMeterPerSecondSquared
                  )
              )
          )
        println("NO GUARANTEE OF CORRECT CALCULATIONS")
        println("\nThat's all. Goodbye!")
        println("-" * 30)
