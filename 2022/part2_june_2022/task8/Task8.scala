object Task8 {
  def main(args: Array[String]): Unit = {
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
