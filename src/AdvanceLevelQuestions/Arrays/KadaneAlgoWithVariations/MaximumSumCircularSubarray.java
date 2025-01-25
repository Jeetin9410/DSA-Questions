package AdvanceLevelQuestions.Arrays.KadaneAlgoWithVariations;
    /*
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally,
the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally,
for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.


Constraints:

n == nums.length
1 <= n <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4
     */

public class MaximumSumCircularSubarray {


    public static void main(String[] args) {

       // int[] nums = {5,-3, 5};
       // int n = nums.length;


        // Brute force approach
        /*
        treating the array as circular and calculating the sum for every possible subarray starting from each index.
        While this approach works, it's computationally expensive with a time complexity of 𝑂(𝑛^2),
         as it involves nested loops for each subarray.
         */

        /*
        int res = nums[0];
        for(int i=0;i<nums.length;i++){

            int curSum = nums[i];
            int curMax = nums[i];

            for(int j=1;j<nums.length;j++){
                // finding index
                int index = (i+j)%nums.length;
                curSum += nums[index];
                curMax = Math.max(curSum , curMax);
            }
            res = Math.max(curMax, res);
        }
        System.out.println(res);

        */


        /********************* Optimal Approach *********************/
        int[] nums = {5,-3, 5};
        int n = nums.length;

        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        int currMin = 0;
        int minSum = Integer.MAX_VALUE;
        int total = 0;

        for(int i =0; i< n; i++) {
            currMax += nums[i];
            maxSum = Math.max(maxSum,currMax);
            if(currMax < 0) currMax = 0;

            currMin += nums[i];
            minSum = Math.min(minSum, currMin);
            if(currMin > 0) currMin = 0;

            total += nums[i];
        }

        if (maxSum < 0) {
            System.out.println(maxSum);
            return;
        }

        System.out.println(Math.max((total - minSum), maxSum));

    }
}
