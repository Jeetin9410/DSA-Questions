package old.AdvanceLevelQuestions.TwoPointers;

import java.util.*;
public class CountOfPairsWithGivenSum {
    /*           SIMILAR TO ==> Two Sum problem


Given a sorted array of distinct integers A and an integer B,
find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.


Input Format

The first argument given is the integer array A.
The second argument given is integer B.
Output Format

Return the number of pairs for which sum is equal to B.
Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
    B = 5
Output 1:
    2

Input 2:
    A = [5, 10, 20, 100, 105]
    B = 110
Output 2:
    2
     */
    public static void main(String[] args) {

        int[] A = {5, 10, 20, 100, 105};
        int B = 110;

        // ans = [2,3],[5]

        /*  Using two pointer approach
            start = 0;
            end = 0; at first

            we will increment end pointer till n to find sum

            while doing this,
            we will check if sum > B
            if that happens then we will increment start to one position, now even if sum > B then
            we will do this using while loop




         */
        int n = A.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while(end<=n){
            while (sum > B && start < end -1){
                sum = sum - A[start];
                start++;
            }
            if(sum == B){
                count++;
            }
            if(end < n){
                sum += A[end];

            }

            end++;
        }
        System.out.println(count);
    }
}
