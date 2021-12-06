import java.io.File

fun main() {
    println(part1())
    println(part2())
}

private fun part1(): Int {
    val readings = readInput()

    var gammaRate = ""
    var epsilonRate = ""

    repeat(readings[0].size) { index ->
        val onesForIndex = readings.sumOnesForIndex(index)
        val moreOnesThanZeroes = onesForIndex >= readings.size - onesForIndex
        gammaRate += if (moreOnesThanZeroes) "1" else "0"
        epsilonRate += if (moreOnesThanZeroes) "0" else "1"
    }

    return gammaRate.toInt(2) * epsilonRate.toInt(2)
}

private fun part2(): Int {
    val oxygenGeneratorRating = findRatingAsBitString('1', '0')
    val scrubberRating = findRatingAsBitString('0', '1')
    return oxygenGeneratorRating.toInt(2) * scrubberRating.toInt(2)
}

private fun findRatingAsBitString(moreOnesChar: Char, moreZeroesChar: Char): String {
    var oxygenRatings = readInput()

    for (index in 0..oxygenRatings[0].size) {
        val onesForIndex = oxygenRatings.sumOnesForIndex(index)
        val moreOnesThanZeroes = onesForIndex >= oxygenRatings.size - onesForIndex
        oxygenRatings = oxygenRatings.filter {
            it[index] == if (moreOnesThanZeroes) moreOnesChar else moreZeroesChar
        }

        if (oxygenRatings.size == 1) {
            break
        }
    }

    return oxygenRatings[0].joinToString("")
}

private fun List<CharArray>.sumOnesForIndex(index: Int) = count { it[index] == '1' }

private fun readInput() = File("input/03-1-BinaryDiagnostic.txt")
    .readLines()
    .map { it.toCharArray() }
