import java.nio.file.{Files, Path, Paths}
import java.io.File

@main def task4: Unit =
  println()
  println("-" * 30)

  val startDir: String = "./"
  val fileEnding: String = ".txt"
  val entries = Files.walk(Paths.get(startDir))

  println(s"Listing files ending with $fileEnding in this directory and its subdirectories")
  try
    entries.forEach(p =>
      if Files.isRegularFile(p) && p.toString().endsWith(fileEnding) then
        println(p)
    )
  finally
    entries.close()

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
