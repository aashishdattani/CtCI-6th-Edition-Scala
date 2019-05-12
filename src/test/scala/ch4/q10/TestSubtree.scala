package ch4.q10

import ch4.util.IntNode.node
import ch4.util.Node
import org.scalatest.FunSuite

class TestSubtree extends FunSuite {

  val t1: Option[Node[Int]] =
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

  test("simple subtree") {
    val t2 =
      node(2,
        left = node(4),
        right = node(5)
      )
    assert(Subtree.checkSubtree(t1, t2))
  }

  test("not a subtree") {
    val t2 =
      node(2,
        left = node(4),
        right = node(9)
      )
    assert(!Subtree.checkSubtree(t1, t2))
  }

  test("identity") {
    assert(Subtree.checkSubtree(t1, t1))
  }

  test("single node subtree") {
    val t2 = node(9)
    assert(Subtree.checkSubtree(t1, t2))
  }

}
