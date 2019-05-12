package ch3.q2

class MinStack {

  class Node(val value: Int, val next: Option[Node], currentMin: Int) {
    val min: Int = if(value > currentMin) currentMin else value

    override def toString: String = next match {
      case None => value.toString
      case Some(x) => value.toString + "," + x.toString
    }
  }

  var head: Option[Node] = None

  def push(v: Int): Unit = head match {
    case None => head = Some(new Node(v, head, Int.MaxValue))
    case Some(x) => head = Some(new Node(v, head, x.min))
  }

  def pop(): Int = head match {
    case None => throw new RuntimeException
    case Some(x) => head = x.next; x.value
  }

  def peek(): Int = head match {
    case None => throw new RuntimeException
    case Some(x) => x.value
  }

  def min(): Int = head match {
    case None => throw new RuntimeException
    case Some(x) => x.min
  }

  override def toString: String = head match {
    case None => ""
    case Some(x) => x.toString
  }
}

object MinStack {

  def apply(values: Int*): MinStack = {
    val s = new MinStack
    for(v <- values) s.push(v)
    s
  }

}