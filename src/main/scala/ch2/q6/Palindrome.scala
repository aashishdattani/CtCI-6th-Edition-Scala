package ch2.q6

object Palindrome {

  def isPalindrome(input: List[Int]): Boolean = {

    def helper(l: List[Int]): Option[List[Int]] = l.length match {
      case 0 => Some(Nil)
      case x if input.length == (2 * x) - 1 => Some(l.tail)
      case x if input.length == 2 * x => Some(l)
      case _ => helper(l.tail) match {
        case Some(x) if l.head == x.head => Some(x.tail)
        case _ => None
      }
    }

    helper(input) match {
      case Some(Nil) => true
      case _ => false
    }

  }

}
