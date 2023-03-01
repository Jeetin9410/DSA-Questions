package AdvanceLevelQuestions.Mathematics.ModuloOperator;

import java.util.Arrays;
import java.util.HashMap;

public class CountNoOfPairs_VeryGoodQues {
    /*
    Problem statement :
    Given N array elements, Calculate the no of pairs (i,j) such that
    (a[i] + a[j]) % M = 0    such that i != j
    note : (i,j) = (j,i) considered same pair
     */
    public static void main(String[] args) {

        int[] A = {1,2,3,4,5};
        int M = 2;

        // Brute force
     /*   int count = 0;
        for(int i=0;i< A.length;i++){
            for(int j=i+1;j< A.length;j++){
                if((A[i]+A[j])%M== 0){
                    count++;
                }
            }
        }
        System.out.println(count);
       */


        /*

        let us understand the equation carefully

       ( A[i] + A[j] ) % M = 0

       it can be written as

      ( A[i]%M + A[j]%M ) % M = 0

      and we A % M represents the reminder

      So we will find the reminder for all elements in array.
      Ques : Why? it is because ,if suppose A[i]%M is 2 then (A[i]+A[j])%M  to be 0,
                                            A[j]%M is 8
            which means all the numbers which give reminder 2   can be paired with all the numbers that give 8 as reminder

            and that will make a pair.

           Example :

           A = {29,11,21,17,2,5,4,6,23,13,26,14,18,15,30,35,50,20,40};

           let us create an array which holds how many number leaves reminder from [0 to 9]

      reminder ==  0   1   2   3   4   5   6   7   8   9

           arr ==  4   2   1   2   2   3   2   1   1   1

     elements ==  30  11   2  23   4   5   6   17  18  19
                  50  21      13   14  15  26
                  20                   35
                  40

    observation == all the element whose reminder is 1 pair with all element of whose reminder 9

                * pairs of reminder 1 & 9 ==>   (11,19), (21,19)
                * pairs of reminder 2 & 8 ==>   (2,18)
                * pairs of reminder 3 & 7 ==>   (23,17),(13,17)
                * pairs of reminder 4 & 6 ==>   (4,6),(4,26),(14,6),(14,26)

                ==> now what for 0 and 5?
                in case of 0 and 5 , there elements will pair with others in same reminder category,like
                all 4 elements in reminder 0 will pair with each other. and same goes with 5.

                *pairs of reminder 0 ==> (30,50),(30,20),(30,40),(50,20),(50,40),(20,40)
                *pairs of reminder 5 ==> (5,15),(5,35),(15,35).


                 special condition for 0 will always be there, so it can be found out with
                  total pair with reminder 0==>   A[0]*(A[0] - 1) / 2

                  Now special condition for 5 OR WE can say middle will occur if M is even only.
                  cause, 0 will be always special case and removing that out , we get all pairs in case of M being
                  odd.
                  so to calculate that (only when M is even)

                 if(M%2==0){
                  a = A[M/2];
                  ans += a*(a-1);
                  }

                So total pairs : 2 + 1 + 2 + 4 + 6 + 3
                               = 18Ans.


        Ques : How to code it?

        step 1: instead of using arr,we can use HashMap (let us that map)
               Rem , count
        Hashmap<int, int> map = new HashMap<>();

        for(int i=0;i<A.length;i++){
        if(map.contains(A[i]){
          map.put(A[i],get(A[i])+1)
        }else{
        map.put(A[i],0);
        }


        step 2 : Counting pair  for index(i > 0 and j>arr.lng)
         i=1;j=M-1
         while(i>j){
         ans += arr[i] *arr [j]
         i++;
         j--;
         }

         step 3 : for reminder = 0
         a = A[0]
         ans = ans + a(a-1)/2;

         step 4: special condition if M is even

            if(M%2==0){
                  a = A[M/2];
                  ans += a*(a-1);
                  }



         */

        long pairsCount= 0;


      /*

         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // reminder will be in range [0,9]
        // mapping reminder and the total no of element they are obtained from.

      for(int i = 0; i< A.length;i++){
            if(map.containsKey(A[i]%M)){
                map.put(A[i]%M, map.get(A[i]%M)+1);
            }else{
                map.put(A[i]%M,1);
            }
        } */

         /*
                          THE ERROR IN ABOVE LOGIC

                          WHAT IF THERE IS NO 0 REMINDER FOR GIVEN ARRRAY,THEN IT WILL CRASH
                          SO TO CORRECT THAT WE WILL RECORD VALUES FOR ALL VALUES OF REMINDER
                          NOW THIS CAN BE DONE USING ARRAY OR HASHMAP

                          BOTH WILL TAKE SAME SPACE

          */



        long[] count = new long[M];

        Arrays.fill(count,0);

        for(int i =0;i<A.length;i++){
            int rem = A[i] % M;
            count[rem]++;
        }


        //  for STARTING INDEX, IT NEED NOT TO BE 0 EVERY TIME

        long a = count[0];
        pairsCount += (a*(a-1))/2;

        // for reminder > 0

        int i =1 , j = M-1;

        while(i<j){
            pairsCount += count[i] * count[j];
            i++;
            j--;
        }

        // for middle index condition

        if(M%2==0){
            long val = count[M/2];
            pairsCount += (val*(val -1))/2;
        }

        System.out.println(pairsCount%1000000007);

        /// CORRECT ANSWER

        /// TC : O(N + M)
        /// SC:  O(M)


    }
}
