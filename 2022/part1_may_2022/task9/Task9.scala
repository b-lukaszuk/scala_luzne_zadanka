import scala.util.Random

object Task9 {
  def main(args: Array[String]): Unit = {

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    val secretNum: Int = getRandInt(1, 100)
    var userGuess: Int = 0
    val noOfGuesses: Int = 10

    def printIntro(): Unit = {
      println("Hello, let's play a game")
      println("I'm thinking of a number between 1 and 100")
      println("Can you guess it?")
      println("Be careful while typing a guess.")
      println("Incorrect input (not an Int) will terminate the program")
      println(s"You got ${noOfGuesses} guesses")
      println("I'll give You a hint after each quess")
    }

    def printOutro(): Unit = {
      println("Game Over.")
      println(s"My secret number was ${secretNum}")
    }

    def giveHint(): Unit = {
      if (userGuess == secretNum) {
        println("You got it. Congratulations!")
      } else if (userGuess > secretNum) {
        println("too high")
      } else {
        println("too low")
      }
    }

    def gameLoop(): Unit = {
      printIntro()
      var counter: Int = 1
      while (counter <= noOfGuesses && userGuess != secretNum) {
        println(s"Guess ${counter} of ${noOfGuesses}:")
        userGuess = scala.io.StdIn.readInt()
        giveHint()
        counter += 1
      }
      printOutro()
    }

    println("-" * 50)
    println("Task 9")
    gameLoop()
    println("That's it goodbye!")
    println("-" * 50)
  }
}
