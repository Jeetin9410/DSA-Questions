package DsaPatterns.Recursion.Basic;

public class Prob3_LargestNumber {
    public static void main(String[] args) {
        int[] nums = {9,2,3,4,5,1};
        System.out.println(largest(nums, nums.length - 1));
    }

    public static int largest(int[] nums, int index) {
        if(index == 0)
            return nums[0];

        int largest = Math.max(nums[index], largest(nums, index -1));
        return largest;
    }
}
