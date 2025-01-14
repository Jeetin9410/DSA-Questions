package DailyLeetCode2025.Jan.Array_and_Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class Day14_Find_the_Prefix_Common_Array_of_Two_Arrays {
    /* Leetcode 2657
You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.



Example 1:

Input: A = [1,3,2,4], B = [3,1,2,4]
Output: [0,2,3,4]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
Example 2:

Input: A = [2,3,1], B = [3,1,2]
Output: [0,1,3]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.


Constraints:

1 <= A.length == B.length == n <= 50
1 <= A[i], B[i] <= n
It is guaranteed that A and B are both a permutation of n integers.

     */
    public static void main(String[] args) {
         // all solutions: https://www.youtube.com/watch?v=hVda-pNPiuA&ab_channel=codestorywithMIK
        // Due to less strict constraints --> O(n^3) will also be accepted ---> but best approach is O(n), followed by O(n^2).

        // O(n^3) : Brute force : solution1()

        // O(n^2) : Better Approach : solution2()
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};

        System.out.println(Arrays.toString(solution3(A,B)));
    }

    public static int[] solution3(int[] A, int[] B) {
        /* Approach :
           A[] is subset b[]  --> A will have all element of B
           Which means every element will surely have frequency of 2.

           for every index --> if put the number of A and B in map or either increase is frequency by one --> if frequency is 2--> increment count

           store count in result

         */
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[n];
        int count = 0;

        for(int i =0; i<n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
            if(map.get(A[i]) == 2) {
                count++;
            }

            map.put(B[i], map.getOrDefault(B[i], 0)+1);
            if(map.get(B[i]) == 2) {
                count++;
            }

            result[i] = count;
        }

        return result;
    }

    public static int[] solution2(int[] A, int[] B) {
        /* Approach Explanation:
        If we look at this line given "A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once"
        it means --> if array is of size n then number will be from 1 to n , and no number will repeat.

        so if we take two boolean array isPresentA and isPresentB --> were we record that number is present than --> true for that number

            boolean[] isPresentA = new boolean[n+1]   --> n+1 cause we will store values on number matching index itself.

        1. for loop -->  i 0 to A.length
                     isPresentA[A[i]] = true;
                     isPresentB[B[i]] = true;

            2. nested loop --> num 1 to n --> and will count
                         if (isPresentA[num] == true && isPresentB[num] ==true){
                             count++
                         }
        3. store count in different array

         */

        int n = A.length;
        boolean[] isPresentA = new boolean[n+1];
        boolean[] isPresentB = new boolean[n+1];
        int[] result = new int[n];

        for(int i = 0; i<n; i++) {
            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;
            int count = 0;
            for(int num = 1; num<=n; num++) {
                if(isPresentA[num] == true && isPresentB[num] == true) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static int[] solution1(int[] A, int[] B) {
        int n = A.length;

        int[] result = new int[n];

        for(int i = 0; i<n; i++) {
            int count = 0;
            for(int j =0; j<=i; j++) {
                for(int k =0; k<= i; k++) {
                    if(A[j] == B[k]) {
                        count++;
                        break;
                    }
                }
            }
            result[i] = count;
        }

        return result;
    }
}
