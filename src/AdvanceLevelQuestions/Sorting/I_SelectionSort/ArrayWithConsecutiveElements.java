package AdvanceLevelQuestions.Sorting.I_SelectionSort;

public class ArrayWithConsecutiveElements {
    /*
    Given an array of positive integers A, check and return whether the array elements are consecutive or not.
    NOTE: Try this with O(1) extra space.

    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9

    Input Format
The only argument given is the integer array A.



Output Format
Return 1 if the array elements are consecutive else return 0.

    Example Input
Input 1:  A = [3, 2, 1, 4, 5]
Input 2:  A = [1, 3, 2, 5]


Example Output
Output 1:  1
Output 2:  0


Example Explanation
Explanation 1:

 As you can see all the elements are consecutive, so we return 1.
Explanation 2:

 Element 4 is missing, so we return 0.
     */

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};

        /*
        Intuition : we going to sort it
        and then using for loop we check,
          if   arr[i] == arr[i+1]-1
          else return 0;
          */

        A = selectionSort(A);
        int status = 1;
        for(int i=0;i<A.length-1;i++){
            if(A[i] != A[i+1]-1){
                status = 0;
                return;
            }
        }
        System.out.println(status);
    }
    public static int[] selectionSort(int[] arr){
        for(int i=0;i< arr.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j< arr.length;j++) {
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
