package ch2.q7

import scala.annotation.tailrec

object Intersection {

  def intersect(input1: List[Int], input2: List[Int]): List[Int] = {

    def normalize(l1: List[Int], l2: List[Int]): List[Int] =
      if(l1.length > l2.length) l1.drop(l1.length - l2.length) else l1

    @tailrec
    def getCommon(x: List[Int], y: List[Int]): List[Int] = (x, y) match {
      case (Nil, Nil) => Nil
      case _ => if (x eq y) x else getCommon(x.tail, y.tail)
    }

    getCommon(normalize(input1, input2), normalize(input2, input1))
  }

}
