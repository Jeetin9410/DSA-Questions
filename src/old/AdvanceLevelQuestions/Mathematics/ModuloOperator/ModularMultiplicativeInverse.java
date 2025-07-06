package old.AdvanceLevelQuestions.Mathematics.ModuloOperator;

public class ModularMultiplicativeInverse {
    /*
      Given two integers A and M, find the modular multiplicative inverse of A under modulo M.
      The modular multiplicative inverse is an integer X such that:
      AX ≅ 1 (mod M)

      Note : X will always in [1,M-1]

      Input: A = 3, M = 11
        Output: 4
        Explanation: Since (4*3) mod 11 = 1, 4 is modulo inverse of 3(under 11).
        One might think, 15 also as a valid output as “(15*3) mod 11”
        is also 1, but 15 is not in range {1, 2, … 10}, so not valid.

        Input:  A = 10, M = 17
        Output: 12
        Explanation: Since (10*12) mod 17 = 1, 12 is modulo inverse of 10(under 17).


     */


    /*
    Coding Problem :

    Given two integers A and B. Find the value of A^-1 mod B where B is a prime number and gcd(A, B) = 1.

     A^-1 mod B is also known as modular multiplicative inverse of A under modulo B.

     Problem Constraints
    1 <= A <= 10^9
    1<= B <= 10^9
    B is a prime number
     */

    public static void main(String[] args) {

        int A = 12;
        int B = 55557209;

        // find X in  AX = 1(mod B).

        /*
        There are 3 methods to solve Modulo inverse
         */
        // Naive approach
        /*
            we know X will be in range [1,B-1]
            AX = 1 mod B

            taking mod on both side

            (AX)mod B = 1

            using for loop 1 to M-1, we can find X satisfying above equation.
         */
/*
        for(int X=1;X<B;X++){
            if((A%B * X%B)%B == 1){
                System.out.println(X);
                break;
            }
        }
        //TC:O(M)
        //SC: O(1)
*/

        /*
        We can also calculate Modular multiplicative inverse by using:

        ==>Extended Euler’s GCD algorithm --> having time complexity O(Log m) but this algorithm will only work
        when a and b are coprime.
        ==>Fermat’s Little theorem --> having time complexity O(Log m) but this will work only when b is prime.


         */

        // Fermat's little Theorem :

        /*we already know
          (A^M-1) = 1 mod M

          multiplying A^-1 on both side,

          A^-1 = A^M-2 mod M
         */


        System.out.println(power(A,B-2,B));

    }

    public static int power(int A, int B,int M){
        if(A==0)
            return 0;
        if(B==0)
            return 1;
        int ans = power(A,B/2,M)%M;
        if(B%2==0){
            ans = (ans * ans)%M;
        }else{
            ans= ((ans * ans)%M * A)%M;
        }
        return (int)ans;
    }




}
