package ch1.q8

object Matrix {

  def zerofy(matrix: Array[Array[Int]]): Unit = {
    var rows = scala.collection.mutable.Set[Int]()
    var cols = scala.collection.mutable.Set[Int]()
    for(i <- 1 until matrix.length; j <- 1 until matrix.length)
      if(matrix(i)(j) == 0) {
        rows += i
        cols += j
      }

    rows.foreach(matrix(_) = new Array[Int](matrix.length))
    cols.foreach(col => matrix.foreach(_(col) = 0))
  }

}
