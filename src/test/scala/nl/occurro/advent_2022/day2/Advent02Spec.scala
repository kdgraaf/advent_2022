package nl.occurro.advent_2022.day2

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Advent02Spec extends AnyWordSpec with Matchers {

  "2a: Read a file with moves" in {
    val moves    = readFile("./src/test/resources/input02Test.txt", "a")
    val expected = 15

    moves.foldLeft(0)((a, i) => a + determineScore(i)) shouldBe expected
  }
  "2b: Read a file with moves" in {
    val moves    = readFile("./src/test/resources/input02Test.txt", "b")
    val expected = 12

    moves.foldLeft(0)((a, i) => a + determineScore(i)) shouldBe expected
  }

}
