package nl.occurro.advent_2022.day1

case class Elf(position: Int, food: List[Int]) {
  def totalFood() =
    this.food.sum
}
