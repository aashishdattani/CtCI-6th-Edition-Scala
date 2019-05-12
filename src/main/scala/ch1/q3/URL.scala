package ch1.q3

import scala.annotation.tailrec

object URL {

  def replaceSpaces(arr: Array[Char], stringLength: Int): Unit = {
    @tailrec
    def numSpaces(a: Array[Char], current: Int): Int = {
      if(a.isEmpty || a.head == 0)
        current
      else
        numSpaces(a.tail, if(a.head == ' ') current + 1 else current)
    }

    @tailrec
    def modifyArray(original: Int, modified: Int): Unit = {
      if(original >= 0) {
        assert(modified >= 0)
        if(arr(original) == ' ') {
          arr(modified) = '0'
          arr(modified - 1) = '2'
          arr(modified - 2) = '%'
          modifyArray(original - 1, modified - 3)
        }
        else {
          arr(modified) = arr(original)
          modifyArray(original - 1, modified - 1)
        }
      }
    }

    val finalLength = stringLength + (2 * numSpaces(arr, 0))
    assert(arr.length >= finalLength)
    modifyArray(stringLength - 1, finalLength - 1)
  }
}
