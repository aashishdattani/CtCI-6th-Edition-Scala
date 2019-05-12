package ch4.q8

import ch4.util.Node

import scala.annotation.tailrec

object FirstCommonAncestor {

  def find[T](node1: Option[Node[T]], node2: Option[Node[T]]): Node[T] = {

    @tailrec
    def getAncestors(n: Option[Node[T]], acc: List[Node[T]]): List[Node[T]] = n match {
      case None => acc
      case Some(x) => getAncestors(x.parent, x :: acc)
    }

    @tailrec
    def getIntersection(l1: List[Node[T]], l2: List[Node[T]]): Node[T] = (l1.tail, l2.tail) match {
      case (h1 :: t1, h2 :: t2) =>
        if(h1.id != h2.id)
          l1.head
        else
          getIntersection(l1.tail, l2.tail)
      case (Nil, h2 :: t2) => l1.head
      case (h1 :: t1, Nil) => l1.head
      case _ => throw new RuntimeException
    }

    getIntersection(
      getAncestors(node1, List()),
      getAncestors(node2, List())
    )
  }

}
