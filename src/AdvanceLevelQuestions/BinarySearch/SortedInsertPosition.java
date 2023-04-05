package AdvanceLevelQuestions.BinarySearch;

public class SortedInsertPosition {
/*
Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.

1 <= N <= 10^6

Input format :
The first argument is an integer array A of size N.
The second argument is an integer B.

Output Format :
Return an integer denoting the index of target value.

Example Input
Input 1:

A = [1, 3, 5, 6]
B = 5
Input 2:

A = [1]
B = 1


Example Output
Output 1:

2
Output 2:

0


Example Explanation
Explanation 1:

The target value is present at index 2.
Explanation 2:

The target value is present at index 0.
 */

    public static void main(String[] args) {
        int[] A = {141, 144, 145, 154, 229, 235, 243, 266, 344, 351, 466, 499, 512, 565, 641, 675, 690, 726, 805, 879, 978, 986};
        int B = 65;

        System.out.println(BinarySearch(A,B));

    }
    public static int BinarySearch(int[] A, int k){
        int s = 0;
        int e = A.length-1;
        int ans = 0;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(A[mid] == k){
                return mid;
            }else if(k < A[mid]){
                e = mid-1;
            }else {
                ans = mid+1;
                s= mid+1;
            }
        }
        return ans;
    }
}
