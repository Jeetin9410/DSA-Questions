package old.AdvanceLevelQuestions.Arrays;

import java.util.Arrays;

public class RainWaterTrapped {
    /*
    Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
     compute how much water it is able to trap after raining.

     1 <= |A| <= 100000

     Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0
     */
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // ans = 6

        int n= A.length;
        int[] MaxHeightFromLeft = new int[n];
        int[] MaxHeightFromRight = new int[n];

        MaxHeightFromLeft[0] = A[0];
        MaxHeightFromRight[n-1] = A[n-1];

        for(int i=0;i<n-1;i++){
            MaxHeightFromLeft[i] = Math.max(A[i],A[i+1]);
        }

        for(int i=n-1;i>0;i--){
            MaxHeightFromLeft[i] = Math.max(A[i],A[i-1]);
        }

        System.out.println(Arrays.toString(MaxHeightFromLeft));
        System.out.println(Arrays.toString(MaxHeightFromRight));

    }
}
