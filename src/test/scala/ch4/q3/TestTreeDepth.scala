package ch4.q3

import org.scalatest.FunSuite

import ch4.util.IntNode._

class TestTreeDepth extends FunSuite {

  test("simple tree") {
    val root =
      node(1,
        left = node(2,
          left = node(4),
          right = node(5)),
        right = node(3))

    assert(TreeDepth.getLists(root.get) == Map(1 -> List(1), 2 -> List(3, 2), 3 -> List(5, 4)))
  }

  test("long tail tree") {
    val root =
      node(1,
        left = node(2,
          left = node(4),
          right = node(5)
        ),
        right = node(3,
          left = node(6,
            left = node(7),
          )
        )
      )

    assert(TreeDepth.getLists(root.get) == Map(3 -> List(6, 5, 4), 2 -> List(3, 2), 4 -> List(7), 1 -> List(1)))
  }


}
