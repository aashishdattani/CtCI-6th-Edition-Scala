package ch5.q7

import org.scalatest.FunSuite

class TestPairwise extends FunSuite {

  test("simple swap") {
    assert(Pairwise.swap(389) == 586)
  }

  test("simple swap 2") {
    assert(Pairwise.swap(586) == 389)
  }

}
