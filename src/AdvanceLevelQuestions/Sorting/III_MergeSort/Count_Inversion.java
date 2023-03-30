package AdvanceLevelQuestions.Sorting.III_MergeSort;

public class Count_Inversion {
    /*
    Given an array a[]. The task is to find the inversion count of a[].
    Where two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     */
    public static void main(String[] args) {
        int[] A= {8, 4, 2, 1};

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

    }
    public static void MergeSort(int s, int e,int[] arr){

        if(s<e){
            int mid = (s+e)/2;
            MergeSort(s,mid,arr);
            MergeSort(mid+1,e,arr);

        }
    }

    public static void merge(int s,int e,int[] arr){
        int mid = (s+e)/2;

        int len1 = mid-s+1;
        int len2 = e - mid;

        int[] p = new int[len1];
        int[] q = new int[len2];

        for(int i =  0;i<len1;i++){
            p[i] = arr[i];
        }

        int i = 0;
        int j = 0;


    }
}
