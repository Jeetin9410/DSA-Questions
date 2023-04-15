package AdvanceLevelQuestions.BinarySearch;

import java.util.Arrays;

public class MedianOfArray {
    /*
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

Problem Constraints
1 <= N + M <= 2*106



Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.



Output Format
Return a decimal value denoting the median of two sorted arrays.



Example Input
Input 1:

 A = [1, 4, 5]
 B = [2, 3]
Input 2:

 A = [1, 2, 3]
 B = [4]


Example Output
Output 1:

 3.0
Output 2:

 2.5


Example Explanation
Explanation 1:

 The median of both the sorted arrays will be 3.0.
Explanation 2:

 The median of both the sorted arrays will be (2+3)/2 = 2.5.

     */

    public static void main(String[] args) {
        int[] A = {1,4,5};
        int[] B = {2,3};

        int n1= A.length;
        int n2 =B.length;

        int[] ans = new int[n1+n2];
        int i=0;
        int j=0;
        int k = 0;

        while(i<n1 && j<n2){
          if(A[i]<B[j]){
              ans[k] = A[i];
              k++;
              i++;
          }else {
              ans[k] = B[j];
              k++;
              j++;
          }
        }

        while(i < A.length){
            ans[k] = A[i];
            k++;
            i++;
        }

        while(j < B.length){
            ans[k] = B[j];
            k++;
            j++;
        }

        System.out.println(Arrays.toString(ans));
    }
}
