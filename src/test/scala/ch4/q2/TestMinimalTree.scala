package ch4.q2

import org.scalatest.FunSuite

class TestMinimalTree extends FunSuite {
  test("4-level tree") {
    val arr = Array.range(1, 10)
    assert(MinimalTree.getTree(arr).get.toString == "(5,(2,1,(3,_,4)),(7,6,(8,_,9)))")
  }

  test("3-level tree") {
    val arr = Array.range(1, 6)
    assert(MinimalTree.getTree(arr).get.toString == "(3,(1,_,2),(4,_,5))")
  }

  test("2-level tree") {
    val arr = Array.range(1, 3)
    assert(MinimalTree.getTree(arr).get.toString == "(1,_,2)")
  }
}
