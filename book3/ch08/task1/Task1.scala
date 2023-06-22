object Task1:

  class BankAccount(initialBalance: Double):
    protected var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) =  balance += amount; balance
    def withdraw(amount: Double) =  balance -= amount; balance

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance):
    override def deposit(amount: Double) = balance += amount - 1; balance
    override def withdraw(amount: Double) = balance -= amount + 1; balance

  def main(args: Array[String]) =
    val ca: CheckingAccount = new CheckingAccount(300)
    println("-" * 30)
    println("Extending BankAccount class examples.")
    println(s"Checking account initial balance = ${ca.currentBalance} usd")
    ca.deposit(100)
    println(s"Balance after making a deposit of 100 usd = ${ca.currentBalance} usd")
    ca.withdraw(200)
    println(s"Balance after making a withdraw of 200 usd = ${ca.currentBalance} usd")
    println("That's all. Goodbye.")
    println("-" * 30)
