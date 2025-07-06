package old.IntermediateLevelQuestions.Hashing;

import old.IntermediateLevelQuestions.Recursion.IsMagicalNmber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SubArrayWithSumZero {
    /*
    Given N array elements , check if there exist a subarray with sum = 0;

        Given an array of integers A, find and return whether the given array contains a non-empty subarray
    with a sum equal to 0.

    If the given array contains a sub-array with sum zero return 1, else return 0.

    arr = {2,2,1,-3,4,3,1,-2,-3,2}
     */
    public static void main(String[] args) {

        int[] A = {2,2,1,-3,4,3,1,-2,-3,2};

        /* Concept in this question :
          1) Find prefix sum array
          2) Logic:
             a)  if ps[] has any 0 in it ===> it means there is subarray with sum = 0;
             b) if ps[] has any repeating elements  == > it also means between those numbers, there exist a
                                                         subarray with sum = 0
         3)  if any of these condition exist return true else false;
         */

        int n = A.length;

       /* int[] ps = new int[n];

        ps[0] = A[0];

        for(int i=1;i<n;i++){
            ps[i] = ps[i-1] + A[i];
        }

       // System.out.println(Arrays.toString(ps));

        boolean ans = false;
        HashSet<Integer> set = new HashSet<>();
        for( int i : ps){
            if(i==0){
                ans = true;
                break;
            }
            set.add(i);
        }

        if(ans || set.size() < ps.length){
            System.out.println("True");
        }else{
            System.out.println("False");
        }*/

        ///////  The above code can be modified to this, we can eleminated the for loop for ps

        HashMap<Integer,Integer> map = new HashMap<>();  // sum , and frequency of that sum
        int pref = 0;
        boolean status = false;
        for(int i=0;i<n;i++){
            pref = pref + A[i];
            if(map.containsKey(pref)){
                status = true;
                break;
            }else {
                map.put(pref,1);
            }
        }

        if(status){
            System.out.println(1);
        }else{
            System.out.println(0);
        }





    }
}
