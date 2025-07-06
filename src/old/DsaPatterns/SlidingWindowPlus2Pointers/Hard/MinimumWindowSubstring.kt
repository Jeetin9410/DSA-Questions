package old.DsaPatterns.SlidingWindowPlus2Pointers.Hard

/*  76. Minimum Window Substring

    Given two strings s and t of lengths m and n respectively, return the minimum window
   substring of s such that every character in t (including duplicates) is included in the window.
   If there is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.

    Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?



*/


fun main() {

    val s = "ADOBECODEBANC"; val t = "ABC"

    // My Approach
    /*

    1. store t in mutableList of Char.
    2. start = 0, end = 0
    3. while ( e < s.len )
    4. if at index e the char matches any of char in t , start the window by incrementing end++
    5. as soon as all the char in t are matched suppose in substring start to end
    6.store that substring in some variable,
    7. if next time any substring of lesser length than the previous one found , store the new substring.
    8. Base cases : if s.len < t.len return ""

    Code :

     if(s.length < t.length) {
         return ""
     }

     var start = 0
     var end = 0

     val sArr = s.toList()
     var tArr = t.toList().toMutableList()

     var ans = ""

     while(end < s.length) {
        if(tArr.contains(sArr.get(end))) {
            tArr.remove(sArr.get(end))
            if(tArr.size == 0) {
                val temp = s.substring(start, end + 1)
                if(temp.length < ans.length || ans.isEmpty()){
                    ans = temp
                }

                start = end
                tArr = t.toList().toMutableList()
            }
        } else if(tArr.size == t.length) {
            start++
        }
        end++
     }

    return ans


    Worked for 154/268 testcases.

    TestCases didnt worked:
    1. s = "bdab" , t = "ab" , expected = "ab" , found = "bda"

    Reason why bda?: as soon as I popped out all t characters, i am setting
                     start = end + 1 and end++
                     Now think what if I included the last element of t, and after wards any combination might be my correct answer.
                     On similar thought, what if the second character also could have formed a substring till e.

                     so in above approach i need to add this edge case. to try forming string with all the character of t that
                     matches in string s.

    */

    /* Correct Approach:
        1. Initialize Data Structures: We will use two hashmaps:
            a) dictT to store the frequency of each character in t.
            b) windowCounts to store the frequency of each character in the current window of s.

        2. Two Pointers: We will use two pointers, l and r, to represent the window. Both pointers start at the beginning of s.

        3. Expand and Contract the Window: Move the right pointer (r) to expand the window until it contains all characters of t. Then, move the left pointer (l) to find the smallest valid window.

        4. Track the Best Window: Keep track of the smallest window that satisfies the condition.

        Explanation: https://youtu.be/eS6PZLjoaq8?si=HjtM0b6BBiggS8O5
     */

    if (t.length > s.length) println ("")

    val tCharCount = mutableMapOf<Char, Int>()
    for (char in t) {
        tCharCount[char] = tCharCount.getOrDefault(char, 0) + 1
    }

    var left = 0
    var right = 0
    var have = 0
    val need = tCharCount.size
    val windowCharCount = mutableMapOf<Char, Int>()
    var minLength = Int.MAX_VALUE
    var minStart = 0

    while (right < s.length) {
        val rightChar = s[right]
        windowCharCount[rightChar] = windowCharCount.getOrDefault(rightChar, 0) + 1

        if (tCharCount.containsKey(rightChar) && windowCharCount[rightChar] == tCharCount[rightChar]) {
            have++
        }

        while (have == need) {
            // Update the minimum window
            if (right - left + 1 < minLength) {
                minLength = right - left + 1
                minStart = left
            }

            // Try to contract the window from the left
            val leftChar = s[left]
            windowCharCount[leftChar] = windowCharCount[leftChar]!! - 1
            if (tCharCount.containsKey(leftChar) && windowCharCount[leftChar]!! < tCharCount[leftChar]!!) {
                have--
            }
            left++
        }
        right++
    }

    println( if (minLength != Int.MAX_VALUE) s.substring(minStart, minStart + minLength) else "")
}