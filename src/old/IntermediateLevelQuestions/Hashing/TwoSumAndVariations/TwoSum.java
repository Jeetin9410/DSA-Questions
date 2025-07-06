package old.IntermediateLevelQuestions.Hashing.TwoSumAndVariations;

import java.util.HashMap;

public class TwoSum {
    /*
    Given an array of integers nums and an integer target,
     return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.


Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

     */
    public static void main(String[] args) {
        /* Concept :
           nums[i] + nums[j] = target

           for any nums[i],
               if there exist any (target - nums[i]) in {i+1,n} of arr
               then it means
               i and j are valid ans pairs

         Using Hashmap we will store nums[i] while looping from i=0 to i<n
         and at the same time we will look for (target - nums[i]) if this exist,
         if exist store i and j
         return i and j or as per asked in question
         */

        int nums[] = {2,7,11,15};
        int target = 9;

        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        for(int i =0;i<n;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                start = map.get(diff);
                end = i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }

        System.out.println(nums[start]+" "+nums[end]);

    }

}
