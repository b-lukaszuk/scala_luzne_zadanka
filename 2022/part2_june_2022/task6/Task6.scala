import scala.util.Random;

object Task6 {
  def main(args: Array[String]): Unit = {

    val noOfPrisoners: Int = 10;
    val noOfCards: Int = 10;

    def getCardsInDrawers(noOfCards: Int = noOfCards): List[Int] = {
      Random.shuffle(Range(0, noOfCards).toList);
    }
    var cupboard: List[Int] = getCardsInDrawers();
    val noOfSimulations: Int = 10000;

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    def getNextGuess(
        prevGuess: Int,
        atRandom: Boolean,
        cardsInCupboard: List[Int] = cupboard
    ): Int = {
      if (atRandom) {
        cardsInCupboard(getRandInt(0, noOfCards));
      } else {
        cardsInCupboard(prevGuess);
      }
    }

    def didPrisFoundCard(
        prisId: Int,
        noOfGuesses: Int,
        atRandom: Boolean = true
    ): Boolean = {
      var result: Boolean = false;
      var counter: Int = 0;
      var prevGuess: Int = cupboard(getRandInt(0, noOfCards));
      while (!result && counter < noOfGuesses) {
        println(s"cur guess: ${prevGuess}");
        if (prisId == prevGuess) {
          result = true;
        } else {
          prevGuess = getNextGuess(prevGuess, atRandom);
          counter += 1;
        }
      }
      result;
    }

    println("Task 6");
    println("-" * 30);
    println(cupboard.mkString(", "));
    println("random guesses")
    didPrisFoundCard(0, 10, true);
    println("strategical guesses")
    didPrisFoundCard(0, 10, false);
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
