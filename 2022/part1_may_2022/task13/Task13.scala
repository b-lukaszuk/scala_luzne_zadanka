object Task13 {
  def main(args: Array[String]): Unit = {

    def pigLatWord(word: String): String = {
      word.substring(1) + word(0) + "ay"
    }

    def dePigLatWord(word: String): String = {
      var core: String = word.substring(0, word.length - 2)
      core(core.length - 1) + core.substring(0, core.length - 1)
    }

    // only simple sentences, no commas, dots, colons, etc.
    def convertSentence(
        sentence: String,
        wordConverter: (String) => String
    ): String = {
      sentence.split(" ").map(wordConverter).mkString(" ")
    }

    val test1: String = "the quick brown fox"
    val test2: String = "hetay uickqay rownbay oxfay"

    println("-" * 30)
    println("Task 13\n")
    println("Pig latinizing phrase:")
    println(test1)
    println("result:")
    println(convertSentence(test1, pigLatWord))
    println("\nDePig latinizing phrase:")
    println(test2)
    println("result:")
    println(convertSentence(test2, dePigLatWord))
    println("\nThat's all. Goodbye.")
    println("-" * 30)
  }
}
