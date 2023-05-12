package AdvanceLevelQuestions.TwoPointers;

import java.util.*;
public class PairsWithGivenDifference {
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

            int n = A.length;
            int count = 0;

            /// Optimal approach
       /* Using HashMap

         first we traverse entire array and store all the numbers with there occurence

         now for every element we will check if (A[i] + B) exist in map or not.
         if yes, then count++

         now edge case , if B==0
         then check if  frequence of any number is in multiple of 2 then store that.


        */


      //  int n = A.size();
     //   int count = 0;

        // count frequency of every element
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : A){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i) + 1);
            }else{
                hm.put(i, 1);
            }
        }

        // storing only distinct element
        HashSet<Integer> hs = new HashSet<>();
        for(int i : A){
            if(!hs.contains(i)){
                hs.add(i);
            }
        }

        // Arraylist is store all the all the distict element from hashset, which we will use to iterate
        ArrayList<Integer> ans = new ArrayList<>(hs);

        /*Finding ans logic
         if B == 0, we will check if there are any two same elements or the count of same element is greater than 1. Eg - 1 1 1 1 2 2 2  and B is 0......... so count of 1 = 4 and count of 2 = 3; ans would be (1-1) and (2-2) only 2 paris.
ans in this case

*/
        for(int i : ans){
            if(B == 0){
                if(hm.get(i) > 1){
                    count++;
                }
            }else{
                if(hm.containsKey(B+i)){
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
