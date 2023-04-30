package AdvanceLevelQuestions.TwoPointers;

import java.util.*;
public class PairsWithGivenDifference {
    /*
Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y),
where x and y are both numbers in the array and their absolute difference is B.

1 <= N <= 10^4

0 <= A[i], B <= 10^5


Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0
     */

    public static void main(String[] args) {
            int[] A = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
            int B = 3;

            int n = A.length;
            int count = 0;

            /// Optimal approach
        /* Sorting the array first. Why? will get to next
        we will take two pointers i  and j
        at starting i =0;  j=i+1;

        we will move j and check for two conditions
        1) (A[j] - A[i]) < B  then move j++
        2) (A[j] - A[i]) > B  then move i++

         */

        Arrays.sort(A);
        int i =0;
        int j=1;
        while (i<A.length && j<A.length){
                if((A[j] - A[i]) == B){
                    count++;
                   // break;
                } else if((A[j] - A[i])<B){
                    j++;
                }else{
                    i++;
                }

        }

        System.out.println(count);
    }

}
