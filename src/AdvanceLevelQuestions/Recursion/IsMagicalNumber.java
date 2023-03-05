package AdvanceLevelQuestions.Recursion;

public class IsMagicalNumber {
    /*
    Given a number A, check if it is a magic number or not.

A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively
by adding the sum of the digits after every addition.
If the single digit comes out to be 1, then the number is a magic number.

1 <= A <= 10^9

Example Input
Input 1:  A = 83557
Input 2:  A = 1291


Example Output
Output 1:  1
Output 2:  0

                    Explanation 1:
                     Sum of digits of (83557) = 28
                     Sum of digits of (28) = 10
                     Sum of digits of (10) = 1.
                     Single digit is 1, so it's a magic number. Return 1.

                    Explanation 2:
                     Sum of digits of (1291) = 13
                     Sum of digits of (13) = 4
                     Single digit is not 1, so it's not a magic number. Return 0.

     */

    public static void main(String[] args) {

        int A= 83557;

        int temp = sumOfDigits(A);

        while(temp%10!=temp){       // this condition I forgot
            temp = sumOfDigits(temp);
        }

        System.out.println(temp);

    }

    public static int sumOfDigits(int num){
        int count = 0; // to count no of digits in num
        int temp = num;
        while(temp!=0){
            temp /= 10;
            count++;

        }

        int div = (int)Math.pow(10,count--);
        int sum = 0;
        while(div!=0){
            int digit = num/div;
            sum = sum + digit;

            num = num%div;
            div/=10;

        }

        return sum;
    }


}
