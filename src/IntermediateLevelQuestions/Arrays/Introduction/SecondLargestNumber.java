package IntermediateLevelQuestions.Arrays.Introduction;

public class SecondLargestNumber {
    /*
    You are given an integer array A. You have to find the second largest element/value
     in the array or report that no such element exists.

     1 <= |A| <= 10^5

    0 <= A[i] <= 10^9

    Example Input
Input 1:

 A = [2, 1, 2]
Input 2:

 A = [2]


Example Output
Output 1:

 1
Output 2:

 -1
     */

    public static void main(String[] args) {
        int[] A = {1,2,4,7,7,5,8};

        // Brute Force :
        /*
        Sort the array
        Return ,first element that is just lesser than the last element
         */

        /* Better Approach:

            First for loop to find Max Element

            take int max = Integer.Min_vlaue
            Second for loop to check if current num is greater then max and less then MAX_OF_ARRAY

         */
      /*  int MAX = Integer.MIN_VALUE;
        for(int val: A){
            MAX = Math.max(MAX,val);
        }

        int SECOND_MAX = Integer.MIN_VALUE;
        for(int val : A){
            if(val > SECOND_MAX && val <MAX){
                SECOND_MAX =val;
            }
        }

        System.out.println(SECOND_MAX); */


        /* Optimal Approach :
           1) Initialize the first as 0(i.e, index of arr[0] element
           2) Start traversing the array from array[1],
                a) If the current element in array say arr[i] is greater
                    than first. Then update first and second as,
                      second = first
                      first = arr[i]
                b) If the current element is in between first and second,
                  then update second to store the value of current variable as
                  second = arr[i]
           3) Return the value stored in second.

         */
        int MAX = A[0];
        int SECOND_MAX = A[0];
        for(int i=1;i< A.length;i++){

            if(A[i] > MAX){
                SECOND_MAX = MAX;
                MAX = A[i];
            }

            if(A[i] > SECOND_MAX && A[i]!=MAX){
                SECOND_MAX = A[i];
            }
        }

        System.out.println(SECOND_MAX);
    }
}