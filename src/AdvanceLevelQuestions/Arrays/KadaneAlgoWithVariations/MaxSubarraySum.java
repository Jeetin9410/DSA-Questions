package AdvanceLevelQuestions.Arrays.KadaneAlgoWithVariations;

public class MaxSubarraySum {
    /*
      for Given Array you have to find the maximum sum possible of subarray.
      return that sum.
     */
    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, -10};
        int size = A.length;

        // Brute force

        /*
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<size;i++){
            int tempSum = 0;
            for(int j =i+1;j<size;j++){
                for(int t =i;t<=j;t++){
                    tempSum = tempSum + A[t];
                }
                maxSum = Math.max(tempSum,maxSum);

            }
        }

        System.out.println(maxSum);

         */

        /* Method 2 */

        /*
        Trying this with prefix sum array.
        Why? cause if we look closely we can === the sum till i index is sum till (i-1) and i th value itself.
         */

      /*  int[] ps = new int[size + 1];
        ps[0] = 0;
        for(int i =0;i< ps.length-1;i++){
            ps[i+1] = ps[i] + A[i];
        } */

       // for()


        int currentSum = 0;
        int sum =Integer.MIN_VALUE;

        for(int i = 0; i<size; i++){
            currentSum = currentSum + A[i];
            if(currentSum > sum){
                sum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }

        System.out.println(sum);

    }
}
