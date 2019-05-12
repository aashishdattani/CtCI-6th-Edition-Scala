package ch4.q4

import ch4.util.Node

object CheckBalanced {

  def check[T](root: Option[Node[T]]): Boolean = {

    def helper(node: Option[Node[T]]): (Boolean, Int) = node match {
      case None => (true, 0)
      case Some(x) =>
        val left = helper(x.left)
        val right = helper(x.right)
        (left._1 && right._1 && (math.abs(left._2 - right._2) <= 1),
          math.max(left._2, right._2) + 1)
    }

    helper(root)._1
  }
}
