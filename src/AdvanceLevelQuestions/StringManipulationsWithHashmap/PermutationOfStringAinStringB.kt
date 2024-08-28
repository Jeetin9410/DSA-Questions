package AdvanceLevelQuestions.StringManipulationsWithHashmap
/*

Problem Description
You are given two strings, A and B, of size N and M, respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105



Input Format
Given two arguments, A and B of type String.



Output Format
Return a single integer, i.e., number of permutations of A present in B as a substring.



Example Input
Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output
Output 1:

 5
Output 2:

 2


Example Explanation
Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa


*/
fun main() {
    val A = "abc"
    val B = "abcbacabc"

    println(solve(A,B))
}

fun solve(A: String, B: String): Int {

    val charCount = mutableMapOf<Char, Int>()

    for(char in A) {
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }

    var start = 0
    var end = 0
    val n = B.length
    val need = A.length
    var count = 0
    val windowCount = mutableMapOf<Char, Int>()

    for (end in 0 until B.length) {
        val endChar = B[end]
        windowCount[endChar] = windowCount.getOrDefault(endChar, 0) + 1

        // If window size exceeds, slide the window
        if (end - start + 1 > A.length) {
            val startChar = B[start]
            windowCount[startChar] = windowCount[startChar]!! - 1
            if (windowCount[startChar] == 0) {
                windowCount.remove(startChar)
            }
            start++
        }

        // Check if the current window matches the required character counts
        if (windowCount == charCount) {
            count++
        }
    }

    return count
}