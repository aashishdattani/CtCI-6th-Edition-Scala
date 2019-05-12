package ch3.q3

class SetofStacks(val capacity: Int) {

  class Stack(val nextStack: Option[Stack]) {

    class Node(val value: Int, val nextNode: Option[Node]) {
      override def toString: String = nextNode match {
        case None => value.toString
        case Some(x) => value.toString + "," + x.toString
      }
    }

    var headNode: Option[Node] = None
    var size: Int = 0

    override def toString: String =
      (headNode match {
      case None => ""
      case Some(x) => x.toString
      }) +
      (nextStack match {
      case None => ""
      case Some(x) => "|" + x.toString
      })

    def push(v: Int): Boolean = {
      if(size >= capacity)
        false
      else {
        headNode = Some(new Node(v, headNode))
        size += 1
        true
      }
    }

    def pop(): Option[Int] = headNode match {
      case None => {
        assert(size == 0)
        None
      }
      case Some(x) => {
        headNode = x.nextNode
        size -= 1
        Some(x.value)
      }
    }
  }

  var headStack: Option[Stack] = None
  var numStacks: Int = 0

  def push(v: Int): Unit = headStack match {
    case None => {
      val s = new Stack(None)
      assert(s.push(v))
      headStack = Some(s)
      numStacks += 1
    }
    case Some(x) => if(!x.push(v)) {
      val s = new Stack(headStack)
      assert(s.push(v))
      headStack = Some(s)
      numStacks += 1
     }
  }

  def pop(): Int = headStack match {
    case None => throw new RuntimeException
    case Some(x) => x.pop() match {
      case Some(y) => {
        if(x.size == 0) {
          headStack = x.nextStack
          numStacks -= 1
        }
        y
      }
      case None => throw new RuntimeException
    }
  }

  override def toString: String = headStack match {
    case None => ""
    case Some(x) => x.toString
  }
}

object SetofStacks {
  def apply(capacity: Int, values: List[Int]): SetofStacks = {
    val s = new SetofStacks(capacity)
    for (v <- values) s.push(v)
    s
  }
}
