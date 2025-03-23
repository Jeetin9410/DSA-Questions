package DsaPatterns.Recursion.Basic;

public class Prob1_Multiplication {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        //System.out.println(sumOf(2));
        System.out.println(sumOf_N_Elements(arr, 6));
    }
    public static int multiplyNums(int x, int y) {
        if(x == 1) {
            return y;
        }

        return multiplyNums(x - 1, y) + y;
    }

    /* Sum of first n natural numbers */
    public static int sumOf(int n) {
        if(n == 1)
            return 1;

        return n + sumOf(n-1);
    }

    /* Array will be given you have to find  */
    public static int sumOf_N_Elements(int[] arr, int n) {
        if(n == 1)
            return arr[0];

        return sumOf_N_Elements(arr, n - 1) + arr[n - 1];
    }
}


