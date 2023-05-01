package AdvanceLevelQuestions.Sorting.IV_QuickSort;

import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int[] A = {1, 4, 10, 2, 1, 5};

        quickSort(A,0,A.length-1);

        System.out.println(Arrays.toString(A));


    }

    public static void quickSort(int[] A, int s, int e){

        if( s>=e)
            return ;

        int pivotIndex = partition(A, s, e);
        quickSort(A, s , pivotIndex-1);
        quickSort(A,pivotIndex+1,e);
    }

    public static int partition(int[] A, int s, int e){

        int pivot = A[s];

// count no of smaller elements then pivot
        int count = 0;

        for(int i=s+1;i<=e;i++) {
            if (A[i] <= pivot) {
                count++;
            }
        }
            /// calculate pivot index
            int pivotIndex = s + count;

            // swap the start element (pivot) with the element on its pivotIndex position
            int temp = A[s];
            A[s] = A[pivotIndex];
            A[pivotIndex] = temp;

            // now insure the all smaller elements are on left of pivot and greater on right to it.

            int i =s; int j=e;

            while(i<pivotIndex && j>pivotIndex){

                while(A[i] <= pivot){
                    i++;
                }

                while(A[j] > pivot){
                    j--;
                }

                if(i<pivotIndex && j>pivotIndex){
                    int p =A[i];
                    A[i] = A[j];
                    A[j] = p;
                    i++;
                    j++;
                }
            }

            return pivotIndex;
        }


}
