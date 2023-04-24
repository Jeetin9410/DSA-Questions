package AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions;

public class isPrimeNumber_usingFermatLittleAlgorithm {

    /*
    Question : What is Fermat Little Theorem?
    Ans : Fermat little theorem is advance number system concept which talks about Prime number and their relations with
          other numbers.

          It states that if p is prime number , then for any integer a
          the number ((a^p) - a) is an integer multiple of p.

          In Modular arithmetic, this is expressed as :

          (a^p) = a (mod p)
          or simplfying that to

          (a^p-1) = 1(mod p)

          the above statement also tells that if a is not divisible by p.
          then a and p are co-prime.

          co-prime? means there GCD is 1.
     */
    public static void main(String[] args) {
        /*
        Acc to Fermat little theorem,
        A prime number can be represented as

        (a)^p-1 = 1 mod (p);
                OR

         (a)^n-1 % n = 1
         */

        int num = 561;

        System.out.println(isPrime(num));

    }

    public static boolean isPrime(int n){

       if(n<=1)
           return false;

       if(n==2)
           return true;
       else{
           int p = (int)(Math.pow(2,n-1))%n;
           if(p==1)
               return true;
           else
               return false;
       }
    }
}
