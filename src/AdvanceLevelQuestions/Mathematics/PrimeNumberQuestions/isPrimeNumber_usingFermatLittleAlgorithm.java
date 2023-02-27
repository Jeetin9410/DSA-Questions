package AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions;

public class isPrimeNumber_usingFermatLittleAlgorithm {
    public static void main(String[] args) {
        /*
        Acc to Fermat little theorem,
        A prime number can be represented as

        (a)^p-1 = 1 mod (p);
                OR

         (a)^n-1 % n = 1
         */

        int num = 11;

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
