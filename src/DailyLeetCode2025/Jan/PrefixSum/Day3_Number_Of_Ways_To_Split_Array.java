package DailyLeetCode2025.Jan.PrefixSum;

import java.util.Arrays;

public class Day3_Number_Of_Ways_To_Split_Array {

    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};

        System.out.println("Ans: " +waysToSplitArray(nums));
    }

    public static int waysToSplitArray(int[] nums) {

        int n = nums.length;
        long[] ps = new long[n];      // initially did this int array, 100/101 testcase passed, 1 failed
                                      // Important to take care of this overflow scenario
        ps[0] = nums[0];

        for(int i =1; i < n; i++) {
            ps[i] = ps[i-1] + nums[i];
        }

        System.out.println(Arrays.toString(ps));

        long totalSum = ps[n-1];
        int ans = 0;

        for(int i = 0; i<n -1; i++) {
            long sumOfleft = ps[i];
            long sumOfRight = totalSum - sumOfleft;
            System.out.println(sumOfleft + " " + sumOfRight);
            if(sumOfleft >= sumOfRight) {
                ans++;
            }
        }

        return ans;

    }

}
