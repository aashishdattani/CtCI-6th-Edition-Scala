package ch5.q4

import org.scalatest.FunSuite

class TestNextNumber extends FunSuite {

  test("test next") {
    assert(NextNumber.next(1899) == 1901)
  }

  test("test prev") {
    assert(NextNumber.prev(1899) == 1903)
  }

}
