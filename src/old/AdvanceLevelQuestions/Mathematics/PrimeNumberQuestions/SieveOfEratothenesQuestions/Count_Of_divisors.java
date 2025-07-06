package old.AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions.SieveOfEratothenesQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Count_Of_divisors {
     /*
     Given an array of integers A, find and return the count of divisors of each element of the array.

      NOTE: The order of the resultant array should be the same as the input array.

      Problem Constraints:
        1 <= length of the array <= 100000
        1 <= A[i] <= 10^6

      Example Input
        Input 1: A = [2, 3, 4, 5]
        Input 2: A = [8, 9, 10]


        Example Output
        Output 1: [2, 2, 3, 2]
        Output 1: [4, 3, 4]


      */
     public static void main(String[] args) {
         int[] A = {2,3,4,5};

         /*
         Intution 1 :
         like sieve of erastroneses ,
         we gonna find no of factor till number maxmimum number of arr.
         and then simply collect the required ans in seperate array


          */


         // find max of Arr
         int max = A[0];
         for(int val : A){
             max = Math.max(max,val);
         }


         //now we will find factors of all number till N

         int[] factors = new int[max+1];
         // factor of 0 and 1 will be 1
         factors[0] = 1;
         factors[1] = 1;

         // rest from 2 to N , every num has minimum of 2 factors

         Arrays.fill(factors,2,max+1,2);

         //now we find factors for each value and increment it

         for(int i = 2 ; i<=max;i++){
             for(int j = 2*i;j<=max;j+=i){
                 factors[j]++;
             }
         }

         // now we will find ans for asked values of arr

         int[] ans = new int[A.length];
         for(int i = 0;i< ans.length;i++){
             ans[i] = factors[A[i]];
         }

         System.out.println(Arrays.toString(ans));


     }
     //



}
