package ch3.q6

sealed trait Animal {
  val id: Int
  var order: Int = 0
}

case class Dog(id: Int) extends Animal {
  override def toString: String = "Dog:" + id.toString
}

case class Cat(id: Int) extends Animal {
  override def toString: String = "Cat:" + id.toString
}

class AnimalFarm {

  private val dogs = scala.collection.mutable.Queue[Animal]()
  private val cats = scala.collection.mutable.Queue[Animal]()
  var counter = 0

  def enqueue(a: Animal): Unit = {
    counter += 1
    a.order = counter
    a match {
      case Cat(_) => cats.enqueue(a)
      case Dog(_) => dogs.enqueue(a)
    }
  }

  def dequeueAny(): Animal = (cats.isEmpty, dogs.isEmpty) match {
    case (true, true) => throw new RuntimeException
    case (true, false) => dogs.dequeue()
    case (false, true) => cats.dequeue()
    case _ =>
      if (dogs.head.order < cats.head.order)
        dogs.dequeue()
      else
        cats.dequeue()
  }

  def dequeueDog(): Animal = dogs.dequeue()

  def dequeueCat(): Animal = cats.dequeue()
}
