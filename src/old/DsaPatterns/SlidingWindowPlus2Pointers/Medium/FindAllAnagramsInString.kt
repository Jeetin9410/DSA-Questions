package old.DsaPatterns.SlidingWindowPlus2Pointers.Medium

/*

Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.


*/
fun main() {
    val s ="cbaebabacd"; val p = "abc"

    val pArr = IntArray(26) { 0 }
    p.forEach { pArr[it - 'a']++ }
    val sArr = IntArray(26) { 0 }
    val result = mutableListOf<Int>()
    var left = 0

    for(right in s.indices) {
        sArr[s[right] - 'a']++

        if(right > p.length - 1) {
            sArr[s[left] - 'a']--
            left++
        }

        if(sArr contentEquals pArr) result.add(left)
    }

    println(result)

    /* Method 2:

    val result = mutableListOf<Int>()

    // Edge case: if the length of p is greater than s, return empty list
    if (p.length > s.length) return result

    // Array to store character frequencies of p and the current window in s
    val pCount = IntArray(26)
    val windowCount = IntArray(26)

    // Fill the frequency array for string p
    for (char in p) {
        pCount[char - 'a']++
    }

    // Initialize the first window
    for (i in 0 until p.length) {
        windowCount[s[i] - 'a']++
    }

    // Check if the initial window is an anagram
    if (windowCount.contentEquals(pCount)) {
        result.add(0)
    }

    // Slide the window across s
    for (i in p.length until s.length) {
        // Add the new character to the window
        windowCount[s[i] - 'a']++

        // Remove the character that's sliding out of the window
        windowCount[s[i - p.length] - 'a']--

        // Compare the current window's character count with p's character count
        if (windowCount.contentEquals(pCount)) {
            result.add(i - p.length + 1)
        }
    }

    return result

    */

}