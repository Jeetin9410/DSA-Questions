package old.AdvanceLevelQuestions.StringPatternMatching
/*       Scaler question  [Good question]

Problem Description
Groot has a profound love for palindrome which is why he keeps fooling around with strings.
A palindrome string is one that reads the same backward as well as forward.

Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.



Problem Constraints
1 <= N <= 105



Input Format
The first and only argument is a string A.



Output Format
Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character. Else, it should return the string NO.



Example Input
Input 1:

 A = "abbba"
Input 2:

 A = "adaddb"


Example Output
Output 1:

 "YES"
Output 2:

 "NO"


Example Explanation
Explanation 1:

 We can change the character at index 3(1-based) to any other character. The string will be palindromic.
Explanation 2:

 To make the string palindromic we need to change 2 characters.


*/
fun main() {
    val s = "abbba"
    /* Approach

    Count Mismatches: Traverse the string and count the number of mismatched characters between the left and right halves
    of the string.

    Check Conditions:
    1. If there is exactly one mismatch, then it is possible to change one character and make the string a palindrome.
    2. If there are zero mismatches, we must check if the string has an odd length. In this case, we can change the middle character to make the string different but still a palindrome.
    3. For more than one mismatch, it is not possible to make the string a palindrome by changing exactly one character.

    */

    println(solve(s))

}

fun solve(A: String): String {

    var mismatchCount = 0
    val n = A.length

    for (i in 0 until n / 2) {
        if (A[i] != A[n - i - 1]) {
            mismatchCount++
        }
    }


    // If there is exactly one mismatch, or zero mismatches and the string length is odd, return "YES".
    if (mismatchCount == 1 || (mismatchCount == 0 && n % 2 != 0)) {
        return "YES"
    }

    // Otherwise, return "NO".
    return "NO"
}