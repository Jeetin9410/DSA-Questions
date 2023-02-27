package AdvanceLevelQuestions.Mathematics;

public class A_B_and_Modulo {
    /*
    Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.

   1 <= A, B <= 10^9
    A != B

    Example Input
Input 1:

A = 1
B = 2
Input 2:

A = 5
B = 10


Example Output
Output 1: 1
Output 2: 5

     */

    public static void main(String[] args) {
        /*
        Concept:

        A % M = B % M

        A%M - B%M = 0

         taking mod on both side

         (A%M - B%M)%M = 0

         (A-B) % M = 0

         Now the above equation to be true, (A-B) should be multiple of M

         so M should be Math.abs(A-B)
         */
        int A = 1;
        int B = 2;

        System.out.println(Math.abs(A-B));
    }
}
