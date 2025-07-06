package old.AdvanceLevelQuestions.Mathematics.ModuloOperator;

public class VeryLargePower {
    /*
    Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power,

"%" means "mod", and

"!" means factorial.

1 <= A, B <= 5e5

Example Input
Input 1:

A = 1
B = 1
Input 2:

A = 2
B = 2


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Explanation 1:

 1! = 1. Hence 1^1 = 1.
Explanation 2:

 2! = 2. Hence 2^2 = 4.
     */

    public static void main(String[] args) {
        int A= 35;
        int B = 68;
        long M = 1000000007;

        //we have to find (A^(B!) % 1000000007)

        /*
        Intution : Find B!
                   find A^B!
                   then return final ans


         */

        long b = factor(B,(int)M-1);
        System.out.println(power(A,(int)b,(int)M));
    }

    public static long factor(int num,int M){
        if(num==1){
            return 1;
        }
        if(num==0)
            return 1;

        return (num  * factor(num-1,M)%M)%M;
    }

    public static int power(int A, int B, int M){
        if(A==0)
            return 0;

        if(B==0)
            return 1;

        long ans = power(A,B/2,M)%M;

       long p = (ans * ans)%M;

        if(B%2==0){
            return (int)p;

        }else{
            return (int)((p * A)%M);
        }

    }

    // useful link for concept : https://www.youtube.com/watch?v=S422hTEl6XA&ab_channel=Pepcoding

}
