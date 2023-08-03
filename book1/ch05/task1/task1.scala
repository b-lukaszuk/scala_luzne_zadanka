import scala.io.StdIn.{readDouble, readLine}

def getNumFromUser(
  promptMsg:String =
    "\nEnter a number (. - decimal separator) and press Enter:\n"):Double =
  try
    print(promptMsg)
    readDouble()
  catch
    case e:NumberFormatException =>
        println("That was not a number, try again")
        getNumFromUser()

def askUserToQuit(
  promptMsg:String =
    "What you want to do?\n" +
      "type (and press Enter)\n" +
      "\tq (quit)\n\tanything else - another input\n"):Boolean =
  readLine(promptMsg).strip() == "q"

def getMinMax(nums:List[Double]): (Double, Double) =
  (nums.min, nums.max)

def runMainLoop(): Unit =
  var shouldQuitProgram: Boolean = false
  var nums:List[Double] = Nil

  while !shouldQuitProgram do
    nums ::= getNumFromUser()
    shouldQuitProgram = askUserToQuit()

  println("\nYou entered the following numbers:")
  println(s"${nums.reverse}")
  println(s"(Min, Max) = ${getMinMax(nums)}")

@main def task1(): Unit =
  println()
  println("-" * 30)

  runMainLoop()

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
