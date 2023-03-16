package nl.occurro.advent2022

import Elf._

def readFile(filename: String): List[Elf] = {

  def splitBy[A](sep: A, seq: List[A]): List[List[A]] = {
    @annotation.tailrec
    def rec(
             xs: List[A],
             revAcc: List[List[A]]
           ): List[List[A]] =
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
    case (list, index) => Elf(index, list.map(s => s.toInt))
  }
}

object Advent01 extends App {

  val elfs = readFile("./src/main/resources/input01.txt")
  elfs.foreach((elf) => println(s"elf: ${elf.position}, ${elf.food}"))

  println(s"Maximum food carried: ${elfs.map(e => e.totalFood()).max}")

}
