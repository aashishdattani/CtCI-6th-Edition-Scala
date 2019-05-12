package ch4.q5

import org.scalatest.FunSuite

import ch4.util.IntNode._

class TestValidateBST extends FunSuite {

  test("not BST tree") {
    val root =
      node(1,
        left = node(2,
          left = node(4),
          right = node(5)),
        right = node(3))

    assert(!ValidateBST.validate(root))
  }

  test("BST tree") {
    val root =
      node(4,
        left = node(2,
          left = node(1),
          right = node(3)),
        right = node(6,
          left = node(5),
          right = node(7)))

    assert(ValidateBST.validate(root))
  }

}
