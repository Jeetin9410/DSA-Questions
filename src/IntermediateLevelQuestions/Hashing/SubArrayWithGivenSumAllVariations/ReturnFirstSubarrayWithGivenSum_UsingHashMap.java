package IntermediateLevelQuestions.Hashing.SubArrayWithGivenSumAllVariations;

import java.util.Arrays;
import java.util.HashMap;

public class ReturnFirstSubarrayWithGivenSum_UsingHashMap {
    /*
    Given an array of positive integers A and an integer B,
    find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.


1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Output: Sum found between indexes 0 to 3
Explanation: Sum of elements between indices
0 and 3 is 10 + 2 – 2 – 20 = -10

Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
Output: No subarray with given sum exists
Explanation: There is no subarray with the given sum
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 5;

        /*  Points to be careful in here:
          1)  sum should be taken long
          cause array element with high int value will sum up to lon value
          2) start should be map.get(sum - B ) + 1 cause we need next element from which required subarray is.
         */

        int n = arr.length;
        int sum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();  // sum , and its occurrence
        int start = -1;
        int end = -1;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == target){
                start = 0;
                end = i;
             //   System.out.println(start + " "+end);
                break;
            }
            if(map.containsKey(sum - target)){
                start = map.get(sum- target) + 1;
                end = i;
            //    System.out.println(start + " "+end);
                break;
            }
            map.put(sum,i);
        }
        if(end == -1){
            int[] ans = {-1};
        }else{
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr,start,end+1)));
        }
    }
}
