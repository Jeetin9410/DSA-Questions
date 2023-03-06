package AdvanceLevelQuestions.Sorting.I_SelectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] A = {5,7,3,4,9,6,1};

        for(int i = 0;i<A.length-1;i++){

             int minimumIndex = i;

             for(int j = i+1;j<A.length;j++){
                 if(A[j] < A[minimumIndex] ){
                     int temp = A[minimumIndex];
                     A[minimumIndex] = A[j];
                     A[j] = temp;
                 }
             }
        }

        System.out.println(Arrays.toString(A));
    }
}
