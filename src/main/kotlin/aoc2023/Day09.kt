package aoc2023

fun main(args: Array<String>) {

    val inputData = Common.getData(9, args[0])


    val inputData1 = "0 3 6 9 12 15\n" +
            "1 3 6 10 15 21\n" +
            "10 13 16 21 30 45"
  // find the next element to the series
    Day09.Game_01(inputData1.trim().split("\n"),false)
    Day09.Game_02(inputData1.trim().split("\n"),false)

    // find the previous element to the series
    Day09.Game_01(inputData.trim().split("\n"),false)
    Day09.Game_02(inputData.trim().split("\n"),false)
}

class Day09 {
    companion object {

        fun Game_02(inputLines: List<String>, debug: Boolean) {
        var sum: Long = 0
        inputLines.forEach { it ->
            val numbers = it.split(" ").map { it.toLong() }
            for (element in numbers) {
                if (debug) print(" " + (element))
            }
            if (debug) println()
            val x = moveUp(numbers)
            if (debug) println(x)
            sum += numbers.first() + x * -1
            if (debug) println(sum.toString() + " - " + numbers.first() + " " + x.toString())
        }
            println(sum)
    }

    fun moveUp(numbers: List<Long>): Long {
        var numbers2 = mutableListOf<Long>()
        var max: Long = 0
        for (i in 1 until numbers.size) {
            numbers2.add(numbers.get(i) - numbers.get(i - 1))
            print(" " + (numbers.get(i) - numbers.get(i - 1)))
        }
        println()
        if (numbers2.min() != 0L || numbers2.max() != 0L) {
            max = moveUp(numbers2)
        }
        // println(max.toString() + " <---")
        return (numbers2.first() + max * -1)
    }

    fun Game_01(inputLines: List<String>, debug: Boolean) {
        var sum: Long = 0
        inputLines.forEach { it ->
            val numbers = it.split(" ").map { it.toLong() }
            for (i in 0..numbers.size - 1) {
                if (debug) print(" " + (numbers.get(i)))

            }
            if (debug) println()
            val x = moveDown(numbers)
            if (debug) println(x)
            sum += numbers.last() + x
            println(sum.toString() + " - " + numbers.last() + " " + x.toString())
        }
        println(sum)
    }


        // find the last row where the difference is the same in a recursive function
    fun moveDown(numbers: List<Long>): Long {
        var numbers2 = mutableListOf<Long>()
        var max: Long = 0
        for (i in 1..numbers.size - 1) {
            numbers2.add(numbers.get(i) - numbers.get(i - 1))
            print(" " + (numbers.get(i) - numbers.get(i - 1)))
        }
        println()
        if (numbers2.min() != 0L || numbers2.max() != 0L) {
            max = moveDown(numbers2)
        }
        // println(max.toString() + " <---")
        return (numbers2.last() + max)
    }
}
}