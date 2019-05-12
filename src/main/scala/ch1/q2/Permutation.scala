package ch1.q2

object Permutation {

  def isPermutation(s1: String, s2: String): Boolean = {

    def toMap(s: String): Map[Char,Int] = s.groupBy(identity).mapValues(_.size)

    toMap(s1) == toMap(s2)
  }

}
