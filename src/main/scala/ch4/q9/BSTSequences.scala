package ch4.q9

import ch4.util.Node

object BSTSequences {

  def weave[T](l1: List[T], l2: List[T]): List[List[T]] = (l1.tail, l2.tail) match {
    case (Nil, Nil) => List(List(l1.head, l2.head), List(l2.head, l1.head))
    case (Nil, t2) => (l1.head :: l2) :: weave(l1, t2).map(l2.head :: _)
    case (t1, Nil) => (l2.head :: l1) :: weave(t1, l2).map(l1.head :: _)
    case (t1, t2) => weave(t1, l2).map(l1.head :: _) ::: weave(l1, t2).map(l2.head :: _)
  }

  def weaveLists[T](l1: List[List[T]], l2: List[List[T]]): List[List[T]] =
    l1.flatMap(v1 => l2.flatMap(v2 => weave(v1, v2)))

  def generate[T](root: Node[T]): List[List[T]] = (root.left, root.right) match {
    case (None, None) => List(List(root.id))
    case (None, Some(x)) => generate(x).map(root.id :: _)
    case (Some(x), None) => generate(x).map(root.id :: _)
    case (Some(x), Some(y)) =>
      weaveLists(generate(x), generate(y)).map(root.id :: _)
  }
}
