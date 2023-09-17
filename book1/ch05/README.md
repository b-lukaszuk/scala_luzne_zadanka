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
9. [Task 9](#task-9)
10. [Task 10](#task-10)
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

# Task 10

Project 4 in the chapter 5 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

[...] the rabbit and fox scenario. The idea is that each summer you count the population of rabbits and foxes in a certain region. This region is fairly well isolated so you do not have animals coming in or leaving. In addition, the climate is extremely temperate, and there is always enough grass so environmental factors do not seem to impact the populations. [...]

Over the course of each year, the rabbit population will be impacted in the following ways. Some rabbits will be born, some rabbits will die of natural causes, and some rabbits will be eaten. Similarly some foxes will be born and some will die. The number of rabbits eaten depends upon the population of foxes (more foxes eat more rabbits), and the number of foxes who are born and die depends on the number of rabbits because foxes cannot live long or have young without finding rabbits to eat. We can combine these things to come up with some equations that predict the numbers of foxes and rabbits in a given year based on the number in the previous year.

Formula for rabbits:

$R_{n+1} = R_{n} + A * R_{n} - B * R_{n} * F_{n}$

Formula for foxes:

$F_{n+1} = F_{n} - C * F_{n} + D * R_{n} * F{n}$

Abbreviations:

- A - normal increase in the rabbit population without predation
- B - predation rate (it is multiplied by then rabbit/fox population, because if either is small ,the predation is small)
- C - the rate of foxes dying without having children if they do not have food (rabbits)
- D - the rate at which foxes have children when they have food (rabbits)

[...] The four constants should have positive values. [..]  In reality, foxes and rabbits only come in whole numbers, but for numeric reasons, you should use `Doubles` in your program.

The input for your program is the initial rabbit population, R0, the initial fox population F0 , and the four constants. To start you off, you might try values of 100, 10, 0.01, 0.001, 0.05, and 0.001. The last four numbers are A, B, C, and D, respectively. You can play with these values to try to find some that produce interesting results. Print out the first 1000 iterations.

[...] output only numbers. [...]  If you print 3 numbers per line, “n R F ”, and put it in a file called “pop.txt” then you can plot that in gnuplot with a command like “plot ’pop.txt’ using ($1):($2), ’pop.txt’ using ($1):($3)”.

## My notes

To run the task type

```bash
scala3 ./task10/task10.scala 100 10 0.01 0.001 0.05 0.001 > pop.txt
```

To run the example presented above type:

```bash
gnuplot # in terminal
# once the program runs after the prompt (gnuplot>) type
gnuplot> plot 'pop.txt' using($1):($2), 'pop.txt' using ($1):($3)
```
