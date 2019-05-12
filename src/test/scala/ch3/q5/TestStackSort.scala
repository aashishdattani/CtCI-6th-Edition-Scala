package ch3.q5

import ch3.util.MyStack
import org.scalatest.FunSuite

class TestStackSort extends FunSuite{

  test("simple sort") {
    val s = new MyStack[Int]
    s.push(2)
    s.push(3)
    s.push(1)
    s.push(5)
    s.push(4)

    StackSort.sort(s)

    assert(s.pop().get == 1)
    assert(s.pop().get == 2)
    assert(s.pop().get == 3)
    assert(s.pop().get == 4)
    assert(s.pop().get == 5)
  }

  test("sorted stack") {
    val s = new MyStack[Int]
    s.push(5)
    s.push(4)
    s.push(3)
    s.push(2)
    s.push(1)

    StackSort.sort(s)

    assert(s.pop().get == 1)
    assert(s.pop().get == 2)
    assert(s.pop().get == 3)
    assert(s.pop().get == 4)
    assert(s.pop().get == 5)
  }

  test("single element stack") {
    val s = new MyStack[Int]
    s.push(2)
    StackSort.sort(s)
    assert(s.pop().get == 2)
  }
}
