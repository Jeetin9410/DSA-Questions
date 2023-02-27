package AdvanceLevelQuestions.Arrays;

public class MaximumAbsoluteDifference {
    /*
    You are given an array of N integers, A1, A2, .... AN.

    Return the maximum value of f(i, j)
    for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.


    1 <= N <= 100000
    -10^9 <= A[i] <= 10^9

    Input Format :
    First argument is an integer array A of size N.

    Output Format :
    Return an integer denoting the maximum value of f(i, j).

    Example Input :

    Input 1: A = [1, 3, -1]
    Input 2: A = [2]

    Example Output
    Output 1: 5
    Output 2: 0

    
     */

    public static void main(String[] args) {
        int A[] = {1,3,-1};

        /*
           for i > j
           1)  A[i] > A[j] :=  ( A[i] + i ) - (A[j] + j)
           2)  A[i] < A[j] :=  ( -A[i] + A[j] ) + (i - j) ==> -( (A[i] - i) - (A[j] - j) )
            for i < j
            3) A[i] > A[j] :=  (A[i] - A[j]) - (i-j)  ==>  ( (A[i] - i) - (A[j] - j))
            4) A[i] < A[j] :=  ( (-A[i] + A[j]) - (i - j)) ==>   -((A[i] + i) - (A[j] + j))

            eq 1 and 4
            eq 2 and 3 are same

         */

        int maxeq1 = Integer.MIN_VALUE, mineq1 = Integer.MAX_VALUE, mineq2 = Integer.MAX_VALUE, maxeq2 = Integer.MIN_VALUE;

        for( int i = 0; i<A.length;i++){

            maxeq1 = Math.max(maxeq1,A[i] + i);
            mineq1 = Math.min(mineq1,A[i] + i);

            maxeq2 = Math.max(maxeq2,A[i] - i);
            mineq2 = Math.min(mineq2,A[i] - i);
        }

        int ans1 = maxeq1 - mineq1;
        int ans2 = maxeq2 - mineq2;

        System.out.println(Math.max(ans1,ans2));

    }
}
