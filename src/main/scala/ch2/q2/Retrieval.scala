package ch2.q2

import scala.annotation.tailrec

object Retrieval {

  def fromLast[T](input: List[T], k: Int): T = {
    @tailrec
    def getListFrom(l: List[T], pos: Int): List[T] = pos match {
      case 1 => l
      case _ => getListFrom(l.tail, pos - 1)
    }

    @tailrec
    def getElementFromLast(l1: List[T], l2: List[T]): T = l2.tail match {
      case Nil => l1.head
      case _ => getElementFromLast(l1.tail, l2.tail)
    }

    assert(k > 0)
    assert(k <= input.length)
    getElementFromLast(input, getListFrom(input, k))
  }

}
