package ch4.q6

import ch4.util.IntNode.node
import org.scalatest.FunSuite

class TestSuccessor extends FunSuite {

  val root =
    node(4,
      left = node(2,
        left = node(1),
        right = node(3)),
      right = node(6,
        left = node(5),
        right = node(7)))

  test("test right child") {
    val node_2 = root.get.left
    assert(Successor.getSuccessor(node_2).get.id == 3)
  }

  test("test get smallest leaf") {
    assert(Successor.getSuccessor(root).get.id == 5)
  }

  test("test get next largest parent") {
    val node_3 = root.get.left.get.right
    assert(Successor.getSuccessor(node_3).get.id == 4)
  }


}
