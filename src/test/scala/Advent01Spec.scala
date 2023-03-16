package nl.occurro.advent2022

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Advent01Spec extends AnyWordSpec with Matchers {

  "Read a file with elves" in {
    val elfs = readFile("./src/test/resources/input01Test.txt")
    val expected: List[Elf] = List(
      Elf(1, List(1000, 2000, 3000)),
      Elf(2, List(4000)),
      Elf(3, List(5000, 6000)),
      Elf(4, List(7000, 8000, 9000)),
      Elf(5, List(10000))
    )
    
    elfs shouldBe expected
  }

  "Calculate the amount of food carried by first elf" in {
    val elfs = readFile("./src/test/resources/input01Test.txt")
    val expected = 6000

    elfs.head.totalFood() shouldBe expected
  }
}

