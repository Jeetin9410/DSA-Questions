package old.IntermediateLevelQuestions.Arrays.Medium;

public class Count_Rotation_In_Sorted_Array {
    /*
    Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values).
    Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated.
     */
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};


        //Method 1 : Brute force approach
        /*
        Search the smallest element in the given array, and return its index.

        method1_rotationCount(arr);
         */

        //Method2 : Binary Search

    }


    private static void method1_rotationCount(int[] arr) {
        int rotationCount = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
                rotationCount = i;
            }
        }

        System.out.println(rotationCount);
    }

    private static void method2_rotationCount(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        int ans = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            // entire array is in ascending order, then element on low will be smallest and its index will be rotationCount
            if(arr[low] <= arr[high]) {
                if(arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                System.out.println(index);
                return;
            }

            if(arr[low] <= arr[mid] ) {

                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }

                low = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                high = mid - 1;
            }
        }

        System.out.println(index);
    }
}
