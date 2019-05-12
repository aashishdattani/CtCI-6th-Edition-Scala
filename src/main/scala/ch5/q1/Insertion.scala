package ch5.q1

import scala.math.pow

object Insertion {

  def insert(N: Int, M: Int, start: Int, end: Int): Int = {
    val numBits = end - start + 1
    val mask = ~((pow(2, numBits).toInt - 1) << start)
    (N & mask) | (M << start)
  }

}
