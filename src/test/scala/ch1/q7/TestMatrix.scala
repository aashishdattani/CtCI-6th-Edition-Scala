package ch1.q7

import org.scalatest.FunSuite

class TestMatrix extends FunSuite{

  def assertEquals(input: Array[Array[Int]], expected: Array[Array[Int]]): Unit = {
    for(i <- 1 until input.length; j <- 1 until input.length)
      assert(input(i)(j) == expected(i)(j))
  }

  test("4 x 4 matrix") {
    val input = Array(
      Array(1,  2,  3,  4),
      Array(5,  6,  7,  8),
      Array(9,  10, 11, 12),
      Array(13, 14, 15, 16)
    )

    val expected = Array(
      Array(13, 9,  5,  1),
      Array(14, 10,  6,  2),
      Array(15, 11, 7, 3),
      Array(16, 12, 8, 4)
    )

    Matrix.rotate(input)
    assertEquals(input, expected)
  }

  test("2 x 2 matrix") {
    val input = Array(
      Array(1, 2),
      Array(3, 4)
    )

    val expected = Array(
      Array(3, 1),
      Array(4, 2)
    )

    Matrix.rotate(input)
    assertEquals(input, expected)
  }

  test("empty matrix") {
    val input = Array(Array[Int]())
    val expected = Array(Array[Int]())
    Matrix.rotate(input)
    assertEquals(input, expected)
  }

}
