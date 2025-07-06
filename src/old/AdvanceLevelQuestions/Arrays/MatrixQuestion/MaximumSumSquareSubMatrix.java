package old.AdvanceLevelQuestions.Arrays.MatrixQuestion;

import java.util.Arrays;
import java.util.HashMap;

public class MaximumSumSquareSubMatrix {
    /*
    Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1,
    such that the sum of all the elements in the submatrix is maximum.

    1 <= N <= 1000.

    1 <= B <= N

    -100 <= A[i][j] <= 100.

Input Format:
First arguement is an 2D integer matrix A.
Second argument is an integer B.

Output Format:
Return a single integer denoting the maximum sum of submatrix of size B x B.

Example Input
Input 1:

 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:

 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2


Example Output
Output 1:

 48
Output 2:

 8


Example Explanation
Explanation 1:

    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48
Explanation 2:

 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8
     */

    public static void main(String[] args) {
        int[][] A = {
                {-2,-4,-5},
                {-1,-3,-6},
                {-1,-5,-5}
                    };

        int B = 2;

        /* Intuition based :
           find row wise sum and column wise sum
           we can use hashmap to store that result

          now there sum can be used again and again used to find the sum of desired size of matrix.

          This approach is similar to kadane's algorithm,
          it can be modified ....to kadanes algo

          whatwe going to do:
          row wise....prefix sum will be calculated

          and then we will find of require size using that prefix sum 2d array

         */

            int row = A.length;
            int col = A[0].length;

            int[][] prefixSum = new int[row][col];

            for(int i=0;i<row;i++){
                prefixSum[i][0] = A[i][0];
                for(int j=1;j<col;j++){
                    prefixSum[i][j]= prefixSum[i][j-1] + A[i][j];
                }
            }

            for(int i=0;i<row;i++){
                System.out.println(Arrays.toString(prefixSum[i]));
            }


            int maxSum = Integer.MIN_VALUE;

            for(int i =0;i<=(row-B);i++){
                for(int j=0;j<=(col-B);j++){
                    int tempSum= 0;
                   for(int k=i;k<i+B;k++){
                       if(j==0){
                           tempSum = tempSum + prefixSum[k][j+B-1];
                       }else{
                           tempSum = tempSum + prefixSum[k][j+B-1] - prefixSum[k][j-1];
                       }
                       maxSum = Math.max(tempSum,maxSum);
                   }
                }
            }

        System.out.println(maxSum);
    }
}
