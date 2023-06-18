object CardSuit extends Enumeration:
  type CardSuit = Value
  val Clubs = Value("\u2663")
  val Diamonds = Value("\u2666")
  val Hearts = Value("\u2665")
  val Spades = Value("\u2660")

object Task4:
  def isSuitRed(suit: CardSuit.Value): Boolean = suit match
    case CardSuit.Diamonds => true
    case CardSuit.Hearts   => true
    case _                 => false

  def main(args: Array[String]): Unit =
    println("-" * 30)
    println("Task4. CardSuits.\n")
    for (cs <- CardSuit.values)
      println(s"${cs} - is card suit red? ${isSuitRed(cs)}")
    println("\nThat's all. Goodbye!")
    println("-" * 30)
