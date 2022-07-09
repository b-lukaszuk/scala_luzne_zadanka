import scala.util.Random;
object Task8 {
  def main(args: Array[String]): Unit = {

    val goal: Int = 21;
    var total: Int = 0;

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      minIncl + rnd.nextInt(maxExcl - minIncl)
    }

    def getNumToAddToTotal(): Int = {
      val difference: Int = total - goal;
      if (difference <= 3) difference else getRandInt(1, 4)
    }

    def printGameDescription(): Unit = {
      println("-" * 20)
      println("Game description")
      println("There are two players: human and computer");
      println("The players start with total = 0");
      println("The players take turns");
      println("During their turn a player adds 1, 2, or 3 to the total");
      println(
        "If after the addition the total is equal to 21, the player at move wins the game"
      );
      println(
        "If after the addition the total is greater than 21 the player at move loses the game"
      );
      println("If not, the other player takes turn");
      println("-" * 20)
    }

    def gameLoop(): Unit = {
      println("game loop");
    }

    printGameDescription();
    gameLoop();
    println("That's all. Goodbye!");
  }
}
