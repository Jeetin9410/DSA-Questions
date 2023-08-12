package AdvanceLevelQuestions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class RelativeSortArray {
/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.


Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]


Constraints:

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.
     */

    public static void main(String[] args) {
        /*
        Intuition1 : Save Arr 1 in hashmap with element and its frequency
                    Now iterating in arr2 , for every element if that exist in hashmap we will add that element in
                    an array , no of times equivalent to its frequency
                    if not exist then we will separate it in another array so that it can be appended later in
                    array.


         */

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};

        int[] arr2 = {2,1,4,3,9,6};


        HashMap<Integer,Integer> map = new HashMap<>();

        for(int val : arr1){
              map.put(val, map.getOrDefault(val, 0) + 1);
        }

        System.out.println(map.toString());

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> notCommon = new ArrayList<>();

        for(int val : arr2){
            if(map.containsKey(val)){
                int count = map.get(val);
                while(count>0){
                    ans.add(val);
                    count--;
                }
                map.remove(val);
            }
        }

       map.forEach((key,value)->{
           ans.add(key);
       });

        System.out.println(Arrays.toString(ans.toArray()));
    }
}