package AdvanceLevelQuestions.Sorting.II_BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {5, 1, 4, 2, 8};
        BubbleSort(A);
    }
    public static void BubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n ; i++) {
            for (int j = i; j <n-1 ; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] =arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /*              ISSUE IN ABOVE CODE



     */

}
