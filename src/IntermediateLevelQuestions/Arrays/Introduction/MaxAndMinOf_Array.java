package IntermediateLevelQuestions.Arrays.Introduction;

public class MaxAndMinOf_Array {
    /*
    Take input an array A of size N and write a program to print maximum and minimum elements of the input.
     */

    public static void main(String[] args) {
        int[] A= {10,40,50,80};
        int n = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }

        System.out.println(max + " " + min);
    }
}
