package ch2.q1

object Duplicates {

  def remove(input: List[Int]): List[Int] = {
    input.foldLeft((List[Int](), Set[Int]()))(
      (acc, x) => {
        if (!acc._2.contains(x))
          (x :: acc._1, acc._2 + x)
        else
          acc
      }
    )._1.reverse
  }
}
