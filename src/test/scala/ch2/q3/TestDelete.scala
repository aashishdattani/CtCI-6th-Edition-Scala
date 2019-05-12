package ch2.q3

import org.scalatest.FunSuite

import ch2.util.MyNode

class TestDelete extends FunSuite{

  test("simple delete") {
    val l = MyNode.apply(false, 3, 4, 5)
    val k = l.prepend(2).prepend(1)
    assert(k.toString == "1,2,3,4,5")
    DeleteNode.delete(l)
    assert(k.toString == "1,2,4,5")
  }

  test("single node delete") {
    val l = MyNode.apply(false, 2, 3)
    val k = l.prepend(1)
    assert(k.toString == "1,2,3")
    DeleteNode.delete(l)
    assert(k.toString == "1,3")
  }

}
