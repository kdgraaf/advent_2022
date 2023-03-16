package nl.occurro.advent2022

def readFile(filename: String): List[(String, String)] = {

  val bufferedSource = io.Source.fromFile(filename)
  val tuples = for (line <- bufferedSource.getLines()) yield line.split(" ") match { case Array(i, j) => (i, j) }

  bufferedSource.close
  tuples.toList
}


object Advent02 extends App {

}
