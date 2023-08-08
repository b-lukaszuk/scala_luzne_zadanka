import scala.annotation.tailrec

@tailrec
def isPrime(num:Int, div:Int=2): Boolean =
  require(num > 1, "Number must be greater than 1.")
  if (div > math.sqrt(num)) then
    true
  else if (num % div == 0) then
    false
  else
    isPrime(num, div+1)

@tailrec
def getFactors(num:Int, div:Int, acc:List[Int] = Nil): List[Int] =
  require(num > 0, "Number must be greater than 0.")
  if (div == 1) then
    acc // except of 1, because it doesn't go to isPrime
  else
    if (num % div == 0) then
      getFactors(num, div-1, div::acc)
    else
      getFactors(num, div-1, acc)

@tailrec
def myFilter(pred: (x: Int) => Boolean,
  l:List[Int], acc:List[Int]=Nil): List[Int] =
  if l.isEmpty then
    acc.reverse
  else
    if pred(l.head) then
      myFilter(pred, l.tail, l.head::acc)
    else
      myFilter(pred, l.tail, acc)

def getPrimeFactors(num:Int): List[Int] =
  myFilter((x) => isPrime(x), getFactors(num, num))

@main def task5: Unit =
  println()
  println("-" * 30)
  println("Recursive functions printing prime factors of a number. Examples.\n")

  val rand:scala.util.Random = new scala.util.Random
  val nums: IndexedSeq[Int] = (for (_ <- 1 to 5)
    yield rand.between(2, 100)).sorted

  nums.foreach((n) => 
    print("Prime factors for: ") 
    println(s"$n => ${getPrimeFactors(n).mkString("[", ", ", "]")}")
    )

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
