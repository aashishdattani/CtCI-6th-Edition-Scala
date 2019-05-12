package ch5.q2

import org.scalatest.FunSuite

class TestConversion extends FunSuite {

  test("simple binary") {
    assert(Conversion.convert(0.5) == "0.1")
  }

  test("complex binary") {
    assert(Conversion.convert(0.72) == "0.101110000101000111101011100001")
  }

}
