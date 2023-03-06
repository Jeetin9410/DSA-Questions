package AdvanceLevelQuestions.Recursion;

public class ModifiedFabonacciPattern {
    /*
Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.

Given f(0)=1; f(1)=1; f(2)=2;
     */

    public static void main(String[] args) {
        int N = 3;

        System.out.println(ModifiedFibonacci(N));
    }
    public static int ModifiedFibonacci(int N){
        if(N == 0)
            return 1;
        if(N==1)
            return 1;
        if(N==2)
            return 2;

        return ModifiedFibonacci(N-1)+ModifiedFibonacci(N-2) + ModifiedFibonacci(N-3) + N;
    }
}
