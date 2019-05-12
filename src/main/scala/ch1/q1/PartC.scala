package ch1.q1

import scala.annotation.tailrec

object PartC {

  def hasUnique(input: String): Boolean = {
    @tailrec
    def helper(str: String, current: Int): Boolean = {
      if(str.isEmpty)
        true
      else if((current | (1 << (str.head - 'a'))) == current)
        false
      else
        helper(str.tail, current | (1 << (str.head - 'a')))
    }

    helper(input, 0)
  }

}
