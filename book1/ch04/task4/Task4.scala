object Task4 {

  // https://www.youtube.com/watch?v=ZZ39o1rAZWY
  def getVy(speedMetPerSec: Double, angleDeg: Double): Double = {
    speedMetPerSec * Math.sin(angleDeg.toRadians)
  }

  def getDeltaVy(VyMetPerSec: Double): Double = {
    -1 * VyMetPerSec - VyMetPerSec
  }

  def getDeltaT(VyMetPerSec: Double): Double = {
    val gravity: Double = 9.8
    getDeltaVy(VyMetPerSec) / (gravity * -1)
  }

  def getVx(speedMetPerSec: Double, angleDeg: Double): Double = {
    speedMetPerSec * Math.cos(angleDeg.toRadians)
  }

  def getXMeters(timeSecs: Double, VxMetPerSec: Double): Double = {
    VxMetPerSec * timeSecs
  }

  def getYMeters(
      timeSecs: Double,
      VyMetPerSec: Double,
      initialHeightMeters: Double
  ): Double = {
    val gravity: Double = 9.8
    -1 * 0.5 * gravity * Math.pow(
      timeSecs,
      2
    ) + VyMetPerSec * timeSecs + initialHeightMeters
  }

  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task 4.")
    println(s"Vy = ${getVy(10, 30)}")
    println(s"delta t = ${getDeltaT(getVy(10, 30))}")
    println("-" * 30)
  }
}
