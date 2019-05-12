package ch2.q7

import org.scalatest.FunSuite

class TestIntersection extends FunSuite {

  test("equal length intersect") {
    val common = List(1,2,3)
    val l1 = List(5,6) ::: common
    val l2 = List(7,8) ::: common
    assert(Intersection.intersect(l1, l2) eq common)
  }

  test("non equal length intersect") {
    val common = List(1,2,3)
    val l1 = List(4,5,6) ::: common
    val l2 = List(7,8) ::: common
    assert(Intersection.intersect(l1, l2) eq common)
  }

  test("full intersect") {
    val common = List(1,2,3)
    val l1 = List(7,8) ::: common
    val l2 = List(7,8) ::: common
    assert(Intersection.intersect(l1, l2) eq common)
  }

  test("empty intersect") {
    val common = List(1,2,3)
    val l1 = List(7,8) ::: common
    val l2 = common
    assert(Intersection.intersect(l1, l2) eq common)
  }

}
