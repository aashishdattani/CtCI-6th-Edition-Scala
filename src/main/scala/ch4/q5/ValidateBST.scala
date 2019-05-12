package ch4.q5

import ch4.util.Node

object ValidateBST {

  def validate(root: Option[Node[Int]]): Boolean = {

    def helper(n: Option[Node[Int]]): (Boolean, Int, Int) = n match {
      case None => (true, Int.MaxValue, Int.MinValue)
      case Some(x) =>
        val left = helper(x.left)
        val right = helper(x.right)
        (left._1 && right._1 && (left._3 <= x.id) && (right._2 >= x.id),
          math.min(left._2, x.id),
          math.max(right._3, x.id))
    }
    helper(root)._1
  }
}
