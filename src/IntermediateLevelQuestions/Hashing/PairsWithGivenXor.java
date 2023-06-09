package IntermediateLevelQuestions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PairsWithGivenXor {
    /*
    Given an integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be the same and should be counted once.

1 <= N <= 10^5

1 <= A[i], B <= 10^7

Example Input
Input 1:

 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:

 A = [3, 6, 8, 10, 15, 50]
 B = 5


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 (10 ^ 15) = 5
Explanation 2:

 (3 ^ 6) = 5 and (10 ^ 15) = 5


     */

    public static void main(String[] args) {
        int[] A = {3, 6, 8, 10, 15, 50};
        int B = 5;

        /*  Approach:
        Step 1 : we need to take care about unique pairs as asked in question ==> require HashSet for this.
        Step 2 : Logic ==>
                 x xor y = z (given)
                 x (given)
                 to find pair we need to find y.

                 x ^ ( z) = y
         step 3 : to find pair we need to check if y exist in  Hashset
                  if that exist then we will remove x from set,so that only unique pairs are counted.
         */

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<A.length;i++){
            set.add(A[i]);
        }

        ArrayList<Integer> unique = new ArrayList<>(set);
        int count = 0;
        for (int i=0;i<unique.size();i++){
            int x = unique.get(i);
            int y = x ^ (B);
            if(set.contains(y)){
                count++;
                set.remove(x);
            }
        }

        System.out.println(count);


        ///////////////////   The above code can be modified to this  ///////////////////////////

        HashSet <Integer> hs = new HashSet<>();
        int count1 =0;
        for(int i=0;i<A.length;i++){
            //a^b =c;   a^b^a = c^a ;  (a^a = 0, 0^b = b) ;  b = c^a; (c^a = a^c) => b = a^c
            if(hs.contains(A[i]^B)){
                count1++;
            }
            hs.add(A[i]);
        }
        System.out.println(count1);

    }

}
