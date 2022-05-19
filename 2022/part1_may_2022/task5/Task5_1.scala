import java.util.Calendar
import java.util.Date
import java.text.SimpleDateFormat

object Task5_1 {
  def main(args: Array[String]): Unit = {

    val DaysOfWeek: Map[String, String] = Map(
      "1" -> "Poniedziałek",
      "2" -> "Wtorek",
      "3" -> "Środa",
      "4" -> "Czwartek",
      "5" -> "Piątek",
      "6" -> "Sobota",
      "7" -> "Niedziela"
    )

    val now: Date = Calendar.getInstance().getTime
    val dowFormater: SimpleDateFormat = new SimpleDateFormat("u")
    // 1 - Monday, ..., 7 - Sunday
    val dowInt: String = dowFormater.format(now)

    println("-" * 50)
    println("Task 5.1")
    println("The current date and time is:")
    println(now)
    println("The day of the week in Polish is:")
    println(DaysOfWeek.get(dowInt).mkString)
    println("-" * 50)
  }
}
