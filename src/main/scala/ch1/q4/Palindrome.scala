package ch1.q4

import scala.annotation.tailrec

object Palindrome {

  def isPalindromePermutation(str: String): Boolean = {

    @tailrec
    def parities(s: String, current: Map[Char, Boolean] = Map()): Map[Char, Boolean] = {
      if(s.isEmpty)
        current
      else
        parities(s.tail, current + (s.head -> !current.getOrElse(s.head, false)))
    }

    @tailrec
    def countParities(m: Map[Char, Boolean], current: Map[Boolean, Int] = Map()): Map[Boolean, Int] = {
      if(m.isEmpty)
        current
      else
        countParities(m.tail, current + (m.head._2 -> (1 + current.getOrElse(m.head._2, 0))))
    }

    countParities(parities(str)).getOrElse(true, 1) == 1
  }
}
