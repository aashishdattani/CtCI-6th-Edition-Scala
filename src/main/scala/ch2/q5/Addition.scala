package ch2.q5

import scala.annotation.tailrec

object Addition {

  def add(num1: List[Int], num2: List[Int]): List[Int] = {

    @tailrec
    def helper(l1: List[Int], l2: List[Int], acc: List[Int], carry: Int): List[Int] = (l1, l2) match {

      case (Nil, Nil) => if(carry > 0) carry :: acc else acc

      case (_, Nil) => helper(l1.tail, l2, (l1.head + carry) % 10 :: acc, (l1.head + carry) / 10)

      case (Nil, _) => helper(l1, l2.tail, (l2.head + carry) % 10 :: acc, (l2.head + carry) / 10)

      case _ => helper(l1.tail, l2.tail, (l1.head + l2.head + carry) % 10 :: acc, (l1.head + l2.head + carry) / 10)
    }

    helper(num1.reverse, num2.reverse, List[Int](), 0)
  }

}
