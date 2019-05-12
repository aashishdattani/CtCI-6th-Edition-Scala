package ch1.q1

import org.scalatest.FunSuite

class TestPartC extends FunSuite {

  test("hasUnique false") {
    assert(!PartC.hasUnique("abcda"))
  }

  test("hasUnique true") {
    assert(PartC.hasUnique("abcdefg"))
  }

  test("empty string") {
    assert(PartC.hasUnique(""))
  }

  test("repeated chars") {
    assert(!PartC.hasUnique("aaaaaa"))
  }

}
