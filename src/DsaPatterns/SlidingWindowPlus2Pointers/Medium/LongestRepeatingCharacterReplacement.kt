package DsaPatterns.SlidingWindowPlus2Pointers.Medium

import kotlin.math.max

/*  424. Longest Repeating Character Replacement

You are given a string s and an integer k.

You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*/

fun main() {

    /*  Explanation:

        For a given string S, all characters will be uppercase. Now to find the longest repeating character, even after
        have k replacements.

        We will have two pointers l and r ,==> windowLen
        right will move forward until ( windowLen - count of largest occurring character) <= k
        the above equation represents the number of replacements we can do to achieve
        "Longest Repeating character"



    */

    val s = "AABABBA"
    val k = 1

    val count = IntArray(26)
    var maxCount = 0
    var maxLength = 0
    var start = 0

    for (end in s.indices) {
        val endCharIndex = s[end] - 'A' // this will give the position of alphabet
        count[endCharIndex]++          // store its count
        maxCount = maxOf(maxCount, count[endCharIndex]) // highest count till now is stored here

        while (end - start + 1 - maxCount > k) {   // as soon as found out replaceable character are now greater than k we will shift
                                                   //  start pointer
            val startCharIndex = s[start] - 'A'
            count[startCharIndex]--
            start++
        }

        maxLength = maxOf(maxLength, end - start + 1)
    }

    println("Answer: ${maxLength}")

    /*

    Explanation
1. Count Array:
    We use an integer array count of size 26 to keep track of the frequency of each character within the current window.
    Each index corresponds to a character from 'A' to 'Z'.

2. MaxCount: This variable keeps track of the count of the most frequent character in the current window.

3. Sliding Window: We use a window defined by two pointers, start and end, where end expands to include new characters and
                    start contracts when the condition for allowable replacements is violated.

4. Window Validation: At any point, the window size minus the most frequent character count should be less than or equal to k
                        (i.e., end - start + 1 - maxCount <= k).
                        This condition ensures that we can make the window valid by replacing at most k characters.

5. Updating Pointers: If the condition is violated, we shrink the window from the left by incrementing start
                      and decreasing the count of the character at the start index.

6. Maximum Length Calculation: We continuously update the maxLength with the maximum size of valid windows encountered.

7. This solution efficiently finds the longest substring possible by allowing up to k replacements, utilizing the sliding window technique to maintain a linear time complexity of O(n).

    */


}