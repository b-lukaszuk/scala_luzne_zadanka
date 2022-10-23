---

# Table of contents

0. [Background Info](#background-info)
1. [Task 1](#task-1)
2. [Task 2](#task-2)

---

# Background Info

[Go to: Table of contents](#table-of-contents)

## The Option data type

<pre>
sealed trait Option[+A]
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
</pre>

# Task 1

Exercise 1 in the chapter 4 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

<pre>
trait Option[+A] {
def map[B](f: A => B): Option[B]
def flatMap[B](f: A => Option[B]): Option[B]
def getOrElse[B >: A](default: => B): B
def orElse[B >: A](ob: => Option[B]): Option[B]
def filter(f: A => Boolean): Option[A]
}
</pre>

[...] implement all of the above functions on `Option`. As you implement each function, try to think about what it means and in what situations you'd use it. Here are a few hints:

- It is fine to use pattern matching, though you should be able to implement all the functions besides `map` and `getOrElse` without resorting to pattern matching.
- For `map` and `flatMap`, the type signature should be sufficient to determine the implementation.
- `getOrElse` returns the result inside the `Some` case of the `Option`, or if the `Option` is `None`, returns the given default value.
- `orElse` returns the first `Option` if it is defined, otherwise, returns the second `Option`.

# My Notes

Not sure where I should create, e.g. `map` method. Not sure how to do this inside `sealed trait Option` so I will create a companion object (i.e. `object Option`) and place the required methods there. But I'm affraid that the methods' signatures will slightly differ from the ones presented above.

# Task 2

Exercise 2 in the chapter 4 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement the `variance` function [...] in terms of `mean` and `flatMap`.

The `mean` function:

<pre>
def mean(xs: Seq[Double]): Option[Double] =
	if (xs.isEmpty) None
	else Some(xs.sum / xs.length)
</pre>

The `variance` signature:

<pre>
def variance(xs: Seq[Double]): Option[Double]
</pre>
