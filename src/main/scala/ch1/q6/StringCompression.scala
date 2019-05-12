package ch1.q6

import scala.annotation.tailrec

object StringCompression {

  def compress(str: String): String = {
    @tailrec
    def helper(s: String, acc: List[(Char, Int)]): List[(Char, Int)] = s match {
      case x if x.isEmpty => acc
      case x if acc.isEmpty || x.head != acc.head._1 => helper(s.tail, (s.head, 1) :: acc)
      case _ => helper(s.tail, (acc.head._1, acc.head._2 + 1) :: acc.tail)
    }

    helper(str, List()).reverse.map(x => x._1.toString + x._2.toString).mkString
  }

}
