package ch2.q1

import org.scalatest.FunSuite

class TestDuplicates extends FunSuite{

  test("simple duplicates") {
    val input = List(1,2,3,4,1,2)
    val expected = List(1,2,3,4)
    assert(Duplicates.remove(input) == expected)
  }

  test("consecutive") {
    val input = List(1,1,1,1,2,2,2,2)
    val expected = List(1,2)
    assert(Duplicates.remove(input) == expected)
  }

  test("no duplicates") {
    val input = List(1,2,3,4,5)
    assert(Duplicates.remove(input) == input)
  }

  test("empty list") {
    val input = List[Int]()
    assert(Duplicates.remove(input) == input)
  }

}
