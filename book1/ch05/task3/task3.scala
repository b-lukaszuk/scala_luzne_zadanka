import scala.annotation.tailrec

@tailrec
def getNumMultiples(num:Int, by:Int=10, acc:List[Int]=Nil):List[Int] =
  if by <= 0 then
    acc
  else
    getNumMultiples(num, by-1, (num*by) :: acc)

@tailrec
def getMultTable(upto:Int = 10, acc:List[List[Int]] = Nil):List[List[Int]] =
  if upto <= 0 then
    acc
  else
    getMultTable(upto-1, getNumMultiples(upto) :: acc)

def printRow(row:List[Int]): Unit =
  if row.isEmpty then
    println()
  else
    print("% 5d ".format(row.head))
    printRow(row.tail)

def printHeader(firstRow:List[Int]): Unit =
     print(" " * 5)
     printRow(firstRow)
     print(" " * 5)
     println("_" * 60)
     println(" " * 65)

def printTable(multTab:List[List[Int]], header:Boolean): Unit =
  if multTab.isEmpty then
    print("")
  else
    if header then printHeader(multTab.head)
    print("% 3d |".format(multTab.head.head)) // print row names
    printRow(multTab.head)
    printTable(multTab.tail, false)

@main def task3(): Unit =
  println()
  println("-" * 30)
  println("Recursive functions printing multiplication table. Example.\n")

  printTable(getMultTable(10), true)

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
