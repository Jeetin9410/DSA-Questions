package old.IntermediateLevelQuestions.Arrays.Introduction;

import java.util.Arrays;

public class RotationGame {
    /*
    Given an integer array A of size N and an integer B,
    you have to print the same array after rotating it B times towards the right.

    Problem Constraints
1 <= N <= 10^6
1 <= A[i] <=10^8
1 <= B <= 10^9


Input Format
There are 2 lines in the input

Line 1: The first number is the size N of the array A. Then N numbers follow which indicate the elements in the array A.

Line 2: A single integer B.


Output Format
Print array A after rotating it B times towards the right.


Example Input
Input 1 :
4 1 2 3 4
2


Example Output
Output 1 :
3 4 1 2


Example Explanation
Example 1 :

N = 4, A = [1, 2, 3, 4] and B = 2.

Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]

Final array = [3, 4, 1, 2]
     */


    public static void main(String[] args) {


        /* Approach :

         Observation : We are asked to perform B no of Right shifts.
          if( B >= N) i.e size of array is greater then B,
          then After every N right shift,  Array will come to its original form...at every multiple of N, this wll happen
          Ex A = [ 1,2,3,4]  B = 6
                Shift are like
                4,1,2,3    1st
                3,4,1,2    2nd
                2,3,4,1,   3rd
                1,2,3,4,   4th  ===>  cane back to its original form
                4,1,2,3    5th
                3,4,1,2,   6th ===>  And this is same as 2nd


        So for total required no of shift we need to use modulus

        totalShift = B%N


        Ques : How to find , how will array look after Nth shift?
        Ans : If observe carefully , we can notice pattern that element or set of element from Right end of array are
              shifting to left

              for n = 2 ,in A = [ 1,2,3,4]

              Take Two element from Right End and Append then in starting of rest of array.
              and we will have 3,4,1,2 which is right answer


              so new position of every element starting from Right end of array will be
              (oldPosition + B) % N
              In This we will be required extra N length Array.
              TC : O(N) and SC: O(N)

                Done by Intuition ==> and this is also optimal solution in term of Time complexity but not space


        Method 2 : Trick ==> I checked it from LeetCode, Couldn't figured it out.

        Step 1: Reverse the entire array.
        Step2 : Reverse the first B elements in array.
       Step 3 : Reverse the B+1 to N elements in array.


         */

        int[] A = {1,2,3,4};
        int B = 2;
        int n = A.length;

    /*  Method 1 :
     int totalReqshift  = B % n;


       int[] ans = new int[n];

       for(int i = 0;i<n;i++){
           int newIndex = (i+B)%n;
           ans[newIndex] = A[i];
       }

        System.out.println(Arrays.toString(ans));
    */


        // Method 2 :

        // First reverse entire array

        A = reverseArray(A,0,n-1);
        A = reverseArray(A,0,B-1);
        A= reverseArray(A,B,n-1);

        System.out.println(Arrays.toString(A));
    }

    public static int[] reverseArray(int[] arr, int start, int end){

       while(start<=end){
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;

           start++;
           end--;
       }
       return arr;
    }
}
