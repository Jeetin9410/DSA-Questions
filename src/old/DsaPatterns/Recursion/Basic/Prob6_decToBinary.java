package old.DsaPatterns.Recursion.Basic;

public class Prob6_decToBinary {
    /*
    You are given a decimal number, and you have to return Binray representation String of the number
     */

    public static void main(String[] args) {
        int num = 13;
        System.out.println(decToBinary(num));
    }

    public static String decToBinary(int num) {
        if(num < 2) {
            return Integer.toString(num);
        }

        return  decToBinary(num / 2) + Integer.toString(num % 2);
    }
}
