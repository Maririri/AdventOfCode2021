fun main() {
    fun part1(input: List<String>): Int {
        val half = input.size / 2
        var gamma = ""
        var epsilon = ""
        val indices = input[0].indices
        for (i in indices) {
            if (input.count { it[i] == '0' } > half) {
                gamma += "0"
                epsilon += "1"
            } else {
                gamma += "1"
                epsilon += "0"
            }
        }
        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }

    fun part2(input: List<String>): Int {
        val indices = input[0].indices
        var oxyGen: List<String> = input
        var co2: List<String> = input
        for (i in indices) {
            val half1 = oxyGen.size / 2
            val bitMax = if (oxyGen.count { it[i] == '0' } > half1) {
                '0'
            } else {
                '1'
            }
            oxyGen = oxyGen.filter { it[i] == bitMax }
            if (oxyGen.size == 1)
                break
        }
        for (i in indices) {
            val half2 = co2.size / 2
            val bitMin = if (co2.count { it[i] == '0' } <= half2) {
                '0'
            } else {
                '1'
            }
            co2 = co2.filter { it[i] == bitMin }
            if (co2.size == 1)
                break
        }
        println(oxyGen)
        println(co2)
        return Integer.parseInt(oxyGen[0], 2) * Integer.parseInt(co2[0], 2)
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
