package ch2.q5

import org.scalatest.FunSuite

class TestAddition extends FunSuite {

  test("no carry") {
    val num1 = 1 :: 2 :: 3 :: Nil
    val num2 = 3 :: 4 :: 5 :: Nil
    assert(Addition.add(num1, num2) == List(4, 6, 8))
  }

  test("final carry") {
    val num1 = 1 :: 6 :: 5 :: Nil
    val num2 = 3 :: 4 :: 5 :: Nil
    assert(Addition.add(num1, num2) == List(5, 1, 0))
  }

  test("unequal lenghts") {
    val num1 = 1 :: 6 :: 5 :: Nil
    val num2 = 2 :: 5 :: Nil
    assert(Addition.add(num1, num2) == List(1, 9, 0))
    assert(Addition.add(num2, num1) == List(1, 9, 0))
  }

  test("units carry") {
    val num1 = 6 :: 1 :: 7 :: Nil
    val num2 = 9 :: 5 :: 9 :: 2 :: Nil
    assert(Addition.add(num1, num2) == List(1, 0, 2, 0, 9))
  }

}
