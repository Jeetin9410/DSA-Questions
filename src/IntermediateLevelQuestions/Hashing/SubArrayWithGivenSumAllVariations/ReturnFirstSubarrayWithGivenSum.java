package IntermediateLevelQuestions.Hashing.SubArrayWithGivenSumAllVariations;

import java.util.Arrays;

public class ReturnFirstSubarrayWithGivenSum {

    /* The solution below , does not handle negative cases.

       To handle that.... Hashing approach solution will work.

     */

    /*
        Given an array of positive integers A and an integer B,
         find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
     */
    public static void main(String[] args) {
            int[] A = {10, 2, -2, -20, 10};
            int B = -10;
             //   Two pointers approach
            //// This approach not work if array element has negative values


            /*   Explanation :
               We will have a variable sum=0(this will store the sum of array elements)
               we will need 2 pointers let say start=0 and end=0.

              using while loop,  we will move end pointer till n
              and keep doing sum += A[i] if(end < n);

              case 1 : at some time doing above thing,
                       sum > target
                     which means that subarray from start to end is not what we are looking for.
                     then we will
                     reduce sum by A[start] and then
                     shift start one place ahead i.e start++;
                     what if , sum is still > target ==> then we again reduce sum by A[start] and start++;
                     this can be written as

                    while(sum > target){
                      sum = sum - A[start];
                      start++;
                    }
                    Note : the above loop also cross end point at some time, which we dont want so we will modify it like this
                    while(sum > target && start < end -1){
                      sum = sum - A[start];
                      start++;
                    }

               case 2 : sum == target
                        Now we have start and end pointer , we can have length wise comparision or we can print all subarrays as well












             */



        int start = 0, end = 1;

        int sum = A[0], n = A.length;

        while (end <= n) {

            while (sum > B && start < end - 1) {
                sum = sum - A[start];
                start++;
            }

            if (sum == B) {
                int [] ans = new int[end - start];

                for(int i = start ; i < end; i++)
                    ans[i- start] = A[i];

                System.out.println(Arrays.toString(ans));
            }

            if (end < n)
                sum = sum + A[end];

            end++;

        }

        System.out.println(-1);


  /* TC : O(N)

   */



    }
}
