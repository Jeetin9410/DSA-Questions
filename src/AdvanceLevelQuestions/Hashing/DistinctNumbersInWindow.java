package AdvanceLevelQuestions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DistinctNumbersInWindow {
    /*
You are given an array of N integers, A1, A2 ,..., AN and an integer B.
Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements
in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.

Problem Constraints
1 <= N <= 10^6

1 <= A[i] <= 10^9

Example Input
Input 1:

A = [1, 2, 1, 3, 4, 3]
B = 3
Input 2:

A = [1, 1, 2, 2]
B = 1


Example Output
Output 1:

[2, 3, 3, 2]
Output 2:

[1, 1, 1, 1]


Example Explanation
Explanation 1:

A=[1, 2, 1, 3, 4, 3] and B = 3
All windows of size B are
[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]
So, we return an array [2, 3, 3, 2].
Explanation 2:

Window size is 1, so the output array is [1, 1, 1, 1].



 */
                                           // Very Good Question
    public static void main(String[] args) {

        int[] A = {1,2,1,3,4,3};
        int B = 3;
        int N = A.length;

       /* int n = A.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] ans = new int[n-B + 1];

        if(B > n)
            return;

        HashSet<Integer> set = new HashSet<>();

        for (int i=0;i<B;i++){
            set.add(A[i]);
        }
        list.add(set.size()); // first window

        for(int i = 0,j=i+B-1; i< n-B+1;i++,j++){
            System.out.println(Arrays.toString(Arrays.copyOfRange(A,i,j+1)));

        }

        System.out.println(Arrays.asList(list));
        */

        /*
           The above was in correct direction , using hold and release strategy BUT Some changes are required
           Which are as follows : */

          /* Appraoch :
          Step1: We will take a HashMap, to record the element and its occurence till iteration i
           Step 2: put intial B values in Hashmap with their frequency.

           ste 3 :  use another loop as described below :

           now we will put our index j at k position (last position of window), and will move it till A.length
           along with that we will check for j-k position ( i.e first position of window)
           for j-k we are going to perform release element , so
           if element at j-k index in A already existed in Hashmap we will remove its frequency by 1, or remove it
           and add the element at j or increase its frequency in hashmap at every iteration , keep set size in arraylist.
         */
        int[] ans = new int[N-B+1];
        if(B > N)
            return;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<B;i++){
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }

        int k =0;
        ans[k++] = map.size();

        for(int i =B; i<A.length;i++){
            if(map.containsKey(A[i-B])){
                if(map.get(A[i-B]) == 1){
                    map.remove(A[i-B]);
                }else{
                    map.put(A[i-B], map.get(A[i-B]) - 1);
                }
            }
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);

            ans[k++] = map.size();
        }

        System.out.println(Arrays.toString(ans));
    }
}
