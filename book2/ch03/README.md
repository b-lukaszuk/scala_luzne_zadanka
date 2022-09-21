---

# Table of contents

0. [Background Info](#background-info)
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
11. [Task 11](#task-11)
12. [Tasks 12 to 17](#tasks-12-to-17)
13. [Task 18](#task-18)
14. [Task 19](#task-19)
15. [Tasks 20 to 22](#tasks-20-to-22)
16. [Task 23 to 24](#tasks-23-to-24)
17. [Task 25](#task-25)
18. [Task 26](#task-26)
19. [Task 27](#task-27)
20. [Task 28](#task-28)
21. [Task 29](#task-29)

---

# Background Info

[Go to: Table of contents](#table-of-contents)

The exercises (Task 1-23) are to be solved based on a program in Listing 3.1.
The exercises (Task 25-29) are to be solved based on a program in the catalog ./tree

# Task 1

Exercise 1 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

What will the result of the following match expression be?

<pre>
  val x = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _)))          => x
    case Nil                                   => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t)                            => h + sum(t)
    case _                                     => 101
  }
</pre>

## My answer

The result is 1 + 2, so x is equal 3.

# Task 2

Exercise 2 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement the function `tail` for "removing" the first element of a `List`. [...]. What are different choices you could make in your implementation if the `List` is `Nil`?

# Task 3

Exercise 3 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Generalize `tail` to the function `drop`, which removes the first `n` elements from a list.

<pre>
def drop[A](l: List[A], n: Int): List[A]
</pre>

# Task 4

Exercise 4 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement `dropWhile`, which removes elements from the `List` prefix as long as they match a predicate.

<pre>
def dropWhile[A](l: List[A])(f: A => Boolean): List[A]
</pre>

# Task 5

Exercise 5 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Using the same idea, implement the function setHead for replacing the first element of a List with a different value.

# Task 6

Exercise 6 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Not everything works out so nicely. Implement a function, `init`, which returns a `List` consisting of all but the last element of a `List`. So, given `List(1,2,3,4)`, `init` will return `List(1,2,3)`. Why can't this function be implemented in constant time like `tail`?

<pre>
def init[A](l: List[A]): List[A]
</pre>

# Task 7

Exercise 7 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

Skipped (but I think its not possible, at least I don't know how to early stop foldRight)

# Task 8

Exercise 8 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

Skipped (but I checked)

# Task 9

Exercise 9 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Compute the `length` of a list using `foldRight`.

<pre>
def length[A](l: List[A]): Int
</pre>

# Task 10

Exercise 10 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

[...] then write another general list-recursion function, `foldLeft` that is tail-recursive, using the techniques we discussed in the previous chapter.

<pre>
def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B
</pre>

# Task 11

Exercise 11 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write `sum`, `product`, and a function to compute the `length` of a list using `foldLeft`.

# Tasks 12 to 17

Exercise 12 to 17 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

Skipped (enough of folds)

# Task 18

Exercise 18 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a function `map`, that generalizes modifying each element in a list while maintaining the structure of the list.

<pre>
def map[A,B](l: List[A])(f: A => B): List[B]
</pre>

# Task 19

Exercise 19 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a function `filter` that removes elements from a list unless they satisfy a given predicate. Use it to remote all odd numbers from a `List[Int]`.

# Tasks 20 to 22

Exercise 20 to 22 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

Skipped.

# Task 23

Exercise 23 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Generalize a function from Task 22, i.e.

Write a function that accepts two lists and constructs a new list by adding corresponding elements. For example, `List(1,2,3)` and `List(4,5,6)` becomes `List(5,7,9)`.

# Tasks 24 to 25

Exercise 24 and 25 in the chapter 3 of the book were skipped.

[Go to: Table of contents](#table-of-contents)

# Task 26

Exercise 26 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a function `maximum ` that returns the maximum element in a `Tree[Int]`.

# Task 27

Exercise 27 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a function `depth` that returns the maximum path length from the root of a tree to any leaf.

# Task 28

Exercise 28 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a function `map`, analogous to the method of the same name on `List`, that modifies each element in a tree with a given function.

# Task 29

Exercise 29 in the chapter 3 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Generalize `size`, `maximum`, `depth`, and `map`, writing a new function fold that abstracts over their similarities.
