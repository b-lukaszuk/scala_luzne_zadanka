object Task4:
  // https://www.youtube.com/watch?v=ZZ39o1rAZWY

  def getTimeSI(vySI: Double, hSI: Double, gSI: Double = 9.8): Double =
    (vySI + Math.sqrt(Math.pow(vySI, 2) + 2 * gSI * hSI)) / gSI

  def getVxSI(speedSI: Double, angleDeg: Double): Double =
    speedSI * Math.cos(angleDeg.toRadians)

  def getVySI(speedSI: Double, angleDeg: Double): Double =
    speedSI * Math.sin(angleDeg.toRadians)

  def getDistanceSI(
      vxSI: Double,
      vySI: Double,
      hSI: Double,
      gSI: Double = 9.8
  ): Double =
    vxSI * getTimeSI(vySI, hSI, gSI)

  def getDistanceSI2(
      speedSI: Double,
      angleDeg: Double,
      heightSI: Double
  ): Double =
    getDistanceSI(
      getVxSI(speedSI, angleDeg),
      getVySI(speedSI, angleDeg),
      heightSI
    )

  def printTaskDescription(): Unit =
    print("Calculating distance traveled by projectile ")
    println("(neglecting air resistance).")
    println("Assuming the projectile travels at parabolic path.")
    print("NO GUARANTEE IT WILL WORK OR WORK CORRECTLY! ")
    println("USE IT AT YOUR OWN RISK!\n")

  def main(args: Array[String]): Unit =
    println("-" * 30)
    println("Task 4.")
    printTaskDescription()
    val data: Array[Map[String, Double]] = Array(
      Map("speedSI" -> 10.0, "heightSI" -> 1.0, "angleDeg" -> 30.0),
      Map("speedSI" -> 370.0, "heightSI" -> 1.5, "angleDeg" -> 80.0),
      Map("speedSI" -> 500.0, "heightSI" -> 2.0, "angleDeg" -> 50.0)
    )

    println("Examples:")
    for (datum <- data)
      print("---\n")
      val speed: Double  = datum.getOrElse("speedSI", -999)
      val height: Double = datum.getOrElse("heightSI", -999)
      val angle: Double = datum.getOrElse("angleDeg", -999)
      println(s"initial speed: $speed [m/s]")
      println(s"initial height: $height [m]")
      println(s"initial angle: $angle [degree]")
      println(
        f"traveled distance: ${getDistanceSI2(speed, angle, height)}%.2f [m]"
      )

    println("\nThat's all. Goodbye!")
    println("-" * 30)
