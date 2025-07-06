package old.AdvanceLevelQuestions.Sorting.III_MergeSort;

import java.util.Arrays;

public class MergeSort {

    public static int count = 0;
    public static void main(String[] args) {

        /*    Roadmap
              first we will split the array again and again till the array becomes single element array using recursion.

         */
        int[] arr = {6, 12, 10, 17, 10, 22, 9, 19, 21, 31, 26, 8};
      int[] val = mergeSort(0, arr.length-1,arr);

        System.out.println(Arrays.toString(val));
        System.out.println(count);

    }
    public static int[] mergeSort(int s, int e, int[] arr){
        if(s==e){           // this means the array has only single element and no further splitting is possible
            int[] baseArr = new int[1];
            baseArr[0] = arr[s];
            return baseArr;
        }
        int mid = (s+e)/2;
       int[] firstSortedHalf = mergeSort(s,mid,arr);
       int[] secondSortedHalf = mergeSort(mid+1,e,arr);
       int[] finalSortedArray = mergeSortedArrays(firstSortedHalf,secondSortedHalf);

        return finalSortedArray;
    }

    public static int[] mergeSortedArrays(int[] firstArray, int[] secondArray){

        int[] ans = new int[firstArray.length + secondArray.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < firstArray.length && j < secondArray.length){
            if(firstArray[i] < secondArray[j]){
                ans[k] = firstArray[i];
                k++;
                i++;
            }else{
                if(firstArray[i]!=secondArray[j]){
                    count += firstArray.length-i;
                }
                System.out.println(count);
                ans[k] = secondArray[j];
                k++;
                j++;

            }
        }

        while (i < firstArray.length){
            ans[k] = firstArray[i];
            k++;
            i++;
        }

        while(j<secondArray.length){
            ans[k] = secondArray[j];
            k++;
            j++;
        }

        return ans;
    }
}
