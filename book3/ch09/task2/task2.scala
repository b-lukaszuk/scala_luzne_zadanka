import java.io.{File, PrintWriter}
import scala.io.Source

def writeStrToFile(filePath:String, contents:String):Unit =
  val pw:PrintWriter = new PrintWriter(new File(filePath))
  println(s"Writing text to file ${filePath}")
  pw.write(contents)
  pw.close()

def get2Powers(toIncl:Int = 20):Array[Double] =
  (for (i <- 0 to toIncl)
    yield scala.math.pow(2, i)).toArray

def getPow2AndReciprocal(pow2:Double): String =
  pow2.toString.padTo(10, ' ') + "\t" + "%.8f".format(1/pow2)

@main def task2: Unit =
  println()
  println("-" * 30)

  val outputFile: String = "./powsOf2AndReciprocals.txt"
  println("Writing powers of 2 and their reciprocals to a file.")
  writeStrToFile(outputFile, get2Powers(20).map(getPow2AndReciprocal)mkString("\n"))
  println("That's all. Goodbye!")

  println("-" * 30)
  println()
