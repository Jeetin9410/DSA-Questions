package old.AdvanceLevelQuestions.Mathematics.GCD;

public class DivisiorGame {

    /*
    Scooby has 3 three integers A, B, and C.

     Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
     You need to tell the number of special integers less than or equal to A.

     1 <= A, B, C <= 10^9

     Example Input
Input 1:

 A = 12
 B = 3
 C = 2
Input 2:

 A = 6
 B = 1
 C = 4


Example Output
Output 1:  2
Output 2:  1


Example Explanation
Explanation 1:  The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
Explanation 2:  Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.

     */

    public static void main(String[] args) {
        //The problem is about finding the all the number divisible by B and C.
        // divisibility rule.

        /*
        Intuition :
        using for loop , check if X%3==0 and X%5==0
         */
        int A = 12;
        int B = 3;
        int C = 2;
        int count = 0;

        for(int i=1;i<=A;i++){
            if(i%B==0 && i%C==0){
                count++;
            }
        }

        System.out.println(count);

        /*
        Little better approach :
        what if we go from 1 to A
        only the multiple of B and check those are divisible by C or not.
        If yes then count

        now we can also do is check Max in B and C and use for loop according to that.
        that will minimise the iteration

        */
        int ans = 0;
        int max = Math.max(B,C);
        int min = Math.min(B,C);
        for(int i = max;i<=A;i+=max){
            if(i%min==0){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
