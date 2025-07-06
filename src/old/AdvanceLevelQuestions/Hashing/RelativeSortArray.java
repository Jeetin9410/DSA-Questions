package old.AdvanceLevelQuestions.Hashing;

import java.util.*;

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


      /*  HashMap<Integer,Integer> map = new HashMap<>();

        for(int val : arr1){
              map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int[] ans = new int[arr1.length];
        int index = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>(map);
        for(int i : arr2){
            if(tm.containsKey(i)){
                for(int j = 0; j < tm.get(i); j++){
                    ans[index++] = i;
                }
                tm.remove(i);
            }
        }
        for (int i : tm.keySet()) {
            int freq = tm.get(i);
            for (int j = 0; j < freq; j++) {
                ans[index++] = i;
            }
        }
        System.out.println(Arrays.toString(ans));


        */
       // Issue in above solution was that because HashMap does not save values in ordered way
       // So We need to solve that using TreeMap also


     /*   HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : arr1){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>(hm);
        for(int i : arr2){
            if(tm.containsKey(i)){
                for(int j = 0; j < tm.get(i); j++){
                    ans[index++] = i;
                }
                tm.remove(i);
            }
        }
        for (int i : tm.keySet()) {
            int freq = tm.get(i);
            for (int j = 0; j < freq; j++) {
                ans[index++] = i;
            }
        }
        System.out.println(Arrays.toString(ans));
    */
        //The above solution works perfect but only issue is that it is not optimised

        //////////////////// Method 3 : Using Arrays Only ///////////////////////

        /*

        The given problem asks to sort the elements of arr1 such that their relative ordering matches
        that of arr2. Here's a detailed description of the approach used in the provided code:

1) Initialize an array arr of size 1001 to count the occurrences of each element in arr1.
The index of arr represents the element value, and the value at that index represents the count.

2) Traverse through arr1 and increment the count in arr for each element encountered.

3) Create a result array res of the same length as arr1.

4) Initialize a variable i to keep track of the current index in res.

5) Traverse through arr2 to maintain the relative ordering specified by arr2.
    a) For each element num in arr2, while the count of num in arr is greater than 0:
            --Set res[i] to num.
            --Decrement the count of num in arr.
            --Increment i.
6) After processing all elements in arr2, iterate through arr to handle the remaining elements
that were not in arr2.
    a) For each index j in arr, while the count at arr[j] is greater than 0:
            --Set res[i] to j.
            --Decrement the count of j in arr.
            --Increment i.
7) Return the resulting array res.

         */

        /// Below solution is only possible
       /// 0 <= arr1[i], arr2[i] <= 1000
       //// If this was higher number then TreeMap will be the optimal solution.
        int[] arr = new int[1001];

        for(int num : arr1)
            arr[num]++;

        System.out.println(Arrays.toString(arr));

        int[] res = new int[arr1.length];

        int i = 0;

        for(int num : arr2){
            while(arr[num] > 0){
                res[i] = num;
                arr[num]--;
                i++;
            }
        }

        for(int j = 0; j < arr.length; j++){
            while(arr[j] > 0){
                res[i] = j;
                arr[j]--;
                i++;
            }
        }

      //  System.out.println(Arrays.toString(res));

    }
}