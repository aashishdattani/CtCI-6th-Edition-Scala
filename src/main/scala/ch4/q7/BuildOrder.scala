package ch4.q7

import ch4.util.DirectedGraph

import scala.annotation.tailrec

object BuildOrder {

  def build[T](dg: DirectedGraph[T]): List[T] = {

    def incomingCounts(): Map[T, Int] = dg.graph.
      foldLeft(dg.graph.keys.map(_ -> 0).toMap) {
        (map, tuple) => map ++ tuple._2.map(key => key -> (1 + map.getOrElse(key, 0)))
      }

    def removeNode(n: T, counts: Map[T, Int]): Map[T, Int] = dg.graph(n).
      foldLeft(counts) ((map, node) => map + (node -> (map(node) - 1)))

    @tailrec
    def helper(counts: Map[T, Int], acc: List[T]): List[T] = counts.find(_._2 == 0) match {
      case None => acc
      case Some((node, _)) => helper(removeNode(node, counts - node), node :: acc)
    }

    helper(incomingCounts(), List[T]()).reverse
  }

}
