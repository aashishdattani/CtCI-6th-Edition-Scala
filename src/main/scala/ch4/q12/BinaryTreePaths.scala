package ch4.q12

import ch4.util.Node

object BinaryTreePaths {

  def numPaths(root: Option[Node[Int]], target: Int): Int = {

    def helper(node: Option[Node[Int]], acc: Int, counts: Map[Int, Int]): Int = node match {
      case None => 0
      case Some(x) =>
        val newAcc = acc + x.id
        val newCount = counts.getOrElse(newAcc, 0) + 1
        counts.getOrElse(newAcc - target, 0) +
          helper(x.left, newAcc, counts + (newAcc -> newCount)) +
          helper(x.right, newAcc, counts + (newAcc -> newCount))
    }

    helper(root, 0, Map(0 -> 1))
  }
}
