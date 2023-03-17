package nl.occurro.advent_2022.day3


def readFile(filename: String): List[(String, String)] = {

  val bufferedSource = io.Source.fromFile(filename)
  val lines = (for (line <- bufferedSource.getLines())
    yield line.splitAt(line.length / 2)).toList

  bufferedSource.close

  lines
}

def commonChar(rucksack: (String, String)): Char = {
  (rucksack._1 intersect rucksack._2).charAt(0)
}

def priority(c: Char): Int = {
   c.toInt match {
    case x if 97 to 122 contains x => c.toInt - 96
    case x if 65 to 90 contains x => c.toInt - 38
  }
}

object Advent03 extends App {
  val rucksacks = readFile("./src/main/resources/input03.txt")
  val r      = rucksacks.map(commonChar(_))
  val result = r.map(priority(_)).sum

  println(result)

}
