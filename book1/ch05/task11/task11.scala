def getPeriodicInterestRate(
  totalInterestRate: Double, numOfPeriods: Int = 12): Double =
  totalInterestRate / numOfPeriods

def getTotalNumOfPeriods(numCycles: Int, periodsPerCycle: Int = 12): Int =
  numCycles * periodsPerCycle

def getMonthlyPayment(
  principal: Double,
  interestRate: Double,
  numYears: Int): Double =
  val r: Double = getPeriodicInterestRate(interestRate)
  val n: Double = getTotalNumOfPeriods(numYears)
  val interestTotalPeriod: Double = scala.math.pow(1 + r, n)
  principal / ((interestTotalPeriod - 1) / (r * interestTotalPeriod))

def getTotalPayment(monthlyPayment: Double, numYears: Int): Double =
  monthlyPayment * getTotalNumOfPeriods(numYears)

def getMonthlyInterestPaid(monthlyInterestRate: Double,
  remainingBalance: Double): Double =
    monthlyInterestRate * remainingBalance

def getMonthlyPrincipalPaid(
  monthlyPayment: Double,
  monthlyInterest: Double): Double =
  monthlyPayment - monthlyInterest

def round(d: Double, digits: Int = 2): Double =
  f"$d%.2f".toDouble

def printAmortizationData(
  paymentNo: Int,
  interestPaid: Double,
  principlePaid: Double,
  remainingBalance: Double
): Unit =
  println(s"$paymentNo\t\t$interestPaid\t\t$principlePaid\t\t$remainingBalance")

def getAmortizationSchedule(
  remainingBalance: Double,
  remainingMonths: Int, paymentNum: Int = 1,
  monthlyPayment: Double, monthlyInterestRate: Double): Unit =
    if(remainingMonths < 1) then
      println("End of payment")
    else
      val mthInterest: Double = round(getMonthlyInterestPaid(
        monthlyInterestRate, remainingBalance))
      val mthPrincipal: Double = round(getMonthlyPrincipalPaid(
        monthlyPayment, mthInterest))
      val remBalance: Double = round(remainingBalance - mthPrincipal)
      printAmortizationData(paymentNum, mthInterest, mthPrincipal, remBalance)
      getAmortizationSchedule(remBalance,
      remainingMonths-1,
      paymentNum + 1,
      monthlyPayment,
      monthlyInterestRate)

@main def task11(): Unit =
  println("-" * 30)
  println("Task 11. Loan calculation example.")
  val initialPrincipal: Double = 30000
  val mthPayment: Double = round(getMonthlyPayment(30000, 0.05, 5))
  println(s"Initial principal = $initialPrincipal")
  println(s"Monthly payment = $mthPayment")
  println("payment no.\tinterest paid\tprinciple paid\tremaining balance")
  getAmortizationSchedule(
    30000, 12*5, 1, mthPayment, getPeriodicInterestRate(0.05))
  println("-" * 30)
