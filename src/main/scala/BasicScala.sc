sealed trait List[+T]

case object Nil extends List[Nothing]

case class Cons[T](head: T, tail: List[T]) extends List[T]

object List {
  def head[T](list: List[T]): T = {
    list match {
      case Nil => throw new RuntimeException("Empty list")
      case Cons(x, xs) => x
    }
  }

  def map[T, U](list: List[T])(f: T => U): List[U] = {
    list match {
      case Nil => Nil
      case Cons(x, xs) => Cons(f(x), map(xs)(f))
    }
  }

  //// Navigate to the rightmost element and start adding from right to left
  def foldRight[T, U](list: List[T])(default: U)(f: (T, U) => U): U = {
    list match {
      case Nil => default
      case Cons(x, xs) => f(x, foldRight(xs)(default)(f))
    }
  }

  //// Start adding from the leftmost element to the rightmost
  def foldLeft[T, U](list: List[T])(acc: U)(f: (U, T) => U): U = {
    list match {
      case Nil => acc
      case Cons(x, xs) => foldLeft(xs)(f(acc, x))(f)
    }
  }
}

List.foldRight(Cons(2, Cons(3, Nil)))(0)((x, y) => x + y)
List.foldLeft(Cons(2, Cons(3, Nil)))(0)((x, y) => x + y)
