import scala.io.Source

object Task1 {
  def main(args: Array[String]): Unit = {

    val filename: String = "./listOfWords/unixdict.txt";
    val bufferedSource = Source.fromFile(filename)

    val possibleAnagrams =
      bufferedSource.getLines.toList.groupBy((word) => word.sorted)

    bufferedSource.close

    println("-" * 30);
    println("Task 1.");
    println(s"Analysing ${filename} for anagrams");
    println("Result");
    println("(for 4 and more anagrams in dictionary, empty if none):\n")
    for ((k, v) <- possibleAnagrams) {
      if (v.length > 3) {
        println(s"${v.mkString(", ")}")
      }
    }
    println("\nThat's all. Goodbye!")
    println("-" * 30);
  }

}
