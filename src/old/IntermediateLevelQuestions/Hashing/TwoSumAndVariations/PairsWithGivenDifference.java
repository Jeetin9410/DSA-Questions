package old.IntermediateLevelQuestions.Hashing.TwoSumAndVariations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PairsWithGivenDifference { /// Very Very Good Question
    /*
Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y),
where x and y are both numbers in the array and their absolute difference is B.

1 <= N <= 10^4

0 <= A[i], B <= 10^5


Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0
     */

    public static void main(String[] args) {
        int[] A = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        int B = 3;

        // ans = 7

        // Brute force appraoch :
        /*
           using nested for loops, to find
           A[j] - A[i] = k

           Tc : O(N*N)
         */

        // Approach 2 : O(nLogn)
        /* Using Binary search

           Step 1 : Sort the array
           step 2 : Now we will use for loop
                    and for every element we will binary search the (A[i] + B) element
                    if found
                       then we will store the min(A[i]+B, A[i])  , which will be A[i] always
                       in HashSet
                       Ques:  Why doing so?
                   Ex 1 1 3 4 5  B = 2

             i=0,  (1,3) will be a pair     we stored min(1,3) in set , set = [1]
             i=1,  (1,3) will be a pair BUT not unique this time,   set = [1]
             i=2   (3,5) will be a pair,    set = [1,3]
             i=3   no pair found
             i=4  no pair found

           So unique pairs are set.size()==>2
           step 3 : Finally return set.size();

            TC : O(NLogN)


         */
      /*  int n = A.length;
        Arrays.sort(A);
        HashSet<Integer> mSet  = new HashSet<>();

        for (int i=0;i<n;i++){
            if(Arrays.binarySearch(A,i+1,n,A[i]+B) > 0){
                mSet.add(A[i]);
            }
        }

        System.out.println(mSet.size()); */



        /////////////  Appraoch 3 : O(N)  ///////////////////

        int n = A.length;
        int count = 0;

        /// Optimal approach
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0;i<n;i++){
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i : A){
            if(!set.contains(i)){
                set.add(i);
            }
        }

        // storing these unique element in arraylist

        ArrayList<Integer> ans  = new ArrayList<>(set);

        for(int i : ans){
            if(B==0){  // same occurrence
                if(map.get(i)>1){
                    count++;
                }
            }else{
                if(map.containsKey(A[i]+B)){
                    count++;
                }
            }
        }

        System.out.println(count);


    }

}
