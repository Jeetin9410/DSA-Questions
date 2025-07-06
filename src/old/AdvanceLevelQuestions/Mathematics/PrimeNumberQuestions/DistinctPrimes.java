package old.AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions;

import java.util.*;

public class DistinctPrimes {

    /*      V v v v v Good question
    You have given an array A having N integers. Let say G is the product of all elements of A.

You have to find the number of distinct prime divisors of G.


1 <= N <= 1e5
1 <= A[i] <= 1e5
For Example

Input:
    A = [1, 2, 3, 4]
Output:
     2

Explanation:
    here G = 1 * 2 * 3 * 4 = 24
    and distinct prime divisors of G are [2, 3]
     */
    public static void main(String[] args) {
        int[] A = {96, 98, 5, 41, 80};

        /// approach
        /*  we will find the prime factors of each element of given array and every factor will be added into
        a HashSet so that only unique prime factors are added.

         */
        HashSet<Integer> primes= new HashSet<>();
        for(int i = 0;i<A.length;i++){
            int num = A[i];
            for(int j=2; j*j<=num;j+=2){
                if(num%j==0){
                    primes.add(j);
                    while (num%j==0){
                        num = num/j;  // reducing that number by the prime factor j till it can divide
                    }
                }
            }
            if(num > 1){           // if num !=0 means num itself is prime as well
                primes.add(num);
            }
        }

        System.out.println(primes.size());
    }

}
