package old.AdvanceLevelQuestions.Sorting;

import java.util.Arrays;

public class CountTheNumberOfPairs {
    /*
    Given 2 Arrays A and B of size N and M.
    Count the number of pairs i,j such that A[i] > B[j]
     */

    public static void main(String[] args) {

        int[] A = {7,3,5};
        int[] B = {2,0,6};

        /*
        (7,2) , (7,0) , (7,6), (3,2),(3,0),(5,2),(5,0)


        {3,5,7}
        {0,2,6}
         */

        /************** Naive Solution ********************/
    /*    int count = 0;
        for(int i =0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i] > B[j]){
                    count++;
                }
            }
        }

        System.out.println(count);  */

        /*********** Little better approach ***************/

        /*
          1) We will sort the arrays in increasing order
          2) then we will compare the let B[i] with A[j]
             and if B[i] < A[j]  then all the remaining number in A[j] will also be greater then B[i]
             so we count those elements using index j and A.length.
          3) repeat the step 2 till B.length-1
         */

        Arrays.sort(A);
        Arrays.sort(B);
        int count = 0;
        for(int i = 0;i <B.length;i++){
            for(int j =0;j<A.length;j++){
                if(B[i] < A[j] ){
                    count+= A.length-j;
                    break;
                }
            }
        }
        System.out.println(count);


    }


}
