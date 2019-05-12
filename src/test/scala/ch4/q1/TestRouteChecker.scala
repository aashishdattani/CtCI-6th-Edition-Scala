package ch4.q1

import org.scalatest.FunSuite

import ch4.util.DirectedGraph

class TestRouteChecker extends FunSuite {

  val dg = new DirectedGraph[Int](
    Map(
      1 -> Set(2, 3, 4),
      2 -> Set(),
      3 -> Set(4, 5),
      4 -> Set(2),
      5 -> Set(6),
      6 -> Set(3, 4)
    )
  )

  test("check route") {
    assert(RouterChecker.checkRoute(dg, 5, 2))
  }

  test("check no route") {
    assert(!RouterChecker.checkRoute(dg, 6, 1))
  }

}
