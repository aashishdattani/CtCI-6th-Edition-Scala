package ch1.q9

import org.scalatest.FunSuite

class TestRotation extends FunSuite{

  test("simple rotation") {
    assert(Rotation.isRotation("waterbottle", "erbottlewat"))
  }

  test("no rotation") {
    assert(!Rotation.isRotation("waterbottle", "watermelon"))
  }

  test("same character") {
    assert(!Rotation.isRotation("aaaa", "aa"))
  }

  test("empty string") {
    assert(Rotation.isRotation("", ""))
  }

}
