package old.AdvanceLevelQuestions.Sorting.II_BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {5, 1, 4, 2, 8};
        BubbleSort(A);
    }
    public static void BubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped = false;
        for (int i = 0; i < n-1 ; i++) {
            for (int j = 0; j <n-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] =arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

  

}
