package ch3.q6

import org.scalatest.FunSuite

class TestAnimalFarm extends FunSuite {

  test("test simple dequeue any") {
    val af = new AnimalFarm
    af.enqueue(Cat(10))
    assert(af.dequeueAny() == Cat(10))
  }

  test("test simple dequeue cat") {
    val af = new AnimalFarm
    af.enqueue(Cat(10))
    assert(af.dequeueCat() == Cat(10))
  }

  test("test simple dequeue dog") {
    val af = new AnimalFarm
    af.enqueue(Dog(10))
    assert(af.dequeueDog() == Dog(10))
  }

  test("test multiple") {
    val af = new AnimalFarm
    af.enqueue(Cat(10))
    af.enqueue(Dog(10))
    af.enqueue(Cat(20))
    assert(af.dequeueAny() == Cat(10))
    assert(af.dequeueCat() == Cat(20))
    assert(af.dequeueDog() == Dog(10))
  }
}
