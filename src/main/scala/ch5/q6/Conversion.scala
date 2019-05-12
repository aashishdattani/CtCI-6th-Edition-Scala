package ch5.q6

import scala.annotation.tailrec

object Conversion {

  def convert(A: Int, B: Int): Int = {
    @tailrec
    def helper(x: Int, count: Int): Int = x match {
      case 0 => count
      case _ => helper( x >> 1, count + (x & 1))
    }
    helper(A ^ B, 0)
  }

}
