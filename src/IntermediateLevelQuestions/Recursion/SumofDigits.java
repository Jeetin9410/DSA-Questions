package IntermediateLevelQuestions.Recursion;

public class SumofDigits {
    /*
    Question :
    Given a number A, we need to find the sum of its digits using recursion.

    Problem Constraints
    1 <= A <= 109

    Example Input
        Input 1: A = 46
        Input 2: A = 11

        Example Output
        Output 1: 10
        Output 2:  2

     */

    public static void main(String[] args) {
        int A = 46;
        System.out.println(sumOfDigits(A));
    }
    public static int sumOfDigits(int a){
        if(a==0){
            return 0;
        }
      //  System.out.println(a%10+" "+a/10);
        return (a % 10 + sumOfDigits(a/10) );
    }
}
