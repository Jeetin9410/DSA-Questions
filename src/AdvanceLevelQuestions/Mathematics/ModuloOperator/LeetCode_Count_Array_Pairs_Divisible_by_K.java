package AdvanceLevelQuestions.Mathematics.ModuloOperator;

import java.util.Arrays;

public class LeetCode_Count_Array_Pairs_Divisible_by_K {
    /*
        Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) such that:
        0 <= i < j <= n - 1 and
        nums[i] * nums[j] is divisible by k.


     Example 1:

        Input: nums = [1,2,3,4,5], k = 2
        Output: 7
        Explanation:
        The 7 pairs of indices whose corresponding products are divisible by 2 are
        (0, 1), (0, 3), (1, 2), (1, 3), (1, 4), (2, 3), and (3, 4).
        Their products are 2, 4, 6, 8, 10, 12, and 20 respectively.
        Other pairs such as (0, 2) and (2, 4) have products 3 and 15 respectively, which are not divisible by 2.
        Example 2:

        Input: nums = [1,2,3,4], k = 5
        Output: 0
        Explanation: There does not exist any pair of indices whose corresponding product is divisible by 5.


        Constraints:

        1 <= nums.length <= 10^5
        1 <= nums[i], k <= 10^5
     */

    public static void main(String[] args) {
        int[] nums = {8,10,2,5,9,6,3,8,2};
        int k = 6;

        int[] count = new int[k];

        Arrays.fill(count,0);

        for(int i =0;i<nums.length;i++){
            int rem = nums[i]%k;
            count[rem]++;
        }

        int pairCount = 0;

        // pair within reminder 0
        int a = count[0];

        pairCount += (a*(a-1))/2;

        //pair using all elements with reminder 0 and other.

        pairCount += count[0]*(nums.length - count[0]);

        System.out.println(pairCount);
     }
}
