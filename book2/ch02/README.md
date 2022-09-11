---

# Table of contents

1. [Task 1](#task-1)
2. [Task 2](#task-2)
3. [Task 3](#task-3)

---

# Task 1

Exercise 1 in the chapter 2 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a function to get the nth Fibonacci number. The first two Fibonacci numbers are 0 and 1, and the next number is always the sum of the previous two. Your definition should use a local tail-recursive function.

Do not use [closed-form expression](http://en.wikipedia.org/wiki/Fibonacci_number#Closed-form_expression).

<pre>
def fib(n: Int): Int
</pre>

# Task 2

Exercise 2 in the chapter 2 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function.

<pre>
def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean
</pre>

# Task 3

Exercise 3 (hard) in the chapter 2 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement partial1 and write down a concrete usage of it. There is only one possible implementation that compiles. 

This function, partial1, takes a value and a function of two arguments, and returns a function of one argument as its result. 

<pre>
def partial1[A,B,C](a: A, f: (A,B) => C): B => C
</pre>
