package AdvanceLevelQuestions.BinarySearch;

public class SearchInMatrix {
    /*
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.
     */

    public static void main(String[] args) {
        int[][] A = { {3},
                {29},
                {36},
                {63},
                {67},
                {72},
                {74},
                {78},
                {85}};


        /*
        Approach : Intuition based

        putting s1 and s2 at 0,0
        putting e1, e2 at A.length-1, A[0].length-1

        find mid==>  m1= (s1+e1)/2 , m2 = (s2+e2)/2

        compare key with A[m1][m2]

        and rest will bw same as binary Search logic


        Conclusion : This approach will not work.
        Why?  because doing half of indices here won't work.
        Eventually you will get same value of mid-index again and again

         */


        /* Appraoch 2 :
          we will set
          low at =0
          high = a.length-1

          now we will find
          mid = (low + high)/2;

          now we will compare the first element of this row i.e mid
          i.e A[mid][0] with key

          doing this till we have a situation where
          key>= A[mid][0] && key<= A[mid][m-1]

          and now use simple binary search in this array.

        */

        System.out.println(BinarySearchInMatrix(A,41));
    }
    public static int BinarySearchInMatrix(int[][] A, int key){
       int low  = 0;
       int high = A.length-1;
       int col = A[0].length-1;
        int mid = (low+high)/2;
       while(low <= high){

           if(key>=A[mid][0] && key<=A[mid][col]) {

               break;
           }else if(A[mid][0]>key){

               high=mid-1;

           }else{

               low=mid+1;

           }
           mid = (low+high)/2;
       }
       int reqCol = mid;
        System.out.println(mid);
       int start = 0;
       int end = col;

       while(start<=end){
           int m = (start + end)/2;
             if(A[reqCol][m]==key){
               return 1;
           }else if(key<A[reqCol][m]){
               end = m-1;
           }else {
               start = m+1;
           }
       }

       return 0;
    }
}
