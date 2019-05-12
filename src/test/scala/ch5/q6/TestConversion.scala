package ch5.q6

import org.scalatest.FunSuite

class TestConversion extends FunSuite {

  test("simple conversion") {
    assert(Conversion.convert(29, 15) == 2)
  }

  test("simple conversion 2") {
    assert(Conversion.convert(433, 389) == 3)
  }

}
