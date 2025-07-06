package old.DsaPatterns.Recursion.Basic;

public class Prob2_Fibbonnaci {
    public static void main(String[] args) {
        System.out.println(fibbonnaci(2));
    }

    public static long fibbonnaci(int n ) {
        if(n < 2)
            return 1;

        return fibbonnaci(n-1) + fibbonnaci(n-2);
    }
}
