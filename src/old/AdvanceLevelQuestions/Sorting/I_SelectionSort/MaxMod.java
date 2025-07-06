package old.AdvanceLevelQuestions.Sorting.I_SelectionSort;

public class MaxMod {
    /*
        Given an array A of size N, Groot wants you to pick 2 indices i and j such that

        1 <= i, j <= N
        A[i] % A[j] is maximum among all possible pairs of (i, j).
        Help Groot in finding the maximum value of A[i] % A[j] for some i, j.

        Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 100000



Input Format
First and only argument in an integer array A.



Output Format
Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.



Example Input
Input 1:

 A = [1, 2, 44, 3]
Input 2:

 A = [2, 6, 4]


Example Output
Output 1:

 3
Output 2:

 4
     */

    public static void main(String[] args) {
        int[] A = {3, 3, 3, 3};

        /*
        intuition :
        A[i]%A[j] to maximise
        condition 1:A[i] and A[j] must be the 2 maximum values of given array.

        First Edge case:
        what if both heighiest values are same?
        Ex A= [1,2,3,3]

        so condition 2: A[i] and A[j] should be distinct


         */
        A = selectionSort(A);

        int i ;

        for (i=A.length-2;i>=0;i--){
            if(A[A.length-1] != A[i]){
                break;
            }
        }
        if(i<0)
            i++;

        System.out.println(i);






    }
    public static int[] selectionSort(int[] arr){
        for(int i =0;i< arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j< arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    int temp = arr[j];
                    arr[j] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }
        return arr;
    }

}
