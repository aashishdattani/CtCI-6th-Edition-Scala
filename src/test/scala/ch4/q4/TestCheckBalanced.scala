package ch4.q4

import org.scalatest.FunSuite

import ch4.util.IntNode._

class TestCheckBalanced extends FunSuite {

  test("balanced tree") {
    val root =
      node(1,
        left = node(2,
          left = node(4),
          right = node(5)),
        right = node(3))

    assert(CheckBalanced.check(root))
  }

  test("unbalanced tree") {
    val root =
      node(1,
        left = node(2,
          left = node(4,
            left = node(6)
          ),
          right = node(5)),
        right = node(3))

    assert(!CheckBalanced.check(root))
  }
}
