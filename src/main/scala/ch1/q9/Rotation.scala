package ch1.q9

object Rotation {

  def isRotation(s1: String, s2: String): Boolean = (s1.length == s2.length) && (s1 + s1).contains(s2)
}
