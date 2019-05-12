package ch1.q1

import scala.annotation.tailrec

object PartA {

  def hasUnique(input: String): Boolean = {
    @tailrec
    def helper(str: String, charSet: Set[Char]): Boolean = {
      if (str.isEmpty)
        true
      else if(charSet.contains(str.head))
        false
      else
        helper(str.tail, charSet + str.head)
    }

    helper(input, Set[Char]())
  }
}
