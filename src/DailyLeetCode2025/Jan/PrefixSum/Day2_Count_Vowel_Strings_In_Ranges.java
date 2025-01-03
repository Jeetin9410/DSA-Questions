package DailyLeetCode2025.Jan.PrefixSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// link : https://leetcode.com/problems/count-vowel-strings-in-ranges/description/
public class Day2_Count_Vowel_Strings_In_Ranges {
    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = { {0,2}, {1,4}, {1,1} };

        int[] ans = vowelStrings(words,queries);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] Prefix = new int[n + 1];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < n; i++) {
            Prefix[i + 1] = Prefix[i];
            if (vowels.contains(words[i].charAt(0)) &&
                    vowels.contains(words[i].charAt(words[i].length() - 1))) {
                Prefix[i + 1]++;
            }
        }

        int[] ANS = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ANS[i] = Prefix[queries[i][1] + 1] - Prefix[queries[i][0]];
        }
        return ANS;
    }
}
