object Task2_4 {
  def main(args: Array[String]) = {

    val words: Array[String] =
      Array(
        "Karol",
        "Adam",
        "Rogowski",
        "Politechnika",
        "Super",
        "Weekend",
        "Politechniki"
      )

    def getLongestWords(wrds: Array[String]): Array[String] = {
      var result: Array[String] = Array(wrds.head)
      wrds.tail.foreach { w =>
        if (w.length > result(0).length) {
          result = Array(w)
        } else if (w.length == result(0).length) {
          result :+= w
        }
      }
      result
    }

    println("-" * 50)
    println("Task 2.4")
    println("Given the words:")
    words.foreach { w => print(w + " ") }
    println("\nThe longest word(s) is/are:")
    getLongestWords(words).foreach(println)
    println("That's it goodbye!")
    println("-" * 50)
  }
}
