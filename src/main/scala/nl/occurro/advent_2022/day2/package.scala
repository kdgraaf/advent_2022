package nl.occurro.advent_2022

package object day2 {

  object Choices extends Enumeration {
    type Choice = Value

    val Rock, Paper, Scissors = Value
  }

  import Choices._

  case class Move(x: Choice, y: Choice)
  object Move {
    def apply(x: String, y: String) = {
      val a = x match {
        case "A" => Rock
        case "B" => Paper
        case "C" => Scissors
      }
      val b = y match {
        case "X" => Rock
        case "Y" => Paper
        case "Z" => Scissors
      }
      new Move(a, b)
    }
  }

}
