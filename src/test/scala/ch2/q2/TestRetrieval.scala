package ch2.q2

import org.scalatest.FunSuite

class TestRetrieval extends FunSuite {

  test("simple k") {
    val l = List(1,2,3,4,5,6,7)
    assert(Retrieval.fromLast(l, 3) == 5)
  }

  test("large k") {
    val l = List(1,2,3,4)
    assertThrows[AssertionError] {
      Retrieval.fromLast(l, 6)
    }
  }

  test("last element") {
    val l = List(1,2,3,4)
    assert(Retrieval.fromLast(l, 1) == 4)
  }

  test("first element") {
    val l = List(1,2,3,4)
    assert(Retrieval.fromLast(l, 4) == 1)
  }

  test("k = 0") {
    val l = List(1,2,3,4)
    assertThrows[AssertionError] {
      Retrieval.fromLast(l, 0)
    }
  }

}
