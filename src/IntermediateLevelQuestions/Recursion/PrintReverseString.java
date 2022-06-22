package IntermediateLevelQuestions.Recursion;

public class PrintReverseString {
    /*
    Question :
    Write a recursive function that, given a string S, prints the characters of S in reverse order.

    Problem Constraints
    1 <= |s| <= 1000

        Example Input

        Input 1:  scaleracademy
        Input 2:  cool

        Example Output

        Output 1: ymedacarelacs
        Output 2: looc

     */
    public static void main(String[] args) {
        String str = "scaleracademy";

        reverseString(0,str.length()-1,str);

    }

    public static void reverseString(int start, int end,String strn){
        if(end==-1){
            return;
        }
        System.out.print(strn.charAt(end));
        reverseString(0,end-1,strn);
    }
}
