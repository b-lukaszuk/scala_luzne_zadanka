import scala.util.Random;

object Task6 {
  def main(args: Array[String]): Unit = {

    def getCardsInDrawers(noOfCards: Int = 100): List[Int] = {
      Random.shuffle(Range(1, noOfCards).toList);
    }
    var cupboard: List[Int] = getCardsInDrawers();
    val noOfSimulations: Int = 10000;

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    println("Task 6");
    println("-" * 30);
    println("Random cards in cupboard:");
    println(cupboard.mkString(", "));
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
