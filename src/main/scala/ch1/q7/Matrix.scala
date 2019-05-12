package ch1.q7

import scala.annotation.tailrec

object Matrix {

  def rotate(matrix: Array[Array[Int]]): Unit = {

    @tailrec
    def helper(shift: Int): Unit = {
      val size = matrix.length - (2 * shift)
      if(size > 1) {
        val start = shift
        val end = shift + size - 1
        for(i <- 0 until size - 1) {
          val tmp1 = matrix(start)(start + i)
          val tmp2 = matrix(start + i)(end)
          val tmp3 = matrix(end)(end - i)
          val tmp4 = matrix(end  - i)(start)

          matrix(start + i)(end) = tmp1
          matrix(end)(end - i) = tmp2
          matrix(end  - i)(start) = tmp3
          matrix(start)(start + i) = tmp4
        }
        helper(shift + 1)
      }
    }

    helper(0)
  }

}
