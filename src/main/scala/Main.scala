object Main extends App {
  val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  // P1
  println("P1: "+l.last)

  // P2
  def penultimate[A](l: List[A]): Any = {
    l match {
      case e :: _ :: Nil => e
      case _ :: tail => penultimate(tail)
    }
  }
  println("P2: "+penultimate(l))

  // P3
  def nth[A](n: Int, l: List[A]): Any = {
    l(n-1)
  }
  println("P3 (n=5): "+nth(5, l))

  // P4
  println("P4: "+l.size)

  // P5
  println("P5: "+l.reverse)

  // P6
  def is_palindrome[A](l: List[A]): Boolean = {
    l.foldLeft(List[A]())((l, r) => r :: l).equals(l)
  }
  println("P6: "+is_palindrome(l))

  // P7
  println("P7 (l,l): "+List(l,l).flatten)

  // P8
  def compress(l: List[Any]): List[Any] = {
    def compress_inner(l: List[Any], last: Any): List[Any] = {
      l match {
        case Nil => Nil
        case first :: rest if first == last => compress_inner(rest, first)
        case first :: rest => first :: compress_inner(rest, first)
      }
    }
    compress_inner(l, Nil)
  }
  
  println("P8: "+compress(l))
  
  // P9
  def pack[A](l: List[A]): List[List[A]] = {
    val (prefix, suffix) = l.span(_ == l.head)
    if (suffix == Nil)
      List(prefix)
    else
      prefix :: pack(suffix)
  }
  println("P9: "+pack(l))

  // P10
  def encode10[A](l: List[A]): List[(Int, A)] = {
    pack(l).map(x => (x.size, x.head))
  }
  println("P10: "+encode10(l))

  // P11
  def encode11[A](l: List[A]): List[Any] = {
    pack(l).map(x => if (x.size == 1) x.head else (x.size, x.head))
  }
  println("P11: "+encode11(l))

  // P12
  def decode(l: List[Any]): List[Any] = {
    encode10(l).map(x => List.fill(x._1)(x._2)).flatten
  }
  println("P12: "+decode(l))

  // P13 skipped

  // P14
  def duplicate[A](l: List[A]): List[A] = {
    l.flatMap(x => List(x, x))
  }
  println("P14: "+duplicate(l))

  // P15
  def duplicate_n[A](l: List[A], n: Int): List[A] = {
    l.flatMap(x => List.fill(n)(x))
  }
  println("P15 (n=3): "+duplicate_n(l, 3))

  // P16
  def drop[A](l: List[A]): List[A] = {
    ???
  }
  println("P: ")

  /*
  // P
  def name[A](l: List[A]): List[A] = {
    ???
  }
  println("P: ")
  */

}