import scala.annotation.tailrec

@tailrec
def getTuition(start:Double, incr:Double, years: Int):Double =
    if years <= 0 then
       start
    else
       getTuition(start * (1 + incr), incr, years-1)

@tailrec
def getTotalTuition(start: Double, incr:Double=0.05,
    years: Int=4, acc:Double=0.0): Double =
    if years <= 0 then
       acc
    else
       getTotalTuition(getTuition(start, incr, 1), incr, years - 1, start + acc)

@main def task7(): Unit =
      println()
      println("-" * 30)
      println("Recursive functions for calculating total tuition. Examples.\n")

      println("Start tuition: $30,000/year. Increase 5%/year.")
      println("Total cost (4-year degree started 10 years from now).\n")

      val startTuition: Double = getTuition(30000.0, 0.05, 10)
      val totalTuition: Double = getTotalTuition(startTuition)
      println("Start tuition (10 yrs from now) %,.2f usd.".format(startTuition))
      println(s"Total tuition (after 4 yrs) %,.2f usd.".format(totalTuition))

      println("\nThat's all. Goodbye!")
      println("-" * 30)
      println()
