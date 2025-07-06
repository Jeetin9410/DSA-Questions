package old.AdvanceLevelQuestions.Mathematics.GCD;

import java.util.Arrays;
import java.util.HashSet;

public class LargestCoprimeDivisor {

    /*
    You are given two positive numbers A and B . You need to find the maximum valued integer X such that:

    X divides A i.e. A % X = 0
    X and B are co-prime i.e. gcd(X, B) = 1

    Example Input

Input 1:
 A = 30
 B = 12

Input 2:
 A = 5
 B = 10


Example Output

Output 1:
 5
Output 2:
 1

     */
    public static void main(String[] args) {
            int A = 921127411;
            int B = 8745993;

     /*
     Intuition :
     find the prime factors of A
     then find which prime factor of A gives gcd(X,B)=1


     Error in intuition : We have to consider all the factors not just prime factor
      */


         // the below factors method worked fine for easy cases but got TLE for har cases , ans is correct but TLE is Occuring
      //  System.out.println(factors(A,B));


        // optimised solution
        while (gcd(A, B) != 1) {
            A = A/gcd(A, B);
        }

        System.out.println(A);


    }

    public static int gcd(int a,int b){
           if(b==0){
               return a;
           }
           return gcd(b,a%b);
    }


    public static int factors(int num,int B){
        int max = 1;
        for(int i = 1;i<=num;i++){
            if(num%i == 0){
                if(gcd(i,B)==1){
                    max = Math.max(max,i);
                }
            }
        }
        return max;
    }


}
