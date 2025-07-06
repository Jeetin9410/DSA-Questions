package old.AdvanceLevelQuestions.BinarySearch;

public class MedianOfTheMatrix {
    /*
    Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.


1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Example Input
Input 1:

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]
Input 2:

A = [   [5, 17, 100]    ]


Example Output
Output 1:

 5
Output 2:

 17


Example Explanation
Explanation 1:

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5.
Explanation 2:

Median is 17.

     */
    public static void main(String[] args) {
        int[][] A = {
                {1,3,5},
                {2,6,9},
                {3,6,9}};

        // Intuition 1: looking at the given example, i am thinking
        /* what if , i take--> every mid of each row and sum them
                    and divide that sum by number of rows

            WORKED FOR 12 cases .....hahahaha.
            failed for
            A : [ [1],
                  [3],
                 [3]
                ]

         */

      /*  int row = A.length;
        int col = A[0].length;

        int sum = 0;
        for(int[] val : A){
            sum = sum + val[(col-1)/2];
        }
        System.out.println((double) sum/row);

       */



    }
}
