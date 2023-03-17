package nl.occurro.advent_2022.day2

import Choices._


def readFile(filename: String, version: String): List[Move] = {

  val bufferedSource = io.Source.fromFile(filename)
  val lines = (for (line <- bufferedSource.getLines())
    yield line.split(" ") match { case Array(i, j) => (i, j) }).toList

  bufferedSource.close
  lines.map((x, y) => version match {
    case "a" => Move.applyA(x, y)
    case "b" => Move.applyB(x, y, version)
  })
}

def determineScore(move: Move): Int = {

  def determineWinner(move: Move): Option[Choice] = move match {
    // Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock
    case Move(Rock, Scissors) | Move(Scissors, Rock) => Some(Rock)
    case Move(Scissors, Paper) | Move(Paper, Scissors) => Some(Scissors)
    case Move(Paper, Rock) | Move(Rock, Paper) => Some(Paper)
    case Move(i, j) if i == j => None // draw
  }


  val myScore = move._2 match {
    case Choices.Rock => 1
    case Choices.Paper => 2
    case Choices.Scissors => 3
  }

  val winner = determineWinner(move)
  val winnerScore = move match {
    case Move(i, j) if i == j => 3
    case Move(i ,j) if Some(i) == determineWinner(move) => 0
    case Move(i, j) if Some(j) == determineWinner(move) => 6
  }

  myScore + winnerScore
}


object Advent02 extends App {

  val moves = readFile("./src/main/resources/input02.txt", "a")
  println(s"Total score: ${moves.foldLeft(0)((a, i) => a + determineScore(i))}")

  val moves2 = readFile("./src/main/resources/input02.txt", "b")
  println(s"Total score: ${moves2.foldLeft(0)((a, i) => a + determineScore(i))}")
}
