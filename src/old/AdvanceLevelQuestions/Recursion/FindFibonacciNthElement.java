package old.AdvanceLevelQuestions.Recursion;

public class FindFibonacciNthElement {
    /*
The Fibonacci numbers are the numbers in the following integer sequence.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:

Fn = Fn-1 + Fn-2

Given a number A, find and return the Ath Fibonacci Number using recursion.

Given that F0 = 0 and F1 = 1.


     */
    public static void main(String[] args) {
        int A=20;

        System.out.println(FabonacciNumber(9));

    }
    public static int FabonacciNumber(int N){
        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }

        return FabonacciNumber(N-1) + FabonacciNumber(N-2);
    }

}
