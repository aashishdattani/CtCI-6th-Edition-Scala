package ch5.q4

object NextNumber {

  def next(x: Int): Int = {
    var c  = x
    var n = x
    var c0 = 0
    var c1 = 0
    while(((c & 1) == 0) && (c != 0)) {
      c0 += 1
      c >>= 1
    }

    while((c & 1) == 1) {
      c1 += 1
      c >>= 1
    }

    if(c0 + c1 == 31 || c0 + c1 == 0)
      -1

    val p = c0 + c1
    n |= (1 << p)
    n &= ~((1 << p) - 1)
    n |= (1 << (c1 - 1)) - 1
    n
  }

  def prev(x: Int): Int = {
    var temp = x
    var n = x
    var c0 = 0
    var c1 = 1

    while((temp & 1) == 1) {
      c1 += 1
      temp >>= 1
    }

    if(temp == 0)
      -1

    while(((temp & 1) == 0) && (temp != 0)) {
      c0 += 1
      temp >>= 1
    }

    var p = c0 + c1
    n &= ((~0) << (p + 1))
    val mask = (1 << (c1 + 1)) - 1
    n |= mask << (c0 - 1)
    n
  }

}
