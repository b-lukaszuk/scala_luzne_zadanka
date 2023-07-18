import scala.io.{BufferedSource, Source}
import scala.util.matching.Regex

def getFileContents(filePath:String):String =
  val bufferedSource:BufferedSource = Source.fromFile(filePath, "UTF-8")
  try
    bufferedSource.mkString
  finally
    bufferedSource.close()


@main def task3: Unit =
  println()
  println("-" * 30)

  val htmlFilePath: String = "./test.html"

  println(s"Reading exemplary html file -> $htmlFilePath.")
  println("Extracting 'src' attributes of all 'img' tags.")
  println("Printing extracted 'src' attributes.\n")

  val htmlContents:String = getFileContents(htmlFilePath)
  val imgPattern:Regex = """(?<=<img .*)src=\".+?\"""".r
  for
    matchedString <- imgPattern.findAllIn(htmlContents)
  do
    println(matchedString)

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
