package ch4.q8

import ch4.util.Node
import ch4.util.IntNode.node
import org.scalatest.FunSuite

class TestFCA extends FunSuite {

  val root: Option[Node[Int]] =
    node(1,
      left = node(2,
        left = node(4),
        right = node(5)
      ),
      right = node(3,
        left = node(6,
          left = node(7),
          right = node(8)
        ),
        right = node(9)
      )
    )

  test("same depths") {
    val node_4 = root.get.left.get.left
    val node_5 = root.get.left.get.right
    assert(FirstCommonAncestor.find(node_4, node_5).id == 2)
  }

  test("different depths") {
    val node_9 = root.get.right.get.right
    val node_7 = root.get.right.get.left.get.left
    assert(FirstCommonAncestor.find(node_7, node_9).id == 3)
  }

  test("intersect at root") {
    val node_4 = root.get.left.get.left
    val node_7 = root.get.right.get.left.get.left
    assert(FirstCommonAncestor.find(node_7, node_4).id == 1)
  }

  test("intersect with root") {
    val node_4 = root.get.left.get.left
    assert(FirstCommonAncestor.find(node_4, root).id == 1)
  }
}
