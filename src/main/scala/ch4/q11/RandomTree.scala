package ch4.q11

import scala.annotation.tailrec
import scala.util.Random

class RandomTree {

  case class Node(id: Int) {
    var count = 1
    var left: Option[Node] = None
    var right: Option[Node] = None
  }

  var root: Option[Node] = None
  val rnd: Random = new Random()

  def insert(v: Int): Unit = {
    @tailrec
    def helper(node: Option[Node]): Unit = node match {
      case None => root = Some(Node(v))
      case Some(x) =>
        x.count += 1
        if(v <= x.id) {
          if(x.left.isEmpty)
            x.left = Some(Node(v))
          else
            helper(x.left)
        }
        else {
          if(x.right.isEmpty)
            x.right = Some(Node(v))
          else
            helper(x.right)
        }
    }

    helper(root)
  }

  def random(): Option[Node] = {

    def size(node: Option[Node]): Int = node match {
      case None => 0
      case Some(x) => x.count
    }

    def helper(node: Option[Node]): Option[Node] = node match {
      case None => None
      case Some(x) =>
        val randomNum = rnd.nextInt(size(node)) + 1
        val leftSize = size(x.left)
        if(randomNum == leftSize + 1)
          node
        else if(randomNum <= leftSize)
          helper(x.left)
        else
          helper(x.right)
    }

    helper(root)
  }

}
