object Task2 {
  def main(args: Array[String]): Unit = {

    val daysInMonthRegularYear: Array[Int] =
      Array(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    val daysInMonthLeapYear: Array[Int] =
      Array(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    // https://en.wikipedia.org/wiki/Leap_year#Algorithm
    def isLeapYear(year: Int): Boolean = year match {
      case year if (year % 4 != 0)  => false
      case year if (year % 25 != 0) => true
      case year if (year % 16 != 0) => false
      case _                        => true
    }

    def getNoOfDaysInMonthsInYear(
        year: Int,
        regularYear: Array[Int] = daysInMonthRegularYear,
        leapYear: Array[Int] = daysInMonthLeapYear
    ): Array[Int] = year match {
      case year if (isLeapYear(year)) => leapYear
      case _                          => regularYear
    }

    def getSum(someNums: Array[Int]): Int = {
      var sum: Int = 0;
      someNums.foreach { n => sum += n }
      sum;
    }

    def throwErrorIfNumNotInRange(
        num: Int,
        minIncl: Int,
        maxIncl: Int
    ): Unit = {
      if (num < minIncl || num > maxIncl) {
        throw new Exception(
          s"the received number ${num} must be between ${minIncl} (inclusive) and ${maxIncl} (inclusive)"
        );
      }
    }

    def getDaysInYear(day: Int, month: Int, year: Int): Int = {
      val daysInMonth = getNoOfDaysInMonthsInYear(year);
      getSum(daysInMonth.take(month)) + day;
    }

    def printProgramDescription(): Unit = {
      println("Hello. This program will ask you for a specific date.");
      println(
        "Afterwards it will tell you which day of the year is the specific date."
      );
      println("Still, I make no promisses, that the program works correctly.");
      println(
        "Caution again. Follow the instructions closely, since, e.g. incorrect input may crash the program.\n"
      );
    }

    def handleUserInputAndAnswer(): Unit = {
      var year, month, day: Int = 0;
      var daysInThisMonthInThisYear: Array[Int] = Array(0);

      println("Enter year (integer 1-10000):");
      year = scala.io.StdIn.readInt();
      throwErrorIfNumNotInRange(year, 1, 10000);
      println("Enter month (integer, 1-12):");
      month = scala.io.StdIn.readInt();
      throwErrorIfNumNotInRange(month, 1, 12);
      println("Enter day (integer, 1-31):");
      day = scala.io.StdIn.readInt();
      daysInThisMonthInThisYear = getNoOfDaysInMonthsInYear(year);
      throwErrorIfNumNotInRange(day, 1, daysInThisMonthInThisYear(month));
      println(
        s"\n${year}-${month}-${day} (yyyy-mm-dd) is ${getDaysInYear(day, month, year)} day"
      );
    }

    println("-" * 30);
    println("Task 2\n");
    printProgramDescription();
    handleUserInputAndAnswer();
    println("\nThat's all. Goodbye!");
    println("-" * 30);
  }
}
