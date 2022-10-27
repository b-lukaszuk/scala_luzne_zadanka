import activityLevel._
import person._

object Task4 {
  def main(args: Array[String]): Unit = {
    println()
    println("-" * 30)
    val people: Array[Person] = Array(
      new Person(68, 170, 20, true, ActivityLevel.ModeratelyActive, -5),
      new Person(80, 182, 30, false, ActivityLevel.LightlyActive, +2),
      new Person(95, 182, 40, false, ActivityLevel.Sedentary, -5),
      new Person(63, 162, 23, true, ActivityLevel.ModeratelyActive, -3)
    )
    println("Task 4")
    for (person <- people) {
      println(person)
    }
    println("-" * 30)
    println()
  }
}
