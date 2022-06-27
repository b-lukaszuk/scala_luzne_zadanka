import scala.util.Random;

object Task6 {
  def main(args: Array[String]): Unit = {

    // condition: noOfPrisoners == noOfCards
    val noOfPrisoners: Int = 100;
    val noOfCards: Int = 100;
    val guessesPerPrisoner: Int = 50;
    val noOfSimulations: Int = 10000;

    def getCardsInDrawers(noOfCards: Int = noOfCards): List[Int] = {
      Random.shuffle(Range(0, noOfCards).toList);
    }

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    def getNextGuess(
        prevGuess: Int,
        atRandom: Boolean,
        cards: List[Int]
    ): Int = {
      if (atRandom) {
        cards(getRandInt(0, cards.size));
      } else {
        cards(prevGuess);
      }
    }

    def didPrisFoundCard(
        prisId: Int,
        noOfGuesses: Int,
        cards: List[Int],
        atRandom: Boolean
    ): Boolean = {
      var result: Boolean = false;
      var counter: Int = 0;
      var prevGuess: Int =
        if (atRandom) cards(getRandInt(0, noOfCards)) else cards(prisId);

      while (!result && counter < noOfGuesses) {
        if (prisId == prevGuess) {
          result = true;
        } else {
          prevGuess = getNextGuess(prevGuess, atRandom, cards);
          counter += 1;
        }
      }
      result;
    }

    def didAllPrisFoundCard(
        noOfPrisoners: Int,
        guessesPerPrisoner: Int,
        cards: List[Int],
        atRandom: Boolean
    ): Boolean = {
      var result: Boolean = true;
      var counter: Int = 0;
      while (counter < noOfPrisoners && result) {
        result = didPrisFoundCard(counter, guessesPerPrisoner, cards, atRandom);
        counter += 1;
      }
      result;
    }

    def getProbOfSuccess(
        atRandom: Boolean = true,
        noOfIterations: Int = noOfSimulations,
        noOfPrisoners: Int = noOfPrisoners,
        guessesPerPrisoner: Int = guessesPerPrisoner
    ): Double = {
      var successes: Array[Boolean] = Array[Boolean]();
      for (i <- 0 until noOfIterations) {
        successes :+= didAllPrisFoundCard(
          noOfPrisoners,
          guessesPerPrisoner,
          getCardsInDrawers(),
          atRandom
        );
      }
      successes
        .map(s => if (s) 1 else 0)
        .reduce((acc, cur) => acc + cur)
        .toDouble / noOfIterations;
    }

    def declare(): Unit = {
      println(
        "Calculating probability of success (all prisoners finding card with their id) for:"
      );
      println(
        s"${noOfPrisoners} prisoners, ${noOfCards} shuffled cards in cupboard"
      );
      println(s"${guessesPerPrisoner} guesses per prisoner");
      println(s"no of iterations ${noOfSimulations} guesses per prisoner");
      println("Please be patient this will take some time");
      println(s"Strategy random: p = ${getProbOfSuccess(atRandom = true)}");
      println(
        s"Strategy methodical: p = ${getProbOfSuccess(atRandom = false)}"
      );
    }

    println("Task 6");
    println("-" * 30);
    declare();
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
