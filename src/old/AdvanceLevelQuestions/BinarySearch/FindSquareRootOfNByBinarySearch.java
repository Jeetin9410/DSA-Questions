package old.AdvanceLevelQuestions.BinarySearch;

public class FindSquareRootOfNByBinarySearch {
    /*
 Asked in : VMWare, Flipkart, Accolite,Amazon,Microsoft

    Given an integer X, find its square root. If X is not a perfect square, then return floor(√x).

    Input: x = 4
Output: 2
Explanation: The square root of 4 is 2.

Input: x = 11
Output: 3
Explanation:  The square root of 11 lies in between 3 and 4 so floor of the square root is 3.
     */
    public static void main(String[] args) {
        int A=5;

        /* Concept :
         Q: What will be our sample space?
         Ans : min val is 1
               max val is N/2

        logic part:
        mid * mid > N , then move to left part of mid
         mid * mid < N  then move to right part of mid.
         */
        System.out.println(Sqrt(15));

        //// This code with int didnt worked for this input on leetcode
        /// n = 2147395599
    }
    public static int Sqrt(int N){
        int s = 1;
        int e = N;
        int ans =0;

        // edge case
        if(N==0 || N==1){
            return N;
        }

        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid*mid == N){
                return mid;
            }
            if(mid*mid<N){
                s = mid + 1;
                ans = mid;
            }else {
                e = mid - 1;
            }

        }
        return ans;
    }
}
