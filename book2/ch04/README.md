---

# Table of contents

0. [Background Info](#background-info)

---

# Background Info

[Go to: Table of contents](#table-of-contents)

## The Option data type

<pre>
sealed trait Option[+A]
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
</pre>
