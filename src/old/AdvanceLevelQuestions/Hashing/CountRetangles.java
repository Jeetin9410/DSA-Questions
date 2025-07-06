package old.AdvanceLevelQuestions.Hashing;

import java.util.HashSet;

public class CountRetangles {

    /*
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i])
for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that
(A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having
all the sides parallel to either x-axis or y-axis.


1 <= N <= 2000
0 <= A[i], B[i] <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.



Output Format
Return the number of unordered quadruplets that form a rectangle.



Example Input
Input 1:

 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 1:

 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 All four given points make a rectangle. So, the answer is 1.
Explanation 2:

 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
                                           (1, 1), (3, 1), (3, 2), (1, 2)
                                           (2, 1), (3, 1), (3, 2), (2, 2)

     */

    public static void main(String[] args) {

        // Approach

        //Step 1 : First we will collect all possible coordinates in HashSet in String format of "A[i]-B[i]".
        // Step2 : Now we to Find Rectangle,
        // we will apply 2 nested loop with i and j
        // we are going to check
        //        if 2 points let A(x,y) and B(x,y) are eligible diagonal or not.
        //        to check that --> A and B should follow this A(x) < A(y) && B(x) < B(y)
        //  if A and B are diagonal then we will check 2 more conditions:
        //  if A[i]-B[j] and A[j]-B[i] exist in set above---> if yes --> increase count.

        int[] A = {1, 1, 2, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1, 2};

        int n= A.length;
        HashSet<String> set =new HashSet<>();

        for(int i = 0;i<n;i++){
            set.add(A[i]+"-"+B[i]);

        }

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if( (A[i]< A[j] && B[i] < B[j])){ // checking if points are diagonal or not
                    if(set.contains(A[i]+"-"+B[j]) && set.contains(A[j]+"-"+B[i])){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }

}
