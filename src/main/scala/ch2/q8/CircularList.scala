package ch2.q8

import ch2.util.MyNode

import scala.annotation.tailrec

object CircularList {

  def isCircular(input: MyNode): Boolean = {
    @tailrec
    def helper(current: Option[MyNode], ahead: Option[MyNode]): Boolean = (current, ahead) match {
      case (Some(x), Some(y)) if x eq y => true
      case (Some(x), Some(y)) => y.next match {
          case None => false
          case Some(z) => helper(x.next, z.next)
        }
      case _ => false
    }

    helper(Some(input), input.next)
  }

}
