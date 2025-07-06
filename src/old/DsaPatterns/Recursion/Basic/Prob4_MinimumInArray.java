package old.DsaPatterns.Recursion.Basic;

public class Prob4_MinimumInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,-3,0,5,9};
        System.out.println(minimumNum(nums, 0));
    }

    public static int minimumNum(int[] arr, int index) {
        if(index == arr.length - 1) {
            return arr[index];
        }

        return Math.min(arr[index], minimumNum(arr, index + 1));
    }
}
