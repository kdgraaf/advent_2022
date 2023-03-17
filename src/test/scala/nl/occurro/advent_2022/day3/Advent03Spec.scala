package nl.occurro.advent_2022.day3

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Advent03Spec extends AnyWordSpec with Matchers {

  "Read a file, and calculate prio" in {
    val rucksacks = readFile("./src/test/resources/input03Test.txt")
    val expected  = 157

    val r      = rucksacks.map(commonChar(_))
    val result = r.map(priority(_)).sum

    result shouldBe expected
  }

}
