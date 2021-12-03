data class Coordinates(var position: Int, var depth: Int, var aim: Int)

fun main() {
    fun part1(input: List<String>): Int {
        val coords = input.map { Pair(it.substringBefore(' '), it.substringAfter(' ').toInt()) }
            .fold(Coordinates(0, 0, 0)) { coords, it ->
                when (it.first) {
                    "forward" -> coords.position += it.second
                    "down" -> coords.depth += it.second
                    "up" -> coords.depth -= it.second
                }
                coords
            }
        return coords.position * coords.depth
    }

    fun part2(input: List<String>): Int {
        val coords = input.map { Pair(it.substringBefore(' '), it.substringAfter(' ').toInt()) }
            .fold(Coordinates(0, 0, 0)) { coords, it ->
                when (it.first) {
                    "forward" -> {
                        coords.position += it.second
                        coords.depth += coords.aim * it.second
                    }
                    "down" -> coords.aim += it.second
                    "up" -> coords.aim -= it.second
                }
                coords
            }
        return coords.position * coords.depth
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
