package IntermediateLevelQuestions.Hashing.SubArrayWithGivenSumAllVariations;

import java.util.Arrays;
import java.util.HashMap;

public class NoOfSubArrayWithGivenSum { /// here we have to find total no of subarray with sum given.
    //////////// This is hashing approach //////////////////

    /* The solution below , also handle negative cases.
     */


    /*
    Given an array of positive integers A and an integer B,
    find and return first continuous subarray which adds to B.

    If the answer does not exist return an array with a single element "-1".

    First sub-array means the sub-array for which starting index in minimum.

    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9
    1 <= B <= 10^9

    Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1: [2, 3]
Output 2: -1

     */
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int B = 5;

       // Brute force appraoch :
        /* find ps array
         Using two nested loops (i and j)
           keep finding the sum between i and j using ps
           if(sum == givenSum) then count;
         */

        //Using Hashing
         /*         New Concept

         ==> we will take hashmap , which will record  the sum and its index
              map <sum, and its index>
         ==> logic :
            using for loop ,we will keep finding sum
              sum += A[i]


         */

    }
}
