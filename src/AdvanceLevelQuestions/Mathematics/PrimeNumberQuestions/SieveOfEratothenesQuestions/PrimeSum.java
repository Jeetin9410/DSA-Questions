package AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions.SieveOfEratothenesQuestions;

import java.util.Arrays;

public class PrimeSum {
    /*
    Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.
NOTE: A solution will always exist. Read Goldbach's conjecture.

4 <= A <= 2*10^7

Example Input :  4

Example Output: [2, 2]


Example Explanation:  There is only 1 solution for A = 4.


     */

    public static void main(String[] args) {

        int A = 100;

        /*
        Intuition :
        find prime number till A

        then for i from 2,N
        i and (A-i) must both be prime in prime array.

         */

        /*         THEORY ABOUT PRIMES

        --> Except 2 all the prime numbers are odd.



         */

        int[] prime = sieveOfEratosene(A);
        int[] ans = new int[2];
        for(int i =2;i< prime.length;i++){
            if(prime[i] == 1 && prime[A-i]==1){
                ans[0] = i;
                ans[1] = A-i;
                break;
            }

        }

        System.out.println(Arrays.toString(ans));


    }
    public static int[] sieveOfEratosene(int N){
        int[] ans = new int[N+1];
        Arrays.fill(ans,1);

        for(int i = 2;i<=N;i++){
            for(int j=2*i;j<=N;j+=i){
                ans[j] = 0;
            }
        }
        return ans;
    }
}
