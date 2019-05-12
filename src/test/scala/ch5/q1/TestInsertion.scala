package ch5.q1

import org.scalatest.FunSuite

class TestInsertion extends FunSuite {

  test("simple insertion") {
    val N = 1121 //10001100001
    val M = 11   //    01011
    val e = 1069 //10000101101
    assert(Insertion.insert(N, M, 2, 6) == e)
  }

}
