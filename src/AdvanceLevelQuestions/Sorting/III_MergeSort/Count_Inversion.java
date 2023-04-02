package AdvanceLevelQuestions.Sorting.III_MergeSort;

import java.rmi.MarshalException;
import java.util.Arrays;

public class Count_Inversion {      /////////// INCOMPLETE CODE
    /*
    Given an array a[]. The task is to find the inversion count of a[].
    Where two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     */
    public static int inversion = 0;
    public static void main(String[] args) {
        int[] A= {28, 18, 44, 49, 41, 14};

        /*
        Inversion Count for an array indicates – how far (or close) the array is from being sorted.
        If the array is already sorted, then the inversion count is 0,
        but if the array is sorted in reverse order, the inversion count is the maximum.
         */
        /***************** Brute force approach ***********************/

        /*  Using two nested for loop
            TC : O(N*N)  , N is length of given array.


         */

        /************** Optimised approach ************/
       // mergeSort(0,A.length-1,A);
      //  System.out.println(inversion);

        //mergeSortOld(0, A.length-1,A);

        System.out.println(MergeSort(0, A.length-1,A));

    }

    public static int MergeSort(int s, int e, int[] arr){
        int count = 0;
        if(s == e) {
           return 0;
        }
        int mid = (s + e) / 2;
       count += MergeSort(s, mid, arr);
       count += MergeSort(mid + 1, e, arr);
       count += Merge(s, e, mid,arr);

       return count;
    }

    public static int Merge(int s, int e,int mid ,int[] arr){
        //int mid = (s+e)/2;

        int len1 = mid - s + 1;
        int len2 = e - mid;

        int[] left = new int[len1];
        int[] right = new int[len2];

        int k = s;
        for(int i = 0; i<len1; i++){   //  putting values from s to len1
            left[i] = arr[k++];
        }

        int l = mid+1;
        for(int i = 0; i<len2;i++){
            right[i] = arr[l++];
        }

        int p = 0;
        int q = 0;
        int mainArrayIndex = s;
        int count = 0;

        while(p < len1 && q < len2){
            if(left[p] < right[q]){
                arr[mainArrayIndex++] = left[p++];
            }else{
                count += mid-p+1;
                arr[mainArrayIndex++] = right[q++];
            }
        }

        while(p<len1){
            arr[mainArrayIndex++] = left[p++];
        }

        while(q < len2){
            arr[mainArrayIndex++] = right[q++];
        }

        return count;
    }

}
