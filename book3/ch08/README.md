---

# Table of contents

1. [Task 1](#task-1)
2. [Task 2](#task-2)

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

# Task 2

Exercise 7 in the chapter 8 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Provide a class `Square` that extends `java.awt.Rectangle` and has three constructors: one that constructs a square with a given corner point and width, one that constructs a square with corner (0, 0) and a given width, and one that constructs a square with corner (0, 0) and width 0.
