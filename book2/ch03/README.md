---

# Table of contents

0. [Background Info](#background-info)
1. [Task 1](#task-1)
2. [Task 2](#task-2)
3. [Task 3](#task-3)
4. [Task 4](#task-4)
5. [Task 5](#task-5)
6. [Task 6](#task-6)

---

# Background Info

[Go to: Table of contents](#table-of-contents)

The exercises are to be solved based on a program in Listing 3.1.

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