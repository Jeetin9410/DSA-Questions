package old.AdvanceLevelQuestions.Mathematics;

public class FindSquareRootOfN {
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
        int A = 30;
        int i = 1;
        int ans = 0;
        while(i*i < A){
            ans = i;
            i++;
        }

        System.out.println(ans);

        /// Here the time complexity is O(sqrt(N))

        // This can further be reduced to O(log(N)) using binary search
        // check this solution in binary search approach also
    }
}
