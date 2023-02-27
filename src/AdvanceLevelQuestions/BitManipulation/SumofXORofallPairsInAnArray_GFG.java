package AdvanceLevelQuestions.BitManipulation;

public class SumofXORofallPairsInAnArray_GFG {

    // DISCUSSED IN SCALER CLASS BIT MANIPULATION 1
    /*

    Given an array of n integers, find the sum of xor of all pairs of numbers in the array.


    Examples :

Input : arr[] = {7, 3, 5}
Output : 12
7 ^ 3 = 4
3 ^ 5 = 6
7 ^ 5 = 2
Sum = 4 + 6 + 2
    = 12

Input : arr[] = {5, 9, 7, 6}
Output : 47
5 ^ 9 = 12
9 ^ 7 = 14
7 ^ 6 = 1
5 ^ 7 = 2
5 ^ 6 = 3
9 ^ 6 = 15
Sum = 12 + 14 + 1 + 2 + 3 + 15
    = 47



     */

    public static void main(String[] args) {


        // Approach 1: Naive approach.
        // A Brute Force approach is to run two loops and time complexity is O(n^2).

        //Appraoch 2 : Efficient Approach.

        /*
        This question is bit similar to DifferentBitSumPairWise
         */

        /*

        Concept  :
        Optimized solution will be to try bit manipulation. To implement the solution,
        we consider all bits which are 1 and which are 0 and store their count in two different variables.
         Next multiple those counts along with the power of 2 raised to that bit position. Do this for all
         the bit positions of the numbers. Their sum would be our answer.

         For example, look at the rightmost bit of all the numbers in the array. Suppose that a numbers have
         a rightmost 0-bit, and b numbers have a 1-bit. Then out of the pairs, a*b of them will have 1 in the
         rightmost bit of the XOR. This is because there are a*b ways to choose one number that has a 0-bit
         and one that has a 1-bit. These bits will therefore contribute a*b towards the total of all the XORs.

            Explanation :  arr[] = { 7, 3, 5 }
                                    7 = 1 1 1
                                    3 = 0 1 1
                                    5 = 1 0 1

                                For bit position 0 :
                                Bits with zero = 0
                                Bits with one = 3
                                Answer = 0 * 3 * 2 ^ 0 = 0

                                Similarly, for bit position 1 :
                                Bits with zero = 1
                                Bits with one = 2
                                Answer = 1 * 2 * 2 ^ 1 = 4

                                Similarly, for bit position 2 :
                                Bits with zero = 1
                                Bits with one = 2
                                Answer = 1 * 2 * 2 ^ 2 = 8

                                Final answer = 0 + 4 + 8 = 12

                                for every i th bit
                                formula  = (no_Of_set_Bit)*(no_Of_Unset_Bit)*(pow(2,i))


         */
            int[] arr = {1,3};
            long ans=0;
            for(int i =0;i<32;i++){
                int countOnes =0;
                long idsum = 0;
                for(int j = 0;j< arr.length;j++){
                    if ((arr[j] & (1<<i))!=0) {
                        countOnes++;
                    }
                }
                idsum= countOnes * (arr.length-countOnes) * (1<<i);

                ans+= idsum;
            }
        System.out.println(ans);
    }

}
