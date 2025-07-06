package old.AdvanceLevelQuestions.BitManipulation;

import java.util.Arrays;

public class SingleNumber3 {
    /*
    Given an integer array nums, in which exactly two elements appear only once and all the other elements appear
    exactly twice. Find the two elements that appear only once. You can return the answer in any order.

    You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

    Example 1:

    Input: nums = [1,2,1,3,2,5]
    Output: [3,5]
    Explanation:  [5, 3] is also a valid answer.
    Example 2:

    Input: nums = [-1,0]
    Output: [-1,0]
    Example 3:

    Input: nums = [0,1]
    Output: [1,0]

    2 <= nums.length <= 3 * 104
    -2^31 <= nums[i] <= 2^31 - 1
     */

    public static void main(String[] args) {
        /*
        Approach : Doing XOR operation in entire wont work this time. It will result in XOR of 2 elements
                   that appear onlt once. (Target number let x and y).
                   So x ^ y == Some binary Format number.
                   This binary format will help us to find these target numbers.
            Concept : => The right set bit  of x ^ y tells us that bit at that position in target number
                             are different. Let first right most bit is at i th position.
                      => And if we saparate the given original list acc to
                               1)list of elements having 0 at i th bit
                               2)list of elements having 1 at i th bit
                      => Because i th bit in both target numbers are different so both different number
                         will fall in different list as mentioned above.
                      => Now those target number will be single time in those two list and now they
                         can be found out using xor operator again.
        */

        int[] nums = {1,2,1,3,2,5};

        int totalXor = 0;

        for(int val : nums){
            totalXor = totalXor ^ val;
        }

        int rsbm = totalXor & -totalXor;

        int x =0; int y =0;

        for(int val : nums){
            if((val & rsbm)==0){
                x = x ^ val;
            }else{
                y = y ^ val;
            }
        }

        int[] ans = {x,y};
        System.out.println(Arrays.toString(ans));
    }
}
