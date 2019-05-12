package ch4.q9

import org.scalatest.FunSuite

class TestBSTSequences extends FunSuite {

  test("simple weave") {
    assert(BSTSequences.weave(List(2,1), List(3,4))
      == List(List(2, 1, 3, 4), List(2, 3, 1, 4), List(2, 3, 4, 1), List(3, 4, 2, 1), List(3, 2, 1, 4), List(3, 2, 4, 1)))
  }

  test("simple weaveLists") {
    val l1 = List(List(1, 2), List(2, 1))
    val l2 = List(List(3, 4), List(4, 3))
    assert(BSTSequences.weaveLists(l1, l2)
      == List(
      List(1, 2, 3, 4), List(1, 3, 2, 4), List(1, 3, 4, 2), List(3, 4, 1, 2),
      List(3, 1, 2, 4), List(3, 1, 4, 2), List(1, 2, 4, 3), List(1, 4, 2, 3),
      List(1, 4, 3, 2), List(4, 3, 1, 2), List(4, 1, 2, 3), List(4, 1, 3, 2),
      List(2, 1, 3, 4), List(2, 3, 1, 4), List(2, 3, 4, 1), List(3, 4, 2, 1),
      List(3, 2, 1, 4), List(3, 2, 4, 1), List(2, 1, 4, 3), List(2, 4, 1, 3),
      List(2, 4, 3, 1), List(4, 3, 2, 1), List(4, 2, 1, 3), List(4, 2, 3, 1)
    ))
  }
}
