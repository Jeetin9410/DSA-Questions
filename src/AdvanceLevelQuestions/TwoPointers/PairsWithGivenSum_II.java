package AdvanceLevelQuestions.TwoPointers;

import java.util.*;
public class PairsWithGivenSum_II {
    /*
    Given a sorted array of integers (not necessarily distinct) A and an integer B,
     find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

     Since the number of such pairs can be very large, return number of such pairs modulo (10^9 + 7).

     Problem Constraints
        1 <= |A| <= 100000

        1 <= A[i] <= 10^9

        1 <= B <= 10^9



        Input Format
        The first argument given is the integer array A.

        The second argument given is integer B.



        Output Format
        Return the number of pairs for which sum is equal to B modulo (10^9+7).

Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:


A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.
     */
    public static void main(String[] args) {
        int[] A = {1,1,1};
        int B = 2;

        /* Approach :
        This time we are taking hashmap to store the number and its no of occurence.
        How that will work?
        /// This  number of occurence is : no of occurence before i th index of that number, it do not include
            current i th number while calculating count, cause it is provided, i!=j
        i=0,   map = [1,0]          count += map.get(1) ==> count += 0; == 0
        i=1,   map = [1,1]          count += map.get(1) ==> count += 1; == 1
        i=2,   map = [1,2]          count += map.get()  ==> count += 2; == 3

        Final ans = 3
         */

        int n = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();  // number, its no of occurrence
        int count = 0;
        for(int i=0;i<n;i++){
            int diff = B - A[i];
            if(map.containsKey(diff)){
                count += map.get(diff);

            }
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }

        System.out.println(count);
    }
}
