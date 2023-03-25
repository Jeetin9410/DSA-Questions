package AdvanceLevelQuestions.Sorting.III_MergeSort;

import java.util.Arrays;

public class III_MergeSort {
    public static void main(String[] args) {
        int[] A = {12,31,5,3,17,26,58,4,23,56,0};

        MergeSort(0,A.length-1,A);
        System.out.println(Arrays.toString(A));
    }
    public static void MergeSort(int s, int e, int[] arr){
        if(s < e) {
            int mid = (s + e) / 2;
            MergeSort(s, mid, arr);
            MergeSort(mid + 1, e, arr);
            Merge(s, e, arr);
        }
    }
    public static void Merge(int s, int e, int[] arr){
         int mid = (s+e)/2;

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

         while(p < len1 && q < len2){
             if(left[p] < right[q]){
                 arr[mainArrayIndex++] = left[p++];
             }else{
                 arr[mainArrayIndex++] = right[q++];
             }
         }

         while(p<len1){
             arr[mainArrayIndex++] = left[p++];
         }

         while(q < len2){
             arr[mainArrayIndex++] = right[q++];
         }
    }
}
