package ch1.q3

import org.scalatest.FunSuite

import scala.annotation.tailrec

class TestURL extends FunSuite{

  def urlify(str: String): String = {

    def toArray(s: String, size: Int): Array[Char] =
      Array.tabulate[Char](size)(i => if(i < s.length) s(i) else 0)

    def validLength(arr: Array[Char]): Int = {
      @tailrec
      def helper(a: Array[Char], current: Int): Int = {
        if(a.isEmpty || a.head == 0)
          current
        else
          helper(a.tail, current + 1)
      }
      helper(arr, 0)
    }

    def toString(arr: Array[Char]): String =
      arr.take(validLength(arr)).mkString

    val arr = toArray(str, str.length * 2)
    URL.replaceSpaces(arr, str.length)
    toString(arr)
  }

  test("urlify simple") {
    assert(urlify("abc def ghi") == "abc%20def%20ghi")
  }

  test("urlify no space") {
    assert(urlify("abcdefghi") == "abcdefghi")
  }

  test("urlify trail spaces") {
    assert(urlify("abc def ghi ") == "abc%20def%20ghi%20")
  }

  test("urlify lead spaces") {
    assert(urlify(" abc def ghi") == "%20abc%20def%20ghi")
  }

  test("empty string") {
    assert(urlify("") == "")
  }
}
