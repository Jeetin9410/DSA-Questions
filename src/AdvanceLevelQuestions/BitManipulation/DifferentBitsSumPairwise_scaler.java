package AdvanceLevelQuestions.BitManipulation;

public class DifferentBitsSumPairwise_scaler {


    //// Same Question : Total Hamming Distances on leetcode.

    /*
    We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
    For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively.
     The first and the third bit differ, so f(2, 7) = 2.

    You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j)
    such that 1 ≤ i, j ≤ N. Return the answer modulo (10^9)+7.

    1 <= N <= 105

    1 <= A[i] <= 2^31 - 1

    Input Format
    The first and only argument of input contains a single integer array A.

    Output Format
    Return a single integer denoting the sum.

    Example Input
    Input 1: A = [1, 3, 5]
    Input 2: A = [2, 3]


    Example Output
    Output 1: 8
    Output 2: 2

    Example Explanation
    Explanation 1:

     f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5)
     = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
    Explanation 2:

     f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2


     */
    public static void main(String[] args) {

        int[] A = {4,14,2};

        // Approach 1 : using nested for loop and counting bit difference for all pairs.
        // TC: O(N*N)


        // Approach 2 : Doing it in less then O(N*N)

        /*
        So let us consider above example A = {1,3,5}
    i th
   position->3 2 1 0
    (a) 1 == 0 0 0 1
    (b) 3 == 0 0 1 1
    (c) 5 == 0 1 0 1

        Concept :

        logic : let us have 1 st bits of all numbers i.e  0 , 1  , 0.

              so let us seprate these on basis of bit

              (Set bit)     (unset bit)
              List I       List II
               a              b
               c

             what are total possible combinations we can have here which  will have different bit?
             ab  ba  ->2
             cb  bc  ->2
             total --->4  (at 1st bit)

             let us have 2nd bit of all numbers i.e 0, 0, 1

             (Set bit)     (unset bit)
              List I       List II
               c              a
                              b

              possible combinations are : ca   ac  --> 2
                                          cb   bc  --> 2
                                            total  --> 4

             What we observed here?

            total no of different set bit :  (Total no of set bit) * (Total no of unset bit) * 2
            Example :  for 0th bit --->      3 * 0 * 2 = 0
                       for 1st bit --->      1 * 2 * 2 = 4
                       for 2nd bit --->      1 * 2 * 2 = 4
                       for 3rd bit --->      0 * 3 * 2 = 0

                So total sum of different bit ===>      8

            So what we are going to do is :
             we know int can be expressed in 32bit binary format.
             so we will start a loop from 0 to 32
             inside which we will count the set bit at i th position of every element in given array
             let the total set bit are ==> count
             so total unset bit will be ==> (arr.length - count)

            so total no different bit at i th position will be : ( count ) * ( arr.length - count ) * 2

            and now doing this till i= 32, will give us required as.
         */

        int ans = 0;
        for(int i =0; i<32; i++){
            int count = 0;
            for(int j=0; j< A.length; j++){
                if((A[j] & (1<<i))!=0 ){
                    count++;
                }
            }
            ans+= count * (A.length-count) * 2;
        }

        System.out.println(ans);
    }



}
