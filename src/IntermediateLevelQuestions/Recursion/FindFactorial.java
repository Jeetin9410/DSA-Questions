package IntermediateLevelQuestions.Recursion;

public class FindFactorial {
    /*
    Question :

    Write a program to find the factorial of the given number A.

    0 <= A <= 12

     */

    public static void main(String[] args) {
        int A = 5;

        System.out.println(findFactorial(A));
    }
    public static long findFactorial(int num){
        if(num == 0){
            return 1;
        }
        long ans = num * findFactorial(num-1);
        return ans;
    }
}
