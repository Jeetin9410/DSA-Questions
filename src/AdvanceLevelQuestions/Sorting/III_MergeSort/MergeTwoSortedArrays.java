package AdvanceLevelQuestions.Sorting.III_MergeSort;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = {1, 3, 4, 5};
        int[] B = {2, 4, 6, 8};

        int Alen = A.length;
        int Blen = B.length;

        int[] C = MergeSort(A,B,Alen,Blen);

        System.out.println(Arrays.toString(C));


    }

    public static int[] MergeSort(int[] A, int[] B,int Alen, int Blen){

        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[Alen+Blen];



        while(i<Alen && j<Blen){

            if(A[i] < B[j]){
                ans[k] = A[i];
                i++;
                k++;
            }else{
                ans[k] = B[j];
                k++;
                j++;
            }

        }

        while(i < Alen){
            ans[k++] = A[i++];

        }

        while(j < Blen){
            ans[k++] = B[j++];
        }

        return ans;
    }
}
