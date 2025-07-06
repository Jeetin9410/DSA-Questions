package old.Jan.Strings;

import jdk.internal.util.xml.impl.Pair;
import java.util.HashSet;

// Leetcode: 1930

public class Day4_CountPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "aabca";

        /*     Approach

                We are given sub-sequence will of length 3, what the specific reason behind it ?
                Ans: string length 3 will be palindrome,
                     only if first and last character will be same ,  --> middle character can be same or distinct
                     Ex : aba, aaa,  aca etc

                 Intuition:
                 using above idea , lets suppose i have string = "aabca"

                 a _ _ _ _ a --> a with first and last occurrence -->
                 total possible Palindrome will be total number of distinct character in between
                 first and last occurrence of a.
                 i.e --> aaa, aba, aca -- and 3 we have to return

                 Steps:
                 1. We will make ha map of <Character, Pair<Int, Int>> --> every character and its first and last occurrence index.
                 2. Also we will save every character in set
                 3. Now for every character is set,
                   we will run a loop from firstOccurrenceIndex to lastOccurrenceIndex
                   we will find distinct character again using a different HashSet.

                   then size of that hashSet will be our answer for that character.

         */

        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        int cnt = 0;
        for (char x : uniqueChars) {
            int left = s.indexOf(x);
            int right = s.lastIndexOf(x);
            HashSet<Character> middleChars = new HashSet<>();
            if (left != right) {
                for (int i = left + 1; i < right; i++) {
                    middleChars.add(s.charAt(i));
                }
            }
            cnt += middleChars.size();
        }
        System.out.println(cnt);
    }
}
