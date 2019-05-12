package ch4.q10

import ch4.util.Node

object Subtree {

  def checkSubtree[T](node1: Option[Node[T]], node2: Option[Node[T]]): Boolean = {

    def checkExact(t1: Option[Node[T]], t2: Option[Node[T]]): Boolean =
      (t1, t2) match {
        case (None, None) => true
        case (None, Some(x)) => false
        case (Some(x), None) => false
        case (Some(n1), Some(n2)) =>
          (n1.id == n2.id) &&
            checkExact(n1.left, n2.left) &&
            checkExact(n1.right, n2.right)
    }

    (node1, node2) match {
      case (Some(n1), Some(n2)) =>
        if ((n1.id == n2.id) && checkExact(node1, node2))
          true
        else if (checkSubtree(n1.left, node2))
          true
        else
          checkSubtree(n1.right, node2)
      case _ => false
    }
  }
}
