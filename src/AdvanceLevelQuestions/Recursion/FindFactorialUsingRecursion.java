package AdvanceLevelQuestions.Recursion;

import java.util.Scanner;

public class FindFactorialUsingRecursion {

    public static void main(String[] args) {
        int A= 4;



        System.out.println(Factorial(A));

    }
    public static int Factorial(int N){
        if(N==0)
            return 1;
        if(N==1)
            return 1;

        return N*Factorial(N-1);
    }
}
