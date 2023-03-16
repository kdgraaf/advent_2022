package nl.occurro.advent2022

case class Elf(position: Int, food: List[Int]) {
  def totalFood() = {
    this.food.sum
  }
}
