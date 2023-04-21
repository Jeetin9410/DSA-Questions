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
        int[] A = {1,2,3,4,5};
        int B = 10;
        int n = A.length;
        int[] ps = new int[n+1];
        ps[0] = 0;
        for(int i = 0;i<n;i++){
            ps[i+1] = ps[i] + A[i];
        }

        System.out.println(Arrays.toString(ps));

        int ansK = 0;

        for(int k = 2;k<n;k++){
            for(int i = k;i<n;i=i+1){
                int sum = ps[i] - ps[i-k];
                if(sum < B){
                    ansK = Math.max(k,ansK);
                }
            }
        }

        System.out.println(ansK);



    }
}
