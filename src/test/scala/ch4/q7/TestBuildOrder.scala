package ch4.q7

import ch4.util.DirectedGraph
import org.scalatest.FunSuite

class TestBuildOrder extends FunSuite {

  test("simple dg") {
    val dg = new DirectedGraph[Int](
      Map(
        1 -> Set(2, 3, 4),
        2 -> Set(),
        3 -> Set(4, 5),
        4 -> Set(2),
        5 -> Set(6),
        6 -> Set(4)
      )
    )

    assert(BuildOrder.build(dg) == List(1, 3, 5, 6, 4, 2))
  }

  test("cyclic dg") {
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

    assert(BuildOrder.build(dg).size != dg.graph.size)
  }

}
