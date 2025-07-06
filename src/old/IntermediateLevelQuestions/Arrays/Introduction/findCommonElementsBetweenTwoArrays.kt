package old.IntermediateLevelQuestions.Arrays.Introduction

/*
You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:

answer1 : the number of indices i such that nums1[i] exists in nums2.
answer2 : the number of indices i such that nums2[i] exists in nums1.
Return [answer1,answer2].



Example 1:

Input: nums1 = [2,3,2], nums2 = [1,2]

Output: [2,1]

Explanation:



Example 2:

Input: nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]

Output: [3,4]

Explanation:

The elements at indices 1, 2, and 3 in nums1 exist in nums2 as well. So answer1 is 3.

The elements at indices 0, 1, 3, and 4 in nums2 exist in nums1. So answer2 is 4.

Example 3:

Input: nums1 = [3,4,2,3], nums2 = [1,5]

Output: [0,0]

Explanation:

No numbers are common between nums1 and nums2, so answer is [0,0].



Constraints:

n == nums1.length
m == nums2.length
1 <= n, m <= 100
1 <= nums1[i], nums2[i] <= 100

 */

fun main() {
    val nums1 = intArrayOf(2,3,2)
    val nums2 = intArrayOf(1,2)

    println(findIntersectionValues(nums1,nums2).toList())
}

fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
    val n = nums1.size
    val m = nums2.size
    val max = Math.max(n,m)
    val map1 = mutableMapOf<Int, Int>() // for nums1
    val map2 = mutableMapOf<Int, Int>() // for nums2
    val result = mutableListOf<Int>()
    var answer1 = 0
    var answer2 = 0

    // Populate map with the frequency of elements in nums1 and nums2
    for (i in 0 until max) {
        if(i < n) {
            map1[nums1[i]] = map1.getOrDefault(nums1[i], 0) + 1
        }
        if(i < m) {
            map2[nums2[i]] = map2.getOrDefault(nums2[i], 0) + 1
        }
    }

    for (i in 0 until max) {
        if(i < n && map2.containsKey(nums1[i])) {
            answer1++
        }
        if(i < m && map1.containsKey(nums2[i])) {
            answer2++
        }
    }

    return intArrayOf(answer1, answer2)
}