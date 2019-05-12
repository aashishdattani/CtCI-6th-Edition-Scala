package ch3.q4

import org.scalatest.FunSuite

class TestMyQueue extends FunSuite {

  test("simple operations") {
    val q = new MyQueue
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    assert(q.dequeue().get == 1)
    assert(q.dequeue().get == 2)
    assert(q.dequeue().get == 3)
  }

  test("to string") {
    val q = new MyQueue
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    assert(q.toString == "1,2,3")
  }

  test("multiple operations") {
    val q = new MyQueue
    q.enqueue(1)
    q.enqueue(2)
    assert(q.dequeue().get == 1)
    q.enqueue(3)
    q.enqueue(4)
    assert(q.dequeue().get == 2)
    assert(q.dequeue().get == 3)
    q.enqueue(5)
    assert(q.dequeue().get == 4)
    assert(q.toString == "5")
  }
}
