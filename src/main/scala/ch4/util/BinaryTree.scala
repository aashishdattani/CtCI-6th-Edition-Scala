package ch4.util

case class Node[T](id: T, left: Option[Node[T]], right: Option[Node[T]]) {

  var parent: Option[Node[T]] = None

  override def toString: String = (left, right) match {
    case (None, None) => id.toString
    case (Some(x), None) => "(" + id.toString + "," + x.toString + ",_)"
    case (None, Some(x)) => "(" + id.toString + ",_," + x.toString + ")"
    case (Some(x), Some(y)) => "(" + id.toString + "," + x.toString + "," + y.toString + ")"
  }
}

object IntNode {
  def node(id: Int, left: Option[Node[Int]] = None, right: Option[Node[Int]] = None): Option[Node[Int]] = (left, right) match {
    case (None, None) => Some(Node[Int](id, None, None))
    case (Some(l), None) =>
      val n = Some(Node[Int](id, Some(l), None))
      l.parent = n
      n
    case(None, Some(r)) =>
      val n = Some(Node[Int](id, None, Some(r)))
      r.parent = n
      n
    case (Some(l), Some(r)) =>
      val n = Some(Node[Int](id, Some(l), Some(r)))
      l.parent = n
      r.parent = n
      n
  }
}