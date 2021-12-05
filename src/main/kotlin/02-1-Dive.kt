import java.io.File

fun main() {
    println(part1())
    println(part2())
}

private fun part1(): Int {
    val input = readInput()

    var horizontal = 0
    var vertical = 0

    input.forEach {
        when (it.direction) {
            Direction.UP -> vertical -= it.distance
            Direction.DOWN -> vertical += it.distance
            Direction.FORWARD -> horizontal += it.distance
        }
    }

    return horizontal * vertical
}

private fun part2(): Int {
    val input = readInput()

    var horizontal = 0
    var vertical = 0
    var aim = 0

    input.forEach {
        when (it.direction) {
            Direction.UP -> aim -= it.distance
            Direction.DOWN -> aim += it.distance
            Direction.FORWARD -> {
                horizontal += it.distance
                vertical += it.distance * aim
            }
        }
    }

    return horizontal * vertical
}

private enum class Direction {
    UP, DOWN, FORWARD
}

private data class Command(val direction: Direction, val distance: Int)

private fun toCommand(s: String): Command {
    val (dir, distance) = s.split(" ")
    return Command(Direction.valueOf(dir.uppercase()), distance.toInt())
}

private fun readInput() = File("input/02-1-Dive.txt")
    .readLines()
    .map { toCommand(it) }
