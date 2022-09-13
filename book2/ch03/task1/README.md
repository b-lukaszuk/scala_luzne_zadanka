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
