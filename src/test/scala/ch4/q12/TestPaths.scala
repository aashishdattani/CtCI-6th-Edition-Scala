package ch4.q12

import org.scalatest.FunSuite

import ch4.util.IntNode.node

class TestPaths extends FunSuite {

  test("simple tree") {
    val root = node(5,
      left = node(3,
        left = node(-4,
          left = node(-2),
          right = node(3)
        ),
        right = node(2,
          right = node(-3)
        )
      ),
      right = node(-1,
        left = node(3),
        right = node(4))
    )
    assert(BinaryTreePaths.numPaths(root, 2) == 5)
  }

  test("straight line") {
    val root = node(10,
      left = node(5,
        left = node(1,
          left = node(2,
            left = node(-1,
              left = node(-1,
                left = node(7,
                  left = node(1,
                    left = node(2)
                  ))))))),
      )
    assert(BinaryTreePaths.numPaths(root, 8) == 5)
  }

}
