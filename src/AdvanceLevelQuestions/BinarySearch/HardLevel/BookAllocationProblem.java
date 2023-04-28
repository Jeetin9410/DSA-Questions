package AdvanceLevelQuestions.BinarySearch.HardLevel;

import java.util.*;

public class BookAllocationProblem {
    /*

Given an array of integers A of size N and an integer B.

The College library has N books. The ith book has A[i] number of pages.

You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Problem Constraints
1 <= N <= 10^5
1 <= A[i], B <= 10^5



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return that minimum possible number.



Example Input
A = [12, 34, 67, 90]
B = 2


Example Output
113


Example Explanation
There are two students. Books can be distributed in following fashion :

1)  [12] and [34, 67, 90]
    Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
2)  [12, 34] and [67, 90]
    Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
3)  [12, 34, 67] and [90]
    Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
    Of the 3 cases, Option 3 has the minimum pages = 113.

     */

    /// Explaination : https://www.youtube.com/watch?v=YTTdLgyqOLY&ab_channel=CodeHelp-byBabbar

    public static void main(String[] args) {
        int[] A = {31, 14, 19, 75};
        int studentMaxLimit = 12;
        int n = A.length;

        // first we need search space to apply binary search
        // so we are given lower limit as 1
        //  and upper limit will be :  total sum of all pages (which is not possible but it can work for as upper limit)
        long sum = 0;
        for(int val : A){
            sum += val;
        }

        long low = 0;
        long high = sum;

        long res = -1;

        while(low <= high){
            long mid = low + (high - low) /2;

            if(isPossible(A,mid,studentMaxLimit)){
                high = mid -1;
                res = mid;
            }else{
                low = mid + 1;
            }



        }

        System.out.println(res);

    }
    public static boolean isPossible(int[] arr, long mid, int studentMaxLimit){
        int studentCount = 1;
        int pagesSum = 0;

        for(int i=0;i<arr.length;i++){
            if( pagesSum + arr[i] <= mid ){
                pagesSum += arr[i];
            }else{
                studentCount++;
                if(studentCount > studentMaxLimit || arr[i] > mid){
                    return false;
                }
                pagesSum = arr[i];
            }
        }

        return true;
    }
}
