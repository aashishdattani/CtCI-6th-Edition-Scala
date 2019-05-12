package ch2.q6

import org.scalatest.FunSuite

class TestPalindrome extends FunSuite {
  test("odd length palindrome") {
    val l = List(1,2,3,2,1)
    assert(Palindrome.isPalindrome(l))
  }

  test("even length palindrome") {
    val l = List(1,2,3,3,2,1)
    assert(Palindrome.isPalindrome(l))
  }

  test("non palindrome") {
    val l = List(1,2,3,5,2,1)
    assert(!Palindrome.isPalindrome(l))
  }

  test("single element") {
    val l = List(1)
    assert(Palindrome.isPalindrome(l))
  }

  test("two elements") {
    val l = List(1,1)
    assert(Palindrome.isPalindrome(l))
  }

  test("two elements non palindrome") {
    val l = List(1,2)
    assert(!Palindrome.isPalindrome(l))
  }

  test("empty list") {
    val l = List()
    assert(Palindrome.isPalindrome(l))
  }
}
