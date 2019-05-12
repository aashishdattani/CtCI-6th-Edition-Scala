package ch4.q3

import ch4.util.Node

object TreeDepth {

  def getLists[T](root: Node[T]): Map[Int, List[T]] = {

    def merge(m1: Map[Int, List[T]], m2: Map[Int, List[T]]): Map[Int, List[T]] =
      m1 ++ m2.map{case (k,v) => k -> (v ::: m1.getOrElse(k, List[T]()))}

    def helper(depth: Int, current: Option[Node[T]]): Map[Int, List[T]] =
      current match {
        case None =>
          Map[Int, List[T]]()
        case Some(x) =>
          merge(
            merge(
              helper(depth + 1, x.left),
              helper(depth + 1, x.right)
            ),
            Map(depth -> List(x.id))
          )
      }

    helper(1, Some(root))
  }

}
