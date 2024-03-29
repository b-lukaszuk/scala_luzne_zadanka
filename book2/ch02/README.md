---

# Table of contents

1. [Task 1](#task-1)
2. [Task 2](#task-2)
3. [Task 3](#task-3)
4. [Task 4](#task-4)
5. [Task 5](#task-5)
6. [Task 6](#task-6)

---

# Task 1

Exercise 1 (optional) in the chapter 2 of the book.

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

Implement `isSorted`, which checks whether an `Array[A]` is sorted according to a given comparison function.

<pre>
def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean
</pre>

# Task 3

Exercise 3 (hard) in the chapter 2 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement `partial1` and write down a concrete usage of it. There is only one possible implementation that compiles. 

This function, `partial1`, takes a value and a function of two arguments, and returns a function of one argument as its result. 

<pre>
def partial1[A,B,C](a: A, f: (A,B) => C): B => C
</pre>

# Task 4

Exercise 4 (hard) in the chapter 2 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Let's look at another example, currying, which converts a function of N arguments into a function of one argument that returns another function as its result. Here again, there is only one implementation that typechecks.

<pre>
def curry[A,B,C](f: (A, B) => C): A => (B => C)
</pre>

# Task 5

Exercise 5 (optional) in the chapter 2 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement `uncurry`, which reverses the transformation of curry. Note that since => associates to the right, `A => (B => C)` can be written as `A => B => C`.

<pre>
def uncurry[A,B,C](f: A => B => C): (A, B) => C
</pre>

# Task 6

Exercise 6 in the chapter 2 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement the higher-order function that composes two functions.

<pre>
def compose[A,B,C](f: B => C, g: A => B): A => C
</pre>
