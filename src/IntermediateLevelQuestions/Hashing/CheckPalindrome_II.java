package IntermediateLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CheckPalindrome_II {
    /*
    Given a string A consisting of lowercase characters.

    Check if characters of the given string can be rearranged to form a palindrome.

    Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

    1 <= |A| <= 10^5

    Example Input
Input 1:

 A = "abcde"
Input 2:

 A = "abbaee"


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No possible rearrangement to make the string palindrome.
Explanation 2:

 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.

     */

    public static void main(String[] args) {
        String A = "vnpbeutxfqxriiajoejjmtjcx";

        // Intuition

        /*
            for even length string : every character will occur in multiple of 2.,
            for odd length string : one character willoccur once, and rest will occur in multiple of 2
          odd instance count should be less then 1, for a string to be possible palindrome

         */

        int n = A.length();
        System.out.println(n);
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = A.toCharArray();
        boolean status = false;

        for(int i =0;i< arr.length;i++){

            map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        }

//        System.out.println(Arrays.asList(map));


        int count = 0;
        for(Character ch : map.keySet())
        {
            if(map.get(ch)%2!=0){   // odd count
                count++;
            }
        }

        if(count > 1){
          //  System.out.println(false);
            System.out.println(0);
        }else {
            System.out.println(1);
        }



    }
}
