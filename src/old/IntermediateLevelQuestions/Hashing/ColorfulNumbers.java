package old.IntermediateLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class ColorfulNumbers {
    /*
Given a number A, find if it is COLORFUL number or not.

If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:

A number can be broken into different consecutive sequence of digits.
The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324 and 245.
This number is a COLORFUL number, since the product of every consecutive sequence of digits is different.


Problem Constraints
1 <= A <= 2 * 10^9

Example Input
Input 1:  A = 23
Input 2:  A = 236


Example Output
Output 1: 1
Output 2: 0

     */

    public static void main(String[] args) {
        int A = 23;

        System.out.println(solve(A));

    }
    public static int solve(int A){
        int n  = String.valueOf(A).length();
        int[] arr = new int[n];
        int i = n-1;
        while(A!=0){
            arr[i] = A%10;
            i--;
            A /= 10;
        }

       // System.out.println(Arrays.toString(arr));

        // step 2:  start finding products
        HashSet<Integer> set = new HashSet<>();
        boolean status = true;
        for(int j=0;j<n;j++){
            int product = 1;
            for(int k =j;k<n;k++){
                product *= arr[k];
               // System.out.println(product);
                if(set.contains(product)){
                    return 0;
                }else{
                    set.add(product);
                }
            }

        }
        return 1;
    }

}
