class Time(val hours: Int, val minutes: Int) {
  require(hours >= 0 && hours <= 23)
  require(minutes >= 0 && minutes <= 59)

  private def optional0(hrsOrMins: Int): String = {
    if (hrsOrMins < 10) "0" else ""
  }

  override def toString(): String = {
    s"${optional0(hours)}${hours}:${optional0(minutes)}${minutes}"
  }

  def timeToMins(): Int = {
    this.hours * 60 + this.minutes
  }

  def before(other: Time): Boolean = {
    this.timeToMins() < other.timeToMins()
  }
}

object Task1 {
  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task1.\n")
    val time1: Time = new Time(5, 23)
    val time2: Time = new Time(1, 54)
    val time3: Time = new Time(10, 2)
    println(s"${time1} < ${time2} = ${time1.before(time2)}")
    println(s"${time1} < ${time3} = ${time1.before(time3)}")
    println("\nThat's all. Goodbye!")
    println("-" * 30)
  }
}
