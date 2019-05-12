package ch4.q6

import ch4.util.Node

object Successor {

  def getSuccessor[T](input: Option[Node[T]]): Option[Node[T]] = {

    def getSmallestLeaf(n: Node[T]): Node[T] = n.left match {
      case None => n
      case Some(x) => getSmallestLeaf(x)
    }

    def getNextLargestParent(n: Node[T]): Option[Node[T]] = n.parent match {
      case None => None
      case Some(x) =>
        if(x.left.contains(n))
          n.parent
        else
          getNextLargestParent(x)
    }

    input match {
      case None => None
      case Some(x) if x.right.isEmpty => getNextLargestParent(x)
      case Some(x) => Some(getSmallestLeaf(x.right.get))
    }
  }
}
