import activityLevel._
import person._

object Task4 {

  var programDescription = "\nHi. This is a toy program.\n"
  programDescription += "It calculates energy requirements for a person.\n"
  programDescription += "Exemplary people are predefined in the code.\n"
  programDescription += "WARNING. NO GUARANTEE THAT THE CALCULATIONS ARE OK.\n"
  programDescription += "All clear. Let's begin.\n"

  def main(args: Array[String]): Unit = {
    println()
    println("-" * 30)
    println("Task 4")
    println(programDescription)
    val people: Array[Person] = Array(
      new Person(68, 170, 20, true, ActivityLevel.ModeratelyActive, -2),
      new Person(80, 182, 30, false, ActivityLevel.LightlyActive, +2),
      new Person(95, 182, 40, false, ActivityLevel.Sedentary, -1.5),
      new Person(63, 162, 23, true, ActivityLevel.ModeratelyActive, -1)
    )
    for (person <- people) {
      println(person)
    }
    println("That's all. Goodbye!")
    println("-" * 30)
    println()
  }
}
