package AdvanceLevelQuestions.Sorting.III_MergeSort;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7};
        int[] B = {2, 4, 6, 8};

        //Method 1: Using inbuilt libraries
        /*
           --> we will create a array
               lets int[] C = new int[A.len+B.len]
           --> put every element of A and B in C
           --> Arrays.sort(C)

         */

         //Method 2 : we going to use 2 indices, each for each array.
        /*
           suppose i denote index for array A and
                   j denote index for array B

                   k index for final answer array C

            Then while loop i-->A.len and j-->B.len
             compare A[i] and B[j] and put
             C[k] =  min( A[i], B[j] )


         */
        int i = 0;
        int j = 0;
        int k = 0;
        int[] C = new int[A.length + B.length];
        while (i<A.length && j<B.length){
            if(A[i] < B[j]){
                C[k] = A[i];
                k++;
                i++;
            }else{
                C[k] = B[j];
                k++;
                j++;
            }
        }

        while(i < A.length){
            C[k] = A[i];
            k++;
            i++;
        }

        while(j < B.length){
            C[k] = B[j];
            k++;
            j++;
        }

        System.out.println(Arrays.toString(C));

    }
}
