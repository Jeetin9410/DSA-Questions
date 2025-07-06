package old.Jan.PrefixSum

//link : https://leetcode.com/problems/maximum-score-after-splitting-a-string?envType=daily-question&envId=2025-01-01

fun main() {
    val s = "00"

    /*
    00
    0 0
    1 0
    1
     */

    val count = IntArray(s.length)
    var totalOnes = 0;
    s.forEachIndexed { index, c ->
        if(c == '1') {
            totalOnes++
        }
        count[index] = totalOnes
    }

    var max = 0;

    count.forEachIndexed { index, totalOnesTillNow ->
        if (index < s.length - 1) { // Ensure non-empty right substring
            val zerosInLeft = (index + 1) - totalOnesTillNow
            val onesInRight = totalOnes - totalOnesTillNow
            max = maxOf(max, zerosInLeft + onesInRight)
        }
    }

    println(max)
}