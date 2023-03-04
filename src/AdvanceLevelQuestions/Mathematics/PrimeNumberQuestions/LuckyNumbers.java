package AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions;

import java.util.Arrays;

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

        int A= 12;

        int[] factor = findFactorsTillN(A);

    }

    public static int[] findFactorsTillN(int N){

        int[] primeFactors = new int[N+1];

        Arrays.fill(primeFactors,1);  // marking all number till N as prime

        for(int i = 2; i<=N;i++){
            for(int j = 2*i; j<=N;j+=i){
                primeFactors[j] = 0;
            }
        }

        return primeFactors;
    }
}
