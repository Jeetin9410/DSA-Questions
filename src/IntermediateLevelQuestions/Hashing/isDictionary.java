package IntermediateLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class isDictionary {
    /*
    Surprisingly, in an alien language, they also use English lowercase letters,
     but possibly in a different order. The order of the alphabet is some permutation of
     lowercase letters.

     Given an array of words A of size N written in the alien language,
     and the order of the alphabet denoted by string B of size 26, return 1
     if and only if the given words are sorted lexicographically in this alien language else, return 0.

    1 <= N, length of each word <= 105

    Sum of the length of all words <= 2 * 106

Example Input
Input 1:

 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Input 2:

 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The order shown in string B is: h < s < i for the given words. So return 1.
Explanation 2:

 "none" should be present after "no". Return 0.

     */

    public static void main(String[] args) {
        String[] A = {"fine", "none", "no"};
        String B = "qwertyuiopasdfghjklzxcvbnm";

        /* Intuition based :
           step1 : first i will make a map to provide
                   number to alphabet order given as String B.

           step 2: for every word in count sum according to every character in word and store in
                   an array.

          step 3 : if that sum array is strictly increasing then given words are lexicographically sorted.


         */


        /*  Above approach modified :

         step 1:   First we will do  map of characters with number

         step 2:  We will find the shortest length among all elements of given word array

          then nested for loop

          for(i--> 0 to A.length()-1){
                for(j --> 0 to minLen){
                 now compare A[i] and A[i+1] using Hashmap.
                We will take care of 3 cases here
                if (A[i].charAt(j) < A[i+1].charAt(j)) ===> this means i th word is already sorted and need not to compare
                                                             rest of characters.
                if(A[i].charAt(j) == A[i+1].charAt(j)) ===> this condition means that upto minLen index all character are same
                                                            But WHAT IF ? one word has some more character in it after that
                                                            matching pattern.
                             Ex : none , no
                                  so here, till j==minLen-1 everything is matching BUT this is not sorted.
                       so we will also check if len(A[i]) > len(A[i+1]) then return 0; else it is fine.
                if( A[i].charAt(j) > A[i+1].charAt(j) ) ===> return 0 not sorted.
          }

         */

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 1;i<=B.length();i++){
            map.put(B.charAt(i-1),i);
        }

        System.out.println(Arrays.asList(map));

        int minLen = A[0].length();
        for(int i=1;i<A.length;i++){
            minLen = Math.min(minLen,A[i].length());
        }

        //System.out.println(minLen);

       // System.out.println(Arrays.asList(map));

        for(int i=0;i<A.length-1;i++) {
            for(int j=0;j<minLen;j++){
                if( map.get(A[i].charAt(j)) > map.get(A[i+1].charAt(j))){
                  //  System.out.println(0);
                    return;
                }else if(map.get(A[i].charAt(j)) == map.get(A[i+1].charAt(j))){
                    if(j==minLen-1 && A[i].length() > A[i+1].length() ){
                    //    System.out.println(0);
                        return;
                    }
                } else if (map.get(A[i].charAt(j)) < map.get(A[i+1].charAt(j))) {
                    break;
                }
            }
        }

        System.out.println(1);

        /*
        none  no

         */
    }

}
