package old.AdvanceLevelQuestions.BinarySearch.HardLevel;

public class PainterPartitionProblem {
    /*

Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1].
There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints
that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter,
   and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3
   but not 2 is invalid.

Return the ans % 10000003.

1 <= A <= 1000
1 <= B <= 10^6
1 <= N <= 10^5
1 <= C[i] <= 10^6


Example Input
Input 1:

 A = 2
 B = 5
 C = [1, 10]
Input 2:

 A = 10
 B = 1
 C = [1, 8, 11, 3]


Example Output
Output 1:

 50
Output 2:

 11


Example Explanation
Explanation 1:

 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50 % 10000003
Explanation 2:

 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11 % 10000003


     */

    public static void main(String[] args) {
        int[] C = {1, 8, 11, 3};
        int A = 10;  // no of painters
        int B = 1;   // the work they do in unit time.


        /* First we need to carefully observe the given inputs
           We are given a variable B : Which refers to ==> time taken by each painter to paint 1 unit of board.

           and we need to find ==> minimum time required to paint all boards under the constraints.

           So firstly we need to convert this Array C in time reference, means idea is to multiply B in every C[i]
           to have an array which will denote that C[i] is the total time required to complete all the boards

         */
        int n = C.length;
        long[] c1 = new long[n];
        long sum = 0;
        for(int i =0;i<n;i++){
            c1[i] = C[i]*B;
            sum += C[i]*B;
        }

        long start = 0;
        long end = sum;

        long ans=0;

        while(start <= end){
            long mid = start + ((end - start) >> 1);

           // partition(c1,mid,A);
            if(partition(c1,mid,A)){
                ans = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(ans);

    }

    public static boolean partition(long[] C, long mid, int pCount){
        int painterCount = 1;
        long painterWork = 0;

        for(int i=0;i<C.length;i++){
            if( painterWork + C[i] <= mid ){
                painterWork += C[i];
            }else{
                painterCount++;
                if(painterCount > pCount || C[i] > mid){
                    return false;
                }
                painterWork = C[i];
            }
        }

        return true;
    }
}
