---

# Table of contents

1. [Task 1](#task-1)

---

# Task 1

Exercise 3 in the chapter 6 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a package `random` with functions `nextInt(): Int`, `nextDouble(): Double`, and `setSeed(seed: Int): Unit`. To generate random numbers, use the linear congruential generator.

$next = (previous * a + b)\ mod\ 2^n$

where a = 1664525, b = 1013904223, n = 32, and the initial value of `previous` is `seed`.
