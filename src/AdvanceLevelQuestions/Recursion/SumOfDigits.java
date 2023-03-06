package AdvanceLevelQuestions.Recursion;

public class SumOfDigits {
    /*
    Given a number A, we need to find the sum of its digits using recursion.

    1 <= A <= 10^9

    Example Input
Input 1:

 A = 46
Input 2:

 A = 11


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

 Sum of digits of 46 = 4 + 6 = 10
Explanation 2:

 Sum of digits of 11 = 1 + 1 = 2
     */

    public static void main(String[] args) {

        int A = 1000000000;

        /*       CONCEPT

         ex :  A = 123;
                                     Quotient     Reminder
         if we divide 123 by 100 -->     1          23
                       23 by 10  -->     2           3
                        3 by 1   -->     3           0

                        and in Quotient we get every digit one by one.

         Question : now how to Arrange for 100 , 10 or  1?
         Ans :    We will do is find total num of digits which are there in given number.
         How to do that?
         Ans : If we divide any given number by 10 till it becomes 0,  the total number of division will be equal to
               Total number of digits.

         */

        // counting number of digits

        int count=0;

        int temp = A;

        while(temp!=0){
            count++;
            temp/=10;
        }

      //  System.out.println(count);

        /*
        Now we are going to find the count digit multiple of 10
        Ex : count =6
        the number we require is 100000
        now for every iteration we will 100000 as well by 10 so that this also get reduced by 10 after every iteration

        Important note :
        if we did
        while(A!=0){
        }

        Then this will give wrong answers because
        For Ex A = 1000
        it will print 1 ans A will be 0 by then
        so it will print 1 only

        Now to solve this we will use div variable to be there ,which will in sure every digit is printed or summed
         */

        int div = (int)Math.pow(10,count-1);
        int sum = 0;
        while(div!=0){
            int digit = A/div;
            sum = sum + digit;
            System.out.print(sum+" ");
            A = A%div;
            div/=10;
        }

        System.out.println(sum);

    }

}
