import scala.annotation.tailrec
import scala.io.StdIn.readLine

case class EndGameException(s: String)  extends Exception(s)

def printGameDescription(): Unit =
    println("Let's play a rock-paper-scisors game.")
    println("The computer makes his move at random")
    println("The player is asked to type a move via terminal.")
    println("The game lasts until one player wins 3 times.")
    println("Ready. Let's begin.")

def printChoiceMenu(): Unit =
    println("\nEnter your choice.")
    println("1. Rock")
    println("2. Paper")
    println("3. Scisors")
    println("4. Quit the game.")

@tailrec
def getUserDecision(): Int =
    printChoiceMenu()
    val userChoice: String = readLine()
    userChoice.strip() match
        case "1" => 1
        case "2" => 2
        case "3" => 3
        case "4" => throw new EndGameException("")
        case _ =>
             println("Unknown Input. Try again.")
             getUserDecision()

def declareChoice(choice: Int): String = choice match
    case 1 => "Rock"
    case 2 => "Paper"
    case 3 => "Scisors"
    case _ => "Unknown"

def getComputerDecision(): Int =
    val compChoice: Int = util.Random.between(1, 3)
    println(s"Computer choose ${declareChoice(compChoice)}")
    compChoice

def getRoundResult(userChoice: Int, compChoice: Int): List[Int] =
    (userChoice, compChoice) match
    case (1, 3) => List(1, 0)
    case (2, 1) => List(1, 0)
    case (3, 2) => List(1, 0)
    case (x, y) if (x == y) => List(0, 0)
    case _ => getRoundResult(compChoice, userChoice).reverse

@tailrec
def zipWith[A, B, C](fn: (A, B) => C,
    l1:List[A], l2:List[B], acc:List[C]=Nil): List[C] = (l1, l2) match
    case (Nil, _) => acc.reverse
    case (_, Nil) => acc.reverse
    case (x::xs, y::ys) => zipWith(fn, xs, ys, fn(x, y) :: acc)

def addLists(l1: List[Int], l2: List[Int]): List[Int] =
    zipWith((a: Int, b: Int) => a + b, l1, l2)

@tailrec
def playUntil3Wins(result:List[Int] = List(0, 0)): Unit =
    println("\nCurrent score:")
    println(s"User: ${result.head}, Computer: ${result.tail.head}")
    result match
    case List(3, _) => println("\nGAME OVER. User won 3 times.")
    case List(_, 3) => println("\nGAME OVER. Computer won 3 times.")
    case _ => playUntil3Wins(
         addLists(result,
         getRoundResult(getUserDecision(), getComputerDecision())))

@main def task6: Unit =
      println()
      println("-" * 30)
      println("Recursive functions for playing rock-paper-scissors.\n")

      try
        printGameDescription()
        playUntil3Wins()
      catch
        case e: EndGameException => println("\nQuitting the game.")

      println("\nThat's all. Goodbye!")
      println("-" * 30)
      println()
