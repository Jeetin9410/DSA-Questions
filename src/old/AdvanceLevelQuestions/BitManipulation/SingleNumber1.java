package old.AdvanceLevelQuestions.BitManipulation;

public class SingleNumber1 {

    /*
    Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

    NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    1 <= |A| <= 2000000

    0 <= A[i] <= INTMAX

    Example Input
    Input 1:

     A = [1, 2, 2, 3, 1]
    Input 2:

     A = [1, 2, 2]


    Example Output
    Output 1:

     3
    Output 2:

     1
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};

        int num = 0;

        for(int val : A){
            num = num ^ val;
        }

        System.out.println(num);
    }

}
