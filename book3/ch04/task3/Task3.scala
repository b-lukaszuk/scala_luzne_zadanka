import java.util.Scanner
import scala.collection.mutable.{ArrayBuffer, SortedMap}

object Task3 {

  def getWordsFromFile(filePath: String): ArrayBuffer[String] = {
    val words: ArrayBuffer[String] = new ArrayBuffer(0)
    val in: Scanner = new Scanner(
      new java.io.File("../exemplary_text/genesis.txt")
    )
    while (in.hasNext()) {
      words.append(in.next().strip().toLowerCase().replaceAll("[.,;:!?]", ""))
    }
    in.close()
    words
  }

  def getWordsCounts(words: ArrayBuffer[String]): SortedMap[String, Int] = {
    val wordsCounts: SortedMap[String, Int] = SortedMap()
    for (word <- words) {
      if (wordsCounts.contains(word)) {
        wordsCounts.update(word, wordsCounts.getOrElse(word, 0) + 1)
      } else {
        wordsCounts += (word -> 1)
      }
    }
    wordsCounts
  }

  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task3.\n")
    val filePath: String = "./genesis.txt"
    println(s"Reading text from '${filePath}'")
    val words: ArrayBuffer[String] = getWordsFromFile(filePath)
    println("Calculating words frequencies.")
    val wordsCounts: SortedMap[String, Int] = getWordsCounts(words)
    println("\nResult:")
    println(wordsCounts.mkString("\n"))
    println("\nThat's all. Goodbye!")
    println("-" * 30)
  }
}
