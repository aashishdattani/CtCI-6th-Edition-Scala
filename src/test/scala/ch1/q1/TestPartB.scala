package ch1.q1

import org.scalatest.FunSuite

class TestPartB extends FunSuite {

  test("hasUnique false") {
    assert(!PartB.hasUnique("1abcda1"))
  }

  test("hasUnique true") {
    assert(PartB.hasUnique("abcdefg"))
  }

  test("empty string") {
    assert(PartB.hasUnique(""))
  }

  test("repeated chars") {
    assert(!PartB.hasUnique("aaa;:.aaa"))
  }

}
