package AdvanceLevelQuestions.Sorting.I_SelectionSort;

import java.util.Arrays;

public class KthSmallestElement {
    /*
    Find the Bth smallest element in given array A .

     NOTE: Users should try to solve it in less than equal to B swaps.

     1 <= |A| <= 100000

    1 <= B <= min(|A|, 500)

    1 <= A[i] <= 10^9

Example Input
Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Explanation 1:

 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2.
     */
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3, 2};
        int B = 3;

        /*
        Using selection sort, then finding B-1 the element
         */
        A= selectionSort(A);
        System.out.println(B+"th Smallest element in\t"+Arrays.toString(A)+"\tis: "+A[B-1]);
    }
    public static int[] selectionSort(int[] arr){

        for(int i =0;i< arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j< arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    int temp = arr[j];
                    arr[j] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }

        return arr;
    }
}
