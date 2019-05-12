package ch1.q6

import org.scalatest.FunSuite

class TestCompression extends FunSuite{
  test("simple compress") {
    val s = "abcdedaaa"
    val c = "a1b1c1d1e1d1a3"
    assert(StringCompression.compress(s) == c)
  }

  test("empty compress") {
    assert(StringCompression.compress("") == "")
  }

  test("unique chars") {
    assert(StringCompression.compress("abcdef") == "a1b1c1d1e1f1")
  }

  test("all same chars") {
    assert(StringCompression.compress("aaaa") == "a4")
  }
}
