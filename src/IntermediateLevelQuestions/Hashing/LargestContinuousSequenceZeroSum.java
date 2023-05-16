package IntermediateLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    /*
    Given an array A of N integers.

    Find the largest continuous sequence in a array which sums to zero.

    1 <= N <= 106

    -10^7 <= A[i] <= 10^7

    Input Format
Single argument which is an integer array A.



Output Format
Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.



Example Input
A = [1,2,-2,4,-4]


Example Output
[2,-2,4,-4]


Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.
     */
    public static void main(String[] args) {

        int[] A = {1,-2,2,4,-4};

        int n = A.length;

     /*   int[] ps = new int[n];

        ps[0] = A[0];

        for(int i =1;i<n;i++){
            ps[i] = ps[i-1]+A[i];
        }


        HashMap<Integer,Integer> map = new HashMap<>();
        int len = 0;
        int left = -1;
        int right = -1;
        for(int i=0;i<n;i++){

            if(map.containsKey(ps[i])){
                int tempLen = i - map.get(ps[i]);
                if(tempLen > len){
                    len = tempLen;
                    right = i;
                    left = map.get(ps[i])+1;
                }
            }else{
                map.put(ps[i],i);
            }
        }

        // return Arrays.toString(Arrays.copyOfRange(A, left, right+1))

      //  System.out.println(Arrays.toString(ps));
        System.out.println(left+" "+right);
        System.out.println(Arrays.toString(Arrays.copyOfRange(A, left, right+1)));   */



        ////////////////////// The above code can be modified to this  //////////////////////////

        HashMap<Integer,Integer> map = new HashMap<>();
        int left = -1;
        int right = -1;

        //edge cases : there is no sub array with sum 0
        int len = 0;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum +=  A[i];

            if(map.containsKey(sum)){
                int olderIndex = map.get(sum);
                int tempLen = i - olderIndex;

                if(tempLen > len){
                    len = tempLen;
                    left = olderIndex + 1;
                    right = i;
                }
            }else{
                map.put(sum,i);
            }
        }

        // handling edge case

        if(left == -1){
            // means no subarray with zero sum
            //return new int[]{};
            System.out.println(Arrays.toString(new int[]{}));
        }else{
           // System.out.println(left+" "+right);
            System.out.println(Arrays.toString(Arrays.copyOfRange(A,left,right+1)));
        }
    }
}
