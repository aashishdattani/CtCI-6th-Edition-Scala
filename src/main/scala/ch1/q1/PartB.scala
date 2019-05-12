package ch1.q1

import scala.annotation.tailrec

object PartB {
  def hasUnique(input: String): Boolean = {
    @tailrec
    def helper(str: String, prev: Char): Boolean = {
      if(str.isEmpty)
        true
      else if(str.head == prev)
        false
      else
        helper(str.tail, str.head)
    }

    helper(input.sorted, 0)
  }
}
