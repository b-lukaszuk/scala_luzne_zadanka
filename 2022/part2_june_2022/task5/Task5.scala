import scala.util.Random;

object Task5 {
  def main(args: Array[String]): Unit = {

    val noOfSimulations: Int = 10000;
    val noOfPeopleAtAParty: Int = 30;

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    def getBDaysOfPplAtParty(noOfPeople: Int): Array[Int] = {
      var result: Array[Int] = Array[Int]();
      for (i <- 1 to noOfPeople) {
        result :+= getRandInt(1, 366);
      }
      result;
    }

    def anySameBirthDay(bDays: Array[Int]): Boolean = {
      bDays.toSet.size < bDays.size;
    }

    // single simulation
    def anySameBirthDayAtASingleParty(noOfPeople: Int): Boolean = {
      val peopleAtPartyBDays: Array[Int] = getBDaysOfPplAtParty(noOfPeople);
      anySameBirthDay(peopleAtPartyBDays);
    }

    // runs n simulations, returns array of false|true (failure|success)
    def runNPartiesGetResults(
        nOfParties: Int,
        noOfPeoplePerParty: Int
    ): Array[Boolean] = {
      var result: Array[Boolean] = Array[Boolean]()
      for (i <- 1 to nOfParties) {
        result :+= anySameBirthDayAtASingleParty(noOfPeoplePerParty);
      }
      result;
    }

    def runNPartiesGetProbOfAnySameBDays(
        noOfParties: Int,
        noOfPeoplePerParty: Int
    ): Double = {
      val successes: Array[Boolean] =
        runNPartiesGetResults(noOfParties, noOfPeoplePerParty);
      successes
        .map(s => if (s) 1 else 0)
        .reduce((acc, cur) => acc + cur)
        .toDouble / successes.length;
    }

    def declare(): Unit = {
      println("Calculating probability of success for:");
      println(
        "at least 2 people at a party celebrating their b-days the same day"
      );
      println(s"number of people at the party: ${noOfPeopleAtAParty}");
      println(s"number of iterations: ${noOfSimulations}");
      println("Please be patient this may take a while");
      println(
        s"p = ${runNPartiesGetProbOfAnySameBDays(noOfSimulations, noOfPeopleAtAParty)}"
      );
    }

    println("Task 5");
    println("-" * 30);
    declare();
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
