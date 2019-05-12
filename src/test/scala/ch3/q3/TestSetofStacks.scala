package ch3.q3

import org.scalatest.FunSuite

class TestSetofStacks extends FunSuite {

  test("create") {
    val s = SetofStacks(3, List(1,2,3,4,5,6,7))
    assert(s.headStack.isDefined)
    assert(s.numStacks == 3)
    assert(s.headStack.get.size == 1)
  }

  test("to string") {
    val s = SetofStacks(3, List(1,2,3,4,5,6,7))
    assert(s.toString == "7|6,5,4|3,2,1")
  }

  test("simple push") {
    val s = SetofStacks(3, List(1,2,3,4,5,6,7))
    assert(s.toString == "7|6,5,4|3,2,1")
    s.push(8)
    assert(s.toString == "8,7|6,5,4|3,2,1")
  }

  test("new stack push") {
    val s = SetofStacks(3, List(1,2,3,4,5,6))
    assert(s.toString == "6,5,4|3,2,1")
    assert(s.numStacks == 2)
    s.push(7)
    assert(s.toString == "7|6,5,4|3,2,1")
    assert(s.numStacks == 3)
  }

  test("simple pop") {
    val s = SetofStacks(3, List(1,2,3,4,5,6,7,8))
    assert(s.toString == "8,7|6,5,4|3,2,1")
    assert(s.pop() == 8)
    assert(s.toString == "7|6,5,4|3,2,1")
  }

  test("multi stack pop") {
    val s = SetofStacks(3, List(1,2,3,4,5,6,7))

    assert(s.toString == "7|6,5,4|3,2,1")
    assert(s.numStacks == 3)

    assert(s.pop() == 7)
    assert(s.toString == "6,5,4|3,2,1")
    assert(s.numStacks == 2)

    assert(s.pop() == 6)
    assert(s.toString == "5,4|3,2,1")
    assert(s.numStacks == 2)
  }

}
