import java.io.File

fun main() {
    println(part1())
    println(part2())
}

private fun part1() = calculateIncreaseCount(readInput())

private fun part2(): Int {
    val measurements = readInput()

    val slidingWindowSize = 3;

    val sums = mutableListOf<Int>()

    for (windowStart in 0..measurements.size - slidingWindowSize) {
        sums.add(measurements.subList(windowStart, windowStart + slidingWindowSize).sum())
    }

    return calculateIncreaseCount(sums)
}

private fun calculateIncreaseCount(measurements: List<Int>): Int {
    var lastMeasurement = Int.MAX_VALUE
    var increasedCount = 0

    measurements.forEach { measurement ->
        if (measurement > lastMeasurement) {
            increasedCount++
        }

        lastMeasurement = measurement
    }

    return increasedCount
}

/**
 * Read the input file and parse the integers
 */
private fun readInput() = File("input/01-1-SonarSweep.txt")
    .readLines()
    .map { it.toInt() }
