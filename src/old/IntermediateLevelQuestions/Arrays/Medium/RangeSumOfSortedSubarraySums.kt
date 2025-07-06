package old.IntermediateLevelQuestions.Arrays.Medium
/*
You are given the array nums consisting of n positive integers. You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 109 + 7.



Example 1:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
Example 2:

Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
Output: 6
Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
Example 3:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
Output: 50


Constraints:

n == nums.length
1 <= nums.length <= 1000
1 <= nums[i] <= 100
1 <= left <= right <= n * (n + 1) / 2

 */
fun main() {
    val nums = intArrayOf(1,2,3,4)
    val n = nums.size
    val left = 1
    val right = 5

    val prefixSum = IntArray(n)
    prefixSum[0] = nums[0]

    for (i in 1..n-1) {
        prefixSum[i] = prefixSum[i-1] + nums[i]
    }

    val m = (n*(n+1))/2

    val subArraySums = IntArray(m)
    var index = 0
    for (i in 0 until n) {
        for (j in i until n) {
            if (i == 0) {
                subArraySums[index] = prefixSum[j]
            } else {
                subArraySums[index] = prefixSum[j] - prefixSum[i - 1]
            }
            index++
        }
    }

    subArraySums.sort()

    val mod = 1000000007
    var result = 0
    for (i in left - 1 until right) {
        result = (result + subArraySums[i]) % mod
    }

     println(result)

}