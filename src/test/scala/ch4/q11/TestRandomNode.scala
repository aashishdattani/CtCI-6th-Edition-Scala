package ch4.q11

import org.scalatest.FunSuite

class TestRandomNode extends FunSuite{

  test("test insert") {
    val rt = new RandomTree()

    rt.insert(4)
    assert(rt.root.get.count == 1)

    rt.insert(2)
    assert(rt.root.get.left.get.id == 2)
    assert(rt.root.get.count == 2)
    assert(rt.root.get.left.get.count == 1)

    rt.insert(6)
    assert(rt.root.get.right.get.id == 6)
    assert(rt.root.get.count == 3)
    assert(rt.root.get.right.get.count == 1)

    rt.insert(5)
    assert(rt.root.get.right.get.left.get.id == 5)
    assert(rt.root.get.count == 4)
    assert(rt.root.get.right.get.count == 2)
    assert(rt.root.get.right.get.left.get.count == 1)
  }

  test("test random") {
    val rt = new RandomTree()
    rt.insert(5)
    rt.insert(4)
    rt.insert(3)
    rt.insert(2)
    rt.insert(1)
    rt.insert(6)
    rt.insert(7)
    rt.insert(8)
    rt.insert(9)

    val size = rt.root.get.count
    val counts = Array.fill[Int](size){0}
    val REPS = 1000
    val ITERATIONS = size * REPS

    for(i <- 1 to ITERATIONS) {
      counts(rt.random().get.id - 1) += 1
    }

    counts.foreach(x => assert(math.round(x * 1.0 / REPS) == 1))
  }

}
