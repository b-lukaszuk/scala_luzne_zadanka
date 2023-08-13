---
# Table of contents

1. [Task 1](#task-1)
2. [Task 2](#task-2)
3. [Task 3](#task-3)
4. [Task 4](#task-4)
5. [Task 5](#task-5)
6. [Task 6](#task-6)
7. [Task 7](#task-7)
8. [Task 8](#task-8)
---

# Task 1

Exercise 1 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write functions that will find either the minimum or the maximum value from numbers input by the user until the user types in “quit”.

# Task 2

Exercise 3 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write exponentiation using multiplication. Your function only has to work for positive integer values.

# Task 3

Exercise 7 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write recursive functions that will print a multiplication table up to 10s. Try to get it running first, then consider how you could make everything line up.

# Task 4

Exercise 9 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a recursive function called `isPrime` that returns a `Boolean` and lets you know whether or not a number is prime.

# Task 5

Exercise 10 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a recursive function that prints the prime factors of a number.

### My Notes

The factor of a number is a number that divides the given number completely without any remainder.

# Task 6

Exercise 11 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a recursive function that lets a user play rock, paper, scissors until either the user or the computer wins 3 times. Hint: use `util.random.nextint`.

# Task 7

Exercise 13 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Suppose that tuition at a university costs $30,000 per year and increases 5% per year. Write a recursive function that computes the total cost of tuition a student would pay for a 4-year degree if they started 10 years from now.

# Task 8

Exercise 15 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

An efficient method of finding the greatest common divisor, gcd, of two integers is Euclid’s algorithm. This is a recursive algorithm that can be expressed in mathematical notation in the following way.

$gcd(a, b) = \begin{cases} a & b = 0 \\ gcd(b, a\ mod\ b) & otherwise \end{cases}$

Convert this to Scala code.

# Task 9

Exercise 16 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Certain problems can use a bit more information than just the gcd provided by Euclid’s algorithm shown in exercise 15. In particular, it is often helpful to have the smallest magnitude values of x and y that satisfy the equation `gcd = xa + by`. This information can be found efficiently using the extended Euclid’s algorithm. This is the math notation for that function.

$eEuclid(a, b) = \begin{cases} (a, 1, 0) & b = 0 \\ (d, x, y) = eEuclid(b, a\ mod\ b) (d, y, x - \lfloor{a / b}\rfloor * y) & otherwise \end{cases}$

Convert this to Scala. Note that the $\lfloor{a/b}\rfloor$ operation is naturally achieved by the truncation of integer division for positive a and b.
