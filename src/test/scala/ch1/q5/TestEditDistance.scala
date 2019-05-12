package ch1.q5

import org.scalatest.FunSuite

class TestEditDistance extends FunSuite{
  test("replace") {
    val s1 = "abcdef"
    val s2 = "abcdgf"
    assert(EditDistance.isEdit(s1, s2))
  }

  test("addition") {
    val s1 = "abcdef"
    val s2 = "abcdefg"
    assert(EditDistance.isEdit(s1, s2))
  }

  test("deletion") {
    val s1 = "abcde"
    val s2 = "abcdef"
    assert(EditDistance.isEdit(s1, s2))
  }

  test("multiple edits") {
    val s1 = "abcdef"
    val s2 = "abdce"
    assert(!EditDistance.isEdit(s1, s2))
  }

  test("equal strings") {
    val s = "abcdef"
    assert(EditDistance.isEdit(s, s))
  }

  test("one empty string") {
    val s1 = ""
    val s2 = "a"
    assert(EditDistance.isEdit(s1, s2))
  }

  test("both empty strings") {
    assert(EditDistance.isEdit("", ""))
  }
}
