package IntermediateLevelQuestions.Arrays.Introduction;

import java.util.Arrays;

public class SecondLargestNumber {
    /*
    You are given an integer array A.
    You have to find the second largest element/value in the array or report that no such element exists.
     */
    public static void main(String[] args) {
        int[] A = {1,5,4,6,8,2,36};
       // Arrays.sort(A);
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int SecondLargest = Integer.MIN_VALUE;
        for(int i=0; i<n;i++){
            max = Math.max(max,A[i]);
        }

        for(int i=0;i<n;i++){
            if(A[])
        }
    }
}
