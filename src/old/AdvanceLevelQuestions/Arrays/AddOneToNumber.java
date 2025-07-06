package old.AdvanceLevelQuestions.Arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddOneToNumber {
    public static void main(String[] args) {
        /*
        Problem Description :

        Given a non-negative number represented as an array of digits, add 1 to the number
         ( increment the number represented by the digits ).

        The digits are stored such that the most significant digit is at the head of the list.

        Problem Constraints
        1 <= size of the array <= 1000000

        Input Format
        First argument is an array of digits.

        Output Format
        Return the array of digits after adding one.

        Example Input
        Input 1: [1, 2, 3]

        Example Output
        Output 1: [1, 2, 4]
         */
        int[] A = {8,9,9};

    /*              Method 1 : wrong
        int num = 0;

        for(int i = 0; i<A.length;i++){
            num = num + A[i]*(int) Math.pow(10,(A.length-i-1));
        }

        num++;

        System.out.println(num);

        String str = Integer.toString(num);
        int[] ans = new int[str.length()];

        for(int i = 0;i<str.length();i++){
            ans[i] = (int)str.charAt(i) - '0';
        }

        System.out.print(Arrays.toString(ans));

      */
        // 9 9 9

        ArrayList<Integer> list = new ArrayList<>();
        int carry = 1;
        for(int i = A.length-1; i>=0; i--){
            int num = A[i];
            int sum = num +carry;
            if(sum >= 10){
                carry = 1;
                list.add(sum%10);
            }else{
                carry = 0;
                list.add(sum);
            }
        }

        if(carry ==1){
            list.add(1);
        }

        for(int i =list.size()-1;i>=0;i--){
            System.out.print(list.get(i));
        }



    }
}
