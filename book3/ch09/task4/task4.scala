import java.nio.file.{Files, Path, Paths}
import java.util.stream.Stream

@main def task4: Unit =
  println()
  println("-" * 30)

  val startDir: String = "./"
  val fileEnding: String = ".txt"
  val entries: Stream[Path] = Files.walk(Paths.get(startDir))

  println(s"Listing files ending with $fileEnding in this directory and its subdirectories")
  try
    entries.forEach(e =>
      if Files.isRegularFile(e) && e.toString().endsWith(fileEnding) then
        println(e)
    )
  finally
    entries.close()

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
