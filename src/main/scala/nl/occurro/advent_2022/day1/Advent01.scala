package nl.occurro.advent_2022.day1

import Elf._

def readFile(filename: String): List[Elf] = {

  def splitBy[A](sep: A, seq: List[A]): List[List[A]] = {
    @annotation.tailrec
    def rec(xs: List[A], revAcc: List[List[A]]): List[List[A]] =
      xs match {
        case Nil => revAcc.reverse
        case h :: t =>
          if (h == sep) {
            val (pref, suff) = t.span(_ != sep)
            rec(suff, pref :: revAcc)
          } else {
            val (pref, suff) = xs.span(_ != sep)
            rec(suff, pref :: revAcc)
          }
      }

    rec(seq, Nil)
  }

  val bufferedSource = io.Source.fromFile(filename)
  val lines =
    (for (line <- bufferedSource.getLines()) yield line).toList
  bufferedSource.close

  val lists = splitBy("", lines)

  lists.zipWithIndex.map {
    case (list, index) => Elf(index + 1, list.map(s => s.toInt))
  }
}

object Advent01 extends App {

  val elfs: Seq[Elf] = readFile("./src/main/resources/input01.txt")

  val foodCarried: Seq[(Int, Int)] = elfs.map(e => (e.position, e.totalFood()))
  val foodCarriedSorted = foodCarried.sortBy(e => - e._2)

  println(s"1a: Max food carried: ${foodCarriedSorted.take(1).head._2}")
  println(s"2a: Top3 food carried: ${foodCarriedSorted.take(3).map(e => e._2).sum}")

}


