package ch2.q3

import ch2.util.MyNode

object DeleteNode {

  def delete(node: MyNode): Unit = node.next match {
    case None => ???
    case Some(x) => node.value = x.value; node.next = x.next
  }

}
