package ch3.q5

import scala.math.max
import ch3.util.MyStack

import scala.annotation.tailrec

object StackSort {

  def sort(input: MyStack[Int]): Unit = {
    val backup = new MyStack[Int]

    @tailrec
    def popMax(size: Int, currentMax: Int): Int = input.peek() match {
      case None => currentMax
      case Some(_) if size == 0 => currentMax
      case Some(x) => {
        input.pop()
        backup.push(x)
        popMax(size - 1, max(currentMax, x))
      }
    }

    def pushMax(currentMax: Int): Unit = {
      @tailrec
      def removeAndPush(value: Int): Unit = {
        backup.pop() match {
          case None => Unit
          case Some(x) if value == x => removeAndPush(Int.MaxValue)
          case Some(x) => {
            input.push(x)
            removeAndPush(value)
          }
        }
      }
      input.push(currentMax)
      removeAndPush(currentMax)
    }

    for(i <- input.size to 1 by -1) { pushMax(popMax(i, Int.MinValue)) }
  }
}
