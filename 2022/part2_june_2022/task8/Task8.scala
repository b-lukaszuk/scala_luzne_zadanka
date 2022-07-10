import scala.io.StdIn.readLine;
import scala.util.Random;
object Task8 {
  def main(args: Array[String]): Unit = {

    val goal: Int = 21;
    var total: Int = 0;
    var isGameOver: Boolean = false;
    var isUserOnMove: Boolean = false;

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      minIncl + rnd.nextInt(maxExcl - minIncl)
    }

    def getNumToAddToTotal(): Int = {
      val difference: Int = total - goal;
      if (difference <= 3) difference else getRandInt(1, 4)
    }

    def declareAndGetComputerInput(numGenerator: () => Int): Int = {
      val num123: Int = getNumToAddToTotal();
      println(s"Computer: I add ${num123} to the total")
      num123
    }

    def declareWinnerOrLoser(curTotal: Int = total, goal: Int = goal): Unit = {
      val who: String = if (isUserOnMove) "User" else "Computer";
      val winnerOrLoser: String = if (curTotal == goal) "Winner" else "Loser";
      println(s"${winnerOrLoser}: ${who}");
    }

    def declareCurrentGameStatus(
        curTotal: Int = total,
        goal: Int = goal
    ): Unit = {
      println(s"The total is now equal to ${curTotal}");
      if (curTotal >= goal) {
        println("Game Over.");
        declareWinnerOrLoser();
      }
    }

    def promptUserAndGetInput(): Int = {
      var usersInput: String = "";
      var isInputCorrect: Boolean = false;
      while (!isInputCorrect) {
        println("Type your number (Integer: 1, 2, or 3) to add to the total:");
        usersInput = readLine().trim();
        isInputCorrect = Array("1", "2", "3").contains(usersInput);
        if (!isInputCorrect) { println("Wrong input try again!") }
      }
      usersInput.toInt;
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
    promptUserAndGetInput();
    println("That's all. Goodbye!");
  }
}
