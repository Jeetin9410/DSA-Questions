package AdvanceLevelQuestions.BitManipulation;

/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99


Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.

 */

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};

        /*
            leetCode question : https://leetcode.com/problems/single-number-ii/

            Thinking in bitwise
            1. Every number can be represented in 32 digit binary number.
             Ex: 00000000000000000000000000000010 --> representation of 2
                 00000000000000000000000000000011 --> representation of 3

            2. For above given set of numbers, we can represent them as follow:
                00000000000000000000000000000010 --> representation of 2
                00000000000000000000000000000010 --> representation of 2
                00000000000000000000000000000010 --> representation of 2
                00000000000000000000000000000011 --> representation of 3
               -------------------------------------
                00000000000000000000000000000011 --->  this is the answer

                so what we do to these numbers to get back

                Logic: We will count set bit at every n th place in 32 bit representation
                       and cause every number occurs 3 times , ex for 2 --> first set bit is on tens place

                       so we closely observe for all 2 this pattern will remain same except for single number

                       so for n th place in 32 bit iteration --> number of 1 s should be multiple of 3, suppose if single number is not there
                       but for our case it exists --> so if we count total no of 1 at n th bit place and do modulo with 3 then only
                                                      single number 's set bit will be left and at the end we will get that single number.


         */
        int ans = 0;
        for (int i =0; i<32; i++) {
            int totalOnce = 0;
            for(int j = 0; j < nums.length; j++){
                if(((nums[j] >> i) & 1) == 1) {
                    totalOnce++;
                }
            }
            totalOnce %= 3;

            if(totalOnce != 0) {
                ans = ans | totalOnce << i;
            }

        }

        System.out.println("Ans :"+ans );


    }
}
