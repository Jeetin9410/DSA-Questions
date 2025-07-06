package old.AdvanceLevelQuestions.Recursion;

import java.util.Scanner;

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ReverseString(str.length()-1,str);

    }
    public static void ReverseString(int counter,String str){
        if(counter<0){
            return;
        }
        System.out.print(str.charAt(counter));
        counter--;
        ReverseString(counter,str);
    }
}
