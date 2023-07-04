import java.io.{File, PrintWriter}
import scala.io.Source

def getFileContents(filePath:String):Array[String] =
  println(s"Reading text from file ${filePath}.")
  Source.fromFile(filePath, "UTF-8").getLines.toArray

def writeArrToFile(filePath:String, contents:Array[String]):Unit =
  println(s"Writing text to file ${filePath}")
  val pw:PrintWriter = new PrintWriter(new File(filePath))
  pw.write(contents.mkString("\n"))
  pw.close()

@main def task1: Unit =
  println()
  println("-" * 30)

  val inputFile: String = "./example123456789.txt"
  val outputFile: String = "./example987654321.txt"
  val lines:Array[String] = getFileContents(inputFile)
  println("Reversing lines. Writing text to another file.")
  writeArrToFile(outputFile, lines.reverse)

  println("-" * 30)
  println()
