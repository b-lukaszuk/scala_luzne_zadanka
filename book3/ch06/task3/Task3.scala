object CardSuit extends Enumeration:
  type CardSuit = Value
  val Clubs = Value("\u2663")
  val Diamonds = Value("\u2666")
  val Hearts = Value("\u2665")
  val Spades = Value("\u2660")

object Task3:
  def main(args: Array[String]): Unit =
    println("-" * 30)
    println("Task3. CardSuits.\n")
    for (cs <- CardSuit.values) { println(cs) }
    println("\nThat's all. Goodbye!")
    println("-" * 30)
