package ch5.q7

object Pairwise {

  def swap(x: Int): Int = ((x & 0xaaaaaaaa) >>> 1 ) | ((x & 0x55555555) << 1)

}
