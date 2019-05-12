package ch1.q2

import org.scalatest.FunSuite

class TestPermutation extends FunSuite {

  test("permuted strings") {
    assert(Permutation.isPermutation("aabcd", "badac"))
  }

  test("not permuted strings") {
    assert(!Permutation.isPermutation("aabcd", "abcd"))
    assert(!Permutation.isPermutation("aabcd", "abcde"))
  }

}
