object Task1 {
  def main(args: Array[String]): Unit = {
    val annualInterestsInDecimal: Double = 0.07;
    val formatter = java.text.NumberFormat.getCurrencyInstance
    val goal: Double = 1000000;
    val monthlySavingUSD: Double = 700;
    val monthsInYear: Int = 12;
    val savingTimeInYears: Int = 30;

    def printTaskDescription(): Unit = {
      println(
        "Bryn just started a new job, but is already thinking of retirement"
      );
      println("She wants to retire as a millionaire");
      println(
        "She plans on saving $700 per month and expects to receive an annual return of 7%"
      );
      println("Will she be a millionaire if she retires in 30 years?\n");

      println("My assumptions:");
      println("Money are put into account 1st day of a month");
      println("Interests are calculated last day of a month (1/12 of +7%)\n");

    }

    def getAccountBalanceAfterXMonths(
        monthlyDeposit: Double,
        noOfMonths: Int,
        annualInterestsInDecimal: Double
    ): Double = {
      var deposit: Double = 0;
      for (i <- 1 to noOfMonths) {
        deposit += monthlyDeposit;
        deposit += deposit * (annualInterestsInDecimal / 12);
      }
      deposit;
    }

    def declareResultsOfSimulation(): Unit = {
      val accountBalance: Double = getAccountBalanceAfterXMonths(
        monthlySavingUSD,
        monthsInYear * savingTimeInYears,
        annualInterestsInDecimal
      );
      println(s"Account balance after ${savingTimeInYears} years:");
      println(formatter.format(accountBalance));
      println(s"Will she be a millionaire? ${accountBalance >= goal}\n");
      println("WARNING! NO GUARANTEE THAT THE RESULT IS CORRECT!\n")
    }

    println("-" * 30);
    println("Task 2.\n");
    printTaskDescription();
    declareResultsOfSimulation();
    println("That's all. Goodbye!")
    println("-" * 30);
  }
}
