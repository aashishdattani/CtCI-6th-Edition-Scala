package ch1.q4

import org.scalatest.FunSuite

class TestPalindrome extends FunSuite{

  test("simple palindrome") {
    assert(Palindrome.isPalindromePermutation("aaabcecba"))
  }

  test("not palindrome") {
    assert(!Palindrome.isPalindromePermutation("adbcecba"))
  }

  test("empty string") {
    assert(Palindrome.isPalindromePermutation(""))
  }

}
