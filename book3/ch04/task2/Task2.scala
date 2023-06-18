import java.util.Scanner
import scala.collection.immutable.{HashMap}
import scala.collection.mutable.{ArrayBuffer}

object Task2:
  def getWordsFromFile(filePath: String): ArrayBuffer[String] =
    val words: ArrayBuffer[String] = new ArrayBuffer(0)
    val in: Scanner = new Scanner(
      new java.io.File("../exemplary_text/genesis.txt")
    )
    while (in.hasNext())
      words.append(in.next().strip().toLowerCase().replaceAll("[.,;:!?]", ""))
    in.close()
    words

  def getWordsCounts(words: ArrayBuffer[String]): HashMap[String, Int] =
    var wordsCounts: HashMap[String, Int] = HashMap()
    for (word <- words)
      if (wordsCounts.contains(word))
        wordsCounts =
          wordsCounts.updated(word, wordsCounts.getOrElse(word, 0) + 1)
      else
        wordsCounts = wordsCounts + (word -> 1)
    wordsCounts

  def main(args: Array[String]): Unit =
    println("-" * 30)
    println("Task2.\n")
    val filePath: String = "./genesis.txt"
    println(s"Reading text from '${filePath}'")
    val words: ArrayBuffer[String] = getWordsFromFile(filePath)
    println("Calculating words frequencies.")
    val wordsCounts: HashMap[String, Int] = getWordsCounts(words)
    println("\nResult:")
    println(wordsCounts.mkString("\n"))
    println("\nThat's all. Goodbye!")
    println("-" * 30)
