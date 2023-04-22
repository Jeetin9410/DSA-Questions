package AdvanceLevelQuestions.BinarySearch;

import java.util.Arrays;
public class Special_Integer {
    /*
    Given an array of integers A and an integer B,
    find and return the maximum value K such that there is no subarray in A of size K
    with the sum of elements greater than B.

1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

Constraints are satisfied for maximal value of 2.
Explanation 2:

Constraints are satisfied for maximal value of 3.

     */
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int B = 8;
      /*  int n = A.length;
        int[] ps = new int[n+1];
        ps[0] = 0;
        for(int i = 0;i<n;i++){
            ps[i+1] = ps[i] + A[i];
        }

        System.out.println(Arrays.toString(ps));

        int ansK = 0;

        for(int k = 1;k<=n;k++){
            int sum = 0;
            for(int i = k;i<=n;i=i+1){
                 sum = ps[i] - ps[i-k];
                System.out.println(k+" "+sum);
                if (sum > B){
                    break;
                }
            }
            if (sum > B){
                if(k==ansK)
                    ansK--;
                break;
            }else {
                ansK = k;
            }
        }

        System.out.println(ansK);

        CONCLUSION : PASSED EASY TESTCASES, THROWN TLE FOR HARD CASES

        TC : O (N*N)
       */

        /* Method 2 :  Using Binary search

        Q: how BS can be applied? array A is not sorted!!
        Ans : Any Array can be divided into sub-arrays of size
        k = 0 ...to...A.length ===>  which is an sorted number list.

        The approach will be same as above approach but this time we will narrow down our search by ignoring
        some values of k
        Cause in previous appraoch we were checking every value of k
        But we know if 2 is answer then 1 will automatically satisfy that so no need to check for every value.


         */

        int n = A.length;

        int[] ps = new int[n+1];
        ps[0] = 0;
        for(int i = 0;i<n;i++){
            ps[i+1] = ps[i] + A[i];
        }

        System.out.println(Arrays.toString(ps));

        int low = 1;
        int high = n;
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low) / 2;

            //now we have to check for arr length = mid , if all subarray sum is < target or not
            boolean status = isSumGreaterThenTarget(ps,mid,B);
            if(status){
                high = mid -1;

            }else{
                ans = mid;
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean isSumGreaterThenTarget(int[] ps, int k, int target){
        for(int i =k;i<ps.length;i=i+1){
            if ((ps[i] - ps[i-k]) > target){
                return true;
            }
        }
        return false;
    }


}
