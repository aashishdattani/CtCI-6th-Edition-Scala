package ch3.util

class MyStack[T] {
  class Node(val value: T, val nextNode: Option[Node]) {
    def toString(isReverse: Boolean = false): String = nextNode match {
      case None => value.toString
      case Some(x) if isReverse =>  x.toString(isReverse) + "," + value.toString
      case Some(x) => value.toString + "," + x.toString(isReverse)
    }
  }

  override def toString: String = toString()

  var headNode: Option[Node] = None
  var size: Int = 0

  def toString(isReverse: Boolean = false): String = headNode match {
    case None => ""
    case Some(x) => x.toString(isReverse)
  }

  def push(v: T): Unit = { headNode = Some(new Node(v, headNode)); size += 1 }

  def push(s: Seq[T]): Unit = {s.foreach(push)}

  def pop(): Option[T] = headNode match {
    case None => None
    case Some(x) => headNode = x.nextNode; size -= 1; Some(x.value)
  }

  def peek(): Option[T] = headNode match {
    case None => None
    case Some(x) => Some(x.value)
  }
}
