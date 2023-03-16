package nl.occurro.advent_2022.day2

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Advent02Spec extends AnyWordSpec with Matchers {

  "Read a file with moves" in {
    val moves    = readFile("./src/test/resources/input02Test.txt")
    val expected = 15

    moves.foldLeft(0)((a, i) => a + determineScore(i)) shouldBe expected
  }

}
