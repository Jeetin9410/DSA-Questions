package AdvanceLevelQuestions.StringPatternMatching

/*

Problem Description
Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.



Problem Constraints
1 ≤ length(A) = length(B) ≤ 105



Input Format
The first argument is a string A.
The second argument is a string B.



Output Format
Return an integer denoting the required answer.

*/

fun main() {

    val A = "1001"
    val B = "0011"

    println(countCyclicShifts(A,B))
}

fun countCyclicShifts(A: String, B: String): Int {
    // Concatenate B with itself
    val B2 = B + B

    // Length of the input strings
    val n = A.length

    // Initialize a count for valid cyclic shifts
    var count = 0

    // Iterate through all possible cyclic shifts
    for (i in 0 until n) {
        // Check if A matches a substring of B2 starting at index i and of length n
        if (B2.substring(i, i + n) == A) {
            count++
        }
    }

    return count
}