import scala.collection.mutable.HashMap

object Task1 {
  def main(args: Array[String]): Unit = {

    var engToMorse: HashMap[Char, String] = HashMap(
      'A' -> ".-",
      'C' -> "-.-.",
      'E' -> ".",
      'G' -> "--.",
      'I' -> "..",
      'K' -> "-.-",
      'M' -> "--",
      'O' -> "---",
      'Q' -> "--.-",
      'S' -> "...",
      'U' -> "..-",
      'W' -> ".--",
      'Y' -> "-.--",
      '0' -> "-----",
      '2' -> "..---",
      '4' -> "....-",
      '6' -> "-....",
      '8' -> "---..",
      '.' -> ".-.-.-",
      'B' -> "-...",
      'D' -> "-..",
      'F' -> "..-.",
      'H' -> "....",
      'J' -> ".---",
      'L' -> ".-..",
      'N' -> "-.",
      'P' -> ".--.",
      'R' -> ".-.",
      'T' -> "-",
      'V' -> "...-",
      'X' -> "-..-",
      'Z' -> "--..",
      '1' -> ".----",
      '3' -> "...--",
      '5' -> ".....",
      '7' -> "--...",
      '9' -> "----.",
      ' ' -> "\t"
    )

    def getMorseFromEng(msgEng: String): String = {
      msgEng.toUpperCase
        .map((engLett) => engToMorse.getOrElse(engLett, "?"))
        .mkString(" ");
    }

    println("-" * 50)
    println("'Ala ma kota' in Morse code is:");
    println(getMorseFromEng("Ala ma kota"));
    println("-" * 50)
  }
}
