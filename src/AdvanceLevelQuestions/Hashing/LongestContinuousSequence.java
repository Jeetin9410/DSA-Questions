package AdvanceLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestContinuousSequence {
    /*
        Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from array A.

1 <= N <= 10^6

-10^6 <= A[i] <= 10^6

Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input
Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2].

     */
    public static void main(String[] args) {
        int[] A = {97,86,67,19,107,9,8,49,23,46,-4,22,72,4,57,111,20,52,99,2,113,81,7,5,21,0,47,54,76,117,-2,102,34,12,103,69,36,51,105,-3,33,91,37,11,48,106,109,45,58,77,104,60,75,90,3,62,16,119,85,63,87,43,74,13,95,94,56,28,55,66,92,79,27,42,70};
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int count = 1;
        for(int i =1;i<A.length;i++){
            if(A[i]-A[i-1] == 1){
                count++;
            }
        }

        System.out.println(count);

    }
}
