package ch5.q3

import org.scalatest.FunSuite

class TestFlipBit extends FunSuite {

  test("simple flip") {
    assert(FlipBit.longestSequence(1775) == 8) //11011101111
  }

  test("simple flip 2") {
    assert(FlipBit.longestSequence(14061) == 6) //11011011101101
  }

  test("simple flip 3") {
    assert(FlipBit.longestSequence(682) == 3) //1010101010
  }

}
