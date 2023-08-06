package IntermediateLevelQuestions.Arrays.Introduction;

import java.util.Arrays;

public class ReverseArray {
    /*
    You are given a constant array A.

You are required to return another array which is the reversed form of the input array.
     */
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        A = reverseArray(A,0,A.length-1);
        System.out.println(Arrays.toString(A));
    }
    public static int[] reverseArray(int[] A, int start, int end){
        while(start<=end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return A;
    }
}
