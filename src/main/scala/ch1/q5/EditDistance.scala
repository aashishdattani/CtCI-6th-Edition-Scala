package ch1.q5

import scala.annotation.tailrec

object EditDistance {
  @tailrec
  def isEdit(s1: String, s2: String): Boolean = (s1, s2) match {
    case (x, y) if x == y => true
    case (x, y) if x.headOption == y.headOption => isEdit(x.tail, y.tail)
    case (x, y) if x.length == y.length => x.tail == y.tail
    case (x, y) if x.length < y.length => x == y.tail
    case (x, y) if x.length > y.length => x.tail == y
    case _ => false
  }
}
