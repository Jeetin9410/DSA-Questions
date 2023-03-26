package AdvanceLevelQuestions.Sorting;

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



    }


}
