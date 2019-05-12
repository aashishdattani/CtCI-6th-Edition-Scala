package ch4.q2

import ch4.util.Node

object MinimalTree {

  def getTree[T](arr: Array[T]): Option[Node[T]] = {

    def helper(start: Int, end: Int): Option[Node[T]] = (start, end) match {
      case (x, y) if x == y =>
        Some(Node[T](
          arr(x),
          None,
          None
        ))
      case (x, y) if y - x == 1 =>
        Some(Node[T](
          arr(x),
          None,
          Some(Node[T](
            arr(y),
            None,
            None
          ))
        ))
      case (x, y) =>
        Some(Node[T](
          arr((x + y)/2),
          helper(start, (x + y)/2 - 1),
          helper((x + y)/2 + 1, end)
        ))
    }
    helper(0, arr.length - 1)
  }
}
