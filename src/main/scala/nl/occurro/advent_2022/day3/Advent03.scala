package nl.occurro.advent_2022.day3

def readFile(filename: String): List[String] = {

  val bufferedSource = io.Source.fromFile(filename)
  val lines          =
    (for (line <- bufferedSource.getLines()) yield line).toList
  bufferedSource.close

  lines
}

def splitString(s: String): List[String] = {
  val t = s.splitAt(s.length / 2)
  List(t._1, t._2)
}

def commonCharacters(strings: List[String]): String = {
  if (strings.isEmpty) {
    ""
  } else {
    strings
      .reduce((s1, s2) => s1.intersect(s2))
  }
}

def priority(c: Char): Int = {
  c.toInt match {
    case x if 97 to 122 contains x => c.toInt - 96
    case x if 65 to 90 contains x  => c.toInt - 38
  }
}

object Advent03 extends App {
  val rucksacks = readFile("./src/main/resources/input03.txt")

  val rsSplitted = rucksacks.map(splitString(_))
  val rsCommon   = rsSplitted.map(commonCharacters(_))
  val result3a   = rsCommon.map(s => priority(s.charAt(0))).sum

  println(s"Answer to 3a: $result3a")

  val rsGrouped       = rucksacks.grouped(3).toList
  val rsGroupedCommon = rsGrouped.map(commonCharacters(_))
  val result3b        = rsGroupedCommon.map(s => priority(s.charAt(0))).sum

  println(s"Answer to 3b: $result3b")

}
