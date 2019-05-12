package ch5.q2

import scala.annotation.tailrec

object Conversion {

  def convert(x: Double): String = {
    @tailrec
    def helper(num: Double, sb: StringBuilder): StringBuilder = {
      val r = num * 2
      if (num == 0 || sb.size >= 32)
        sb
      else if(r >= 1) {
        sb.append("1")
        helper(r - 1, sb)
      }
      else {
        sb.append("0")
        helper(r, sb)
      }
    }

    helper(x, StringBuilder.newBuilder.append("0.")).toString
  }

}
