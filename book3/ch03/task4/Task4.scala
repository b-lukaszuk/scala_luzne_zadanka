object Task4:
  def main(args: Array[String]): Unit =
    val allTimeZonesIDs: Array[String] = java.util.TimeZone.getAvailableIDs
    val timeZonesWithAmerica: Array[String] =
      allTimeZonesIDs.filter(_ contains "America")
    val timeZonesInAmericaWithoutPrefix: Array[String] =
      timeZonesWithAmerica.map(_.replace("America/", ""))

    println("-" * 30)
    println("Task4.\n")
    println(
      "Printing all timezones (sorted) in America (prefix 'America/' removed):"
    )
    println(timeZonesInAmericaWithoutPrefix.sorted.mkString("\n"))
    println("\nThat's all. Goodbye!")
    println("-" * 30)
