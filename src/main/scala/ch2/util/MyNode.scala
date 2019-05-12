package ch2.util

class MyNode(v: Int) {
  var value = v
  var next: Option[MyNode] = None

  def prepend(v: Int): MyNode = {
    val newNode = new MyNode(v)
    newNode.next = Some(this)
    newNode
  }

  override def toString: String = next match {
    case None => value.toString
    case Some(x) => value.toString + "," + x.toString
  }

}

object MyNode {

  def apply(isCircular: Boolean, vals: Int*): MyNode = {
    val rev = vals.reverse
    var last = new MyNode(rev.head)
    var prev = last
    for(v <- rev.drop(1)) {
      val x = new MyNode(v)
      x.next = Some(prev)
      prev = x
    }
    if(isCircular)
      last.next = Some(prev)
    prev
  }

}