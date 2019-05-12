package ch4.q1

import ch4.util.DirectedGraph

import scala.annotation.tailrec
import scala.collection.immutable.Queue

object RouterChecker {

  def checkRoute[T](dg: DirectedGraph[T], node1: T, node2: T): Boolean = {

    @tailrec
    def helper(queue: Queue[T], seen: Set[T]): Boolean = queue.dequeueOption match {
      case None => false
      case Some((n, q)) if n == node2 => true
      case Some((n, q)) => helper(q.enqueue(dg.graph(n).filter(!seen.contains(_))), seen + n)
    }

    helper(Queue[T](node1), Set[T]())
  }
}
