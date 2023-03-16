package nl.occurro.advent_2022

package object day2 {

  object Choices extends Enumeration {
    type Choice = Value

    val Rock, Paper, Scissors = Value
  }

  import Choices._

  case class Move(x: Choice, y: Choice)
  object Move {
    def applyA(x: String, y: String) = {
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
    def applyB(x: String, y: String, z: String) = {
      // Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock
      def findWinner(x: String): Choice =
        x match {
          case "A" => Paper
          case "B" => Scissors
          case "C" => Rock
        }
      def findLoser(x: String): Choice  =
        x match {
          case "A" => Scissors
          case "B" => Rock
          case "C" => Paper
        }
      def findDraw(x: String): Choice   =
        x match {
          case "A" => Rock
          case "B" => Paper
          case "C" => Scissors
        }

      val a = x match {
        case "A" => Rock
        case "B" => Paper
        case "C" => Scissors
      }
      // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
      val b = (x, y) match {
        case (_, "X") => findLoser(x)
        case (_, "Y") => findDraw(x)
        case (_, "Z") => findWinner(x)
      }
      new Move(a, b)
    }
  }

}
