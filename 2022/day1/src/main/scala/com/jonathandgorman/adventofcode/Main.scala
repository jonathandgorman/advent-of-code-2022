package com.jonathandgorman.adventofcode

import scala.io.Source

object Main extends App {

  private val input = Source.fromResource("input.txt").getLines().toList

  private val caloriesPerElf = input.foldLeft(List.empty[List[Int]]) {
    case (acc, line) if line.isEmpty => acc :+ List.empty
    case (acc, line) if acc.nonEmpty => acc.init :+ (acc.last :+ line.toInt)
    case (acc, line) => acc :+ List(line.toInt)
  }.map(l => l.sum)

  private val mostCalories = caloriesPerElf.max
  println(s"The elf with the most calories is carrying: $mostCalories calories")

  private val topThreeElvesCalories = caloriesPerElf.sortWith(_ > _).take(3).sum
  println(s"The sum of the calories of the three elves carrying the most calories is: $topThreeElvesCalories calories")
}
