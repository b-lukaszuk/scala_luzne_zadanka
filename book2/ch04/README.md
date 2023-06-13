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

## My notes

Population variance is `sum / n`, sample variance is `sum / (n - 1)`.
Here, I will go with the first option like in the task description (as suggested in the book).

# Task 3

Exercise 3 in the chapter 4 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

`bothMatch` is an instance of a more general pattern. Write a generic function `map2`, that combines two `Option` values using a binary function. If either `Option` value is `None`, then the return value is too. Here is its signature:

<pre>
def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C]
</pre>

# Task 4

Exercise 4 in the chapter 4 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Re-implement `bothMatch` above in terms of this new function, to the extent possible.

Previous version of `bothMatch`:

<pre>
import java.util.regex._

def pattern(s: String): Option[Pattern] =
	try {
	Some(Pattern.compile(s))
	} catch {
	case e: PatternSyntaxException => None
}

def mkMatcher(pat: String): Option[String => Boolean] =
	pattern(pat) map (p => (s: String) => p.matcher(s).find)

def bothMatch(pat: String, pat2: String, s: String): Option[Boolean] =
	for {
		f <- mkMatcher(pat)
		g <- mkMatcher(pat2)
	} yield f(s) && g(s)
</pre>

Function signature of `bothMatch2`

<pre>
def bothMatch_2(pat1: String, pat2: String, s: String): Option[Boolean]
</pre>

## My Notes

I will assume that "[...] in terms of this new function, [...]" means `map2` from Exercise 3 (Task3)

# Task 5

Exercise 5 in the chapter 4 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Write a function `sequence`, that combines a list of `Option`s into one option containing a list of all the `Some` values in the original list. If the original list contains `None` even once, the result of the function should be `None`, otherwise the result should be `Some` with a list of all the values.

Signature:

<pre>
def sequence[A](a: List[Option[A]]): Option[List[A]]
</pre>

# Task 6

Exercise 6 in the chapter 4 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Implement this (`traverse`) function. It is straightforward to do using `map` and `sequence`, but try for a more efficient implementation that only looks at the list once. In fact, implement `sequence` in terms of `traverse`.

Signature:

<pre>
def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]]
</pre>

# Task 7

Exercise 7 in the chapter 4 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Definition/signature of `Either`

<pre>
sealed trait Either[+E, +A]
case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]
</pre>

Implement versions of `map`, `flatMap`, `orElse`, and `map2` on `Either` that operate on the `Right` value.

<pre>
trait Either[+E, +A] {
	def map[B](f: A => B): Either[E, B]
	def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B]
	def orElse[EE >: E,B >: A](b: => Either[EE, B]): Either[EE, B]
	def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C]
}
</pre>

# Task 8

Exercise 8 in the chapter 4 of the book.

[Go to: Table of contents](#table-of-contents)

## Description

Definition/signature of `Either`

<pre>
sealed trait Either[+E, +A]
case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]
</pre>

Implement `sequence` and `traverse` for `Either`.

Reminder of `sequence` from `ch04/Task5.scala`

<pre>
def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
  case head :: tail =>
    head.flatMap((elt: A) =>
      sequence(tail).map((aList: List[A]) => elt :: aList)
    )
  case Nil => Some(Nil)
}
</pre>

Reminder of `traverse` function from `ch04/Task6.scala`

<pre>
def combine[B](b: Option[B], acc: Option[List[B]]): Option[List[B]] =
  (b, acc) match {
    case (None, _)              => None
    case (_, None)              => None
    case (Some(b1), Some(acc1)) => Some(b1 :: acc1)
  }

def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
  case head :: tail => combine(f(head), traverse(tail)(f))
  case Nil          => Some(Nil)
}
</pre>
