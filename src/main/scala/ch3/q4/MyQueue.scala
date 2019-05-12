package ch3.q4

import scala.annotation.tailrec
import ch3.util.MyStack

class MyQueue {
  val forward = new MyStack[Int]
  val reverse = new MyStack[Int]
  var stacked = true

  @tailrec
  private def flip(s1: MyStack[Int], s2: MyStack[Int]): Unit = s1.pop() match {
    case None => Unit
    case Some(x) => s2.push(x); flip(s1, s2)
  }

  def enqueue(v: Int): Unit = {
    if(!stacked) {
      flip(reverse, forward)
      stacked = true
    }
    forward.push(v)
  }

  def dequeue(): Option[Int] = {
    if(stacked) {
      flip(forward, reverse)
      stacked = false
    }
    reverse.pop()
  }

  override def toString: String =
    if(stacked)
      forward.toString(true)
    else
      reverse.toString(false)
}
