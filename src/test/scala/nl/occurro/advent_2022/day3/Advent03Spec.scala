package nl.occurro.advent_2022.day3

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Advent03Spec extends AnyWordSpec with Matchers {

  "splitString should a split a string in two parts" in {
    
    // The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains the items vJrwpWtwJgWr, 
    // while the second compartment contains the items hcsFMMfFFhFp.

    val s = "vJrwpWtwJgWrhcsFMMfFFhFp"
    val expected = List("vJrwpWtwJgWr","hcsFMMfFFhFp")

    splitString(s) shouldBe expected

  }

  "commonCharacters should select the characters that appear in all strings" in {
    val l = List("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","PmmdzqPrVvPwwTWBwg")
    val expected = "r"

    commonCharacters(l) shouldBe expected
  }

  "priority should calculate the correct priority" in {
    val c = 'r'
    val expected = 18

    priority(c) shouldBe expected
  }


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
