package old.AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions.SieveOfEratothenesQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LuckyNumbers {
    /*
    A lucky number is a number that has exactly 2 distinct prime divisors.

You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

1 <= A <= 50000

Example Input
Input 1: A = 8
Input 2: A = 12


Example Output
Output 1: 1
Output 2: 3
     */

    public static void main(String[] args) {
        /*
        Intuition:

        ==>   A lucky number is a number that has exactly 2 distinct prime divisors.

        Like sieve of Eratosenes :

        we are going to use all the prime factors till N.

        then use those factors to match required condition

         */



        int A= 3;

        if(A<4){
            System.out.println(0);
            return;
        }

        int[] prime = PrimeNumberTillN(A);
       int ans = ModifiedSieveOfErastosethenes(A,prime);

        System.out.println(ans);

    }

    public static int ModifiedSieveOfErastosethenes(int A,int[] isPrime){
        // instead of storing the number is prime or not we will store how many time it got divided by other numbers
        int[] ans = new int[A+1];
        Arrays.fill(ans,0);
        ///// here we stored the number of prime factor these number have,

        /*
          AS we have hardcoded data for some values i.e i<4 this code will give runtime error so add this edge cases saperate
         */
        ans[0] = 0;
        ans[1] = 0;
        ans[2] = 1;
        ans[3] = 1;
        for(int i=2;i<=A;i++){
                for(int j=2*i;j<=A;j+=i){       // here we are going same as sieve of Erathosenes but couting the factors
                    if(isPrime[i]==1){          // at this step we are checking the factor is prime or not if yes then only we are increasing its count;
                        ans[j]++;
                    }
                }
        }


        int count = 0;
        for(int i = 0;i< ans.length;i++){
            if(ans[i]==2){
                count++;
            }
        }

        return count;

    }

    public static int[] PrimeNumberTillN(int A){
        int[] ans =new int[A+1];
        Arrays.fill(ans,1);
        for(int i=2;i<=A;i++){
            for(int j=2*i;j<=A;j+=i){
                ans[j] = 0;
            }
        }
        return ans;
    }
}
