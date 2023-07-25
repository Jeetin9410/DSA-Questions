package AdvanceLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class LongestContinuousSequence {
    /*
        Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from array A.

1 <= N <= 10^6

-10^6 <= A[i] <= 10^6

Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input
Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2].

     */
    public static void main(String[] args) {
        int[] A = {100,4,200,3,2,1 } ;
        /*
     This approach won't work due to duplicates
     Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int count = 1;
        for(int i =1;i<A.length;i++){
            if(A[i]-A[i-1] == 1){
                count++;
            }
        }

        System.out.println(count);*/


        ////////25-07-2023////

        ////////// This solution will also work

        /// This idea came to my mind , due to Unordered nature of set.
        /// Here I was trying to implement the solution using SortedSet which stores the values in sorted manner
        //// Issue  here : Here Add() time complexity is O(logn) so for adding n element it will take nLogn, which itself disqualify this solution.

       // SortedSet<Integer> set = new TreeSet<>();
      /*  for(int val : A){
            set.add(val);
        }
*/


        /////////////  OPTIMAL SOLUTION  //////////////

        /*

        set = {100, 4 , 200, 3, 2, 1}
              for 100 , we find 99, 101 in set
              first we find 99, that does not exist, it means there is no previous number
              so we check if 101 exist or not, if exist then we will keep checking the curent + 1 in set
              this means 100 is the smallest one and after it all number are consecutive till we are able to find currentNum + 1 in set

           so doing above task for i =0 i.e 100,  we find out that no previous number existed, and in case if 99  existed we will move to next number
           Ques Why we are moving ? if we find previous smaller number
           Ans : Reason is, if 99 already exist in set, so that means when we reach 99 we will also check for 99 +1 , and 100 will be there and if 100 exist
                            we check 101, so no till the number not exist in set, and doing this process we also increment the length.

           for i=1, i.e 4, --> 4-1 = 3 exist we will move to next number because we know when that numbwr will come we automaticaly reach to 4 just by doing+1
           for i=2, i.e 200 --> 199 not exist, to there is chance that 200 might give us a longest consecutive number list, cause there is no shorter number just before 200 is available.
                        so we check else case :
                        here we will check if 200 + 1 exist or not, if exist then keep checking for next number in set untill number not exist in set condition occurs.
          for i=3, i.e 3, --> 2 exist so move to next number
          for i=4, i.e 2 --> 1 exist so move to next number.
          for i=5, i.e 1, 0 not exist so check 2  len = 1
                          2 exist --> len++, if 3 exist , len = 2
                          3 exist --> len++ , if 4 exist, len = 3
                          4 exist --> len++, if 5 exist,  len = 4
                          5 not exist --> dont do anything
         final len is answer.
         */


        HashSet<Integer> set = new HashSet<>();

        for (int val : A){
            set.add(val);
        }

        int maxLen = 1; /// cause single element is also len 1

        for(int i =0;i< A.length;i++){
            int currentNum = A[i];
            if(set.contains(currentNum - 1)){
                continue;
            }else {
                int count =1;
                int nextElement = currentNum+1;
                while(set.contains(nextElement)){
                    nextElement++;
                    count++;
                }
                maxLen = Math.max(maxLen,count);
            }
        }

        System.out.println(maxLen);
    }
}
