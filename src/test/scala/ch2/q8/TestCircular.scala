package ch2.q8

import org.scalatest.FunSuite
import ch2.util.MyNode

class TestCircular extends FunSuite {

  test("simple circular list") {
    val l = MyNode.apply(true, 1, 2, 3, 4, 5)
    assert(CircularList.isCircular(l))
  }

  test("non circular list") {
    val l = MyNode.apply(false, 1, 2, 3, 4, 5)
    assert(!CircularList.isCircular(l))
  }

  test("branched circular list") {
    val l = MyNode.apply(true, 1, 2, 3, 4, 5).prepend(6).prepend(7)
    assert(CircularList.isCircular(l))
  }

}
