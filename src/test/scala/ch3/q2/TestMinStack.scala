package ch3.q2

import org.scalatest.FunSuite

class TestMinStack extends FunSuite {

  test("stack create") {
    val s = MinStack(1,2,3)
    assert(s.head.isDefined)
  }

  test("to string") {
    val s = MinStack(3,5,2,8,1)
    assert(s.toString == "1,8,2,5,3")
  }

  test("push") {
    val s = MinStack(1,2)
    assert(s.toString == "2,1")
    s.push(3)
    assert(s.toString == "3,2,1")
  }

  test("pop") {
    val s = MinStack(1,2,3,4,5)
    assert(s.toString == "5,4,3,2,1")
    s.pop()
    assert(s.toString == "4,3,2,1")
    s.push(6)
    assert(s.toString == "6,4,3,2,1")
  }

  test("min") {
    val s = MinStack(3,5,2,8,1)
    assert(s.min == 1)
    s.pop()
    assert(s.min == 2)
    s.push(5)
    assert(s.min == 2)
  }

}
