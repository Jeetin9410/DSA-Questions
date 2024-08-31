package AdvanceLevelQuestions.StringPatternMatching
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

*/
fun main() {
    /*
    This question is asking if a given string s can become a palindrome by removing at most one character. In contrast to the previous problem (where you were allowed to change exactly one character), here you are allowed to remove at most one character.

Key Differences:
Operation Allowed:

Previous Problem: You could change exactly one character to make the string a palindrome.
This Problem: You can delete at most one character to make the string a palindrome.
Goal:

Previous Problem: The goal was to determine if the string could become a palindrome by modifying one character.
This Problem: The goal is to determine if the string can become a palindrome by deleting one character (or no characters at all).
Approach to Solve This Problem:
To determine if a given string can become a palindrome by removing at most one character, follow these steps:

Two Pointers Technique: Use two pointers, left and right, initialized at the start and end of the string, respectively.
Compare Characters:
Move both pointers toward the center while comparing characters.
If a mismatch is found, check whether removing the left or the right character would result in a palindrome.
Check After Removal:
After finding a mismatch, check the substrings that result from removing either the left character (s[left + 1...right]) or the right character (s[left...right - 1]).
If either of these substrings is a palindrome, return true.
Final Check:
If no mismatch is found while moving the pointers, the string is already a palindrome, and the answer is true.
     */


    val s = "abca"
    println(validPalindrome(s))
}

fun validPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    while (left < right) {
        if (s[left] != s[right]) {
            // Check if either of the substrings s[left+1...right] or s[left...right-1] is a palindrome
            return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)
        }
        left++
        right--
    }

    return true
}

fun isPalindrome(s: String, left: Int, right: Int): Boolean {
    var l = left
    var r = right
    while (l < r) {
        if (s[l] != s[r]) return false
        l++
        r--
    }
    return true
}