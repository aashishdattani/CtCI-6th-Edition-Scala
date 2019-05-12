package ch1.q8

import org.scalatest.FunSuite

class TestMatrix extends FunSuite{

  def assertEquals(input: Array[Array[Int]], expected: Array[Array[Int]]): Unit = {
    for(i <- 1 until input.length; j <- 1 until input.length)
      assert(input(i)(j) == expected(i)(j))
  }

  test("4 x 4 matrix") {
    val input = Array(
      Array(1,  2,  3,  4),
      Array(5,  0,  7,  0),
      Array(9,  10, 11, 12),
      Array(13, 14, 15, 16)
    )

    val expected = Array(
      Array(1,  0,  3,  0),
      Array(0,  0,  0,  0),
      Array(9,  0, 11,  0),
      Array(13, 0, 15,  0)
    )

    Matrix.zerofy(input)
    assertEquals(input, expected)
  }

  test("2 x 2 matrix") {
    val input = Array(
      Array(0, 2),
      Array(3, 0)
    )

    val expected = Array(
      Array(0, 0),
      Array(0, 0)
    )

    Matrix.zerofy(input)
    assertEquals(input, expected)
  }

  test("empty matrix") {
    val input = Array(Array[Int]())
    val expected = Array(Array[Int]())
    Matrix.zerofy(input)
    assertEquals(input, expected)
  }

}
