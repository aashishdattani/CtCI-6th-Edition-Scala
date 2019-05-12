package ch1.q1

import org.scalatest.FunSuite

class TestPartA extends FunSuite {

  test("hasUnique false") {
    assert(!PartA.hasUnique("abcda"))
  }

  test("hasUnique true") {
    assert(PartA.hasUnique("abcdefg"))
  }

  test("empty string") {
    assert(PartA.hasUnique(""))
  }

  test("repeated chars") {
    assert(!PartA.hasUnique("aaaaaa"))
  }

}
