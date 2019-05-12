package ch5.q3

import scala.math.max

object FlipBit {

  def longestSequence(input: Int): Int = {

    def helper(x: Int, flipped: Boolean, len: Int, maxLen: Int): Int =
      (x, x & 1) match {
        case (0, _) => maxLen
        case (_, 1) => helper(x >> 1, flipped, len + 1, maxLen)
        case (_, 0) =>
          if(flipped)
            helper(x >> 1, false, 0, max(len, maxLen))
          else
            max(
              helper(x >> 1, false, 0, max(len, maxLen)),
              helper(x >> 1, true, len + 1, maxLen)
            )
      }

    helper(input, false, 0, 0)
  }

}
