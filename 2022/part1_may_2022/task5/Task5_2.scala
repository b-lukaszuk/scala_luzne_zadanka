import java.util.Calendar
import java.util.Date
import java.text.SimpleDateFormat

object Task5_2 {
  def main(args: Array[String]): Unit = {

    val now: Date = Calendar.getInstance().getTime
    val dowFormater: SimpleDateFormat = new SimpleDateFormat("u")
    // 1 - Monday, ..., 7 - Sunday
    val dowInt = dowFormater.format(now).toInt

    // accepts Ints from 1 (incl) to 7 (incl)
    // since dowInt is 1 - Monday, ..., 7 - Sunday
    def getDaysTill(today: Int, targetDay: Int = 5): Int = {
      if (targetDay >= today) {
        targetDay - today
      } else {
        7 - (today - targetDay)
      }
    }

    println("-" * 50)
    println("Task 5.2")
    println("The current date and time is:")
    println(now)
    println(s"The next Friday is in ${getDaysTill(dowInt)} days")
    println("-" * 50)
  }
}
