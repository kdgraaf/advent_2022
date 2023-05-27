package nl.occurro.advent_2022.day3

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Advent03Spec extends AnyWordSpec with Matchers {

  "Read a file, and calculate prio 3a" in {
    val rucksacks = readFile("./src/test/resources/input03Test.txt")
    val expected  = 157

    val rsSplitted = rucksacks.map(splitString(_))
    val rsCommon   = rsSplitted.map(commonCharacters(_))
    val result     = rsCommon.map(s => priority(s.charAt(0))).sum

    result shouldBe expected
  }

  "Read a file, and calculate prio 3b" in {
    val rucksacks = readFile("./src/test/resources/input03Test.txt")
    val expected  = 70

    val rsGrouped       = rucksacks.grouped(3).toList
    val rsGroupedCommon = rsGrouped.map(commonCharacters(_))
    val result          = rsGroupedCommon.map(s => priority(s.charAt(0))).sum

    result shouldBe expected
  }

}
