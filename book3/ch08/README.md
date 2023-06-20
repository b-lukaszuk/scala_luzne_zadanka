---

# Table of contents

1. [Task 1](#task-1)

---

# Task 1

Exercise 1 in the chapter 8 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Extend the following BankAccount class to a CheckingAccount class that charges $1 for every deposit and withdrawal.

<pre>
class BankAccount(initialBalance: Double) {
	private var balance = initialBalance
	def currentBalance = balance
	def deposit(amount: Double) = { balance += amount; balance }
	def withdraw(amount: Double) = { balance -= amount; balance }
}
</pre>
