package AdvanceLevelQuestions.Mathematics.ModuloOperator;

public class GCD_OR_HCF {
    /*
    GCD (Greatest Common Divisor) or HCF of two numbers is the largest number that divides both of them.

    Example :

           36 = 2 x 2 x 3 x 5;
           60 = 2 x 2 x 3 x 5;

           GCD = multiplication of common factors.

               = 2 x 2 x 3
               = 12
     */

    public static void main(String[] args) {
        int a = 36;
        int b = 24;

        /*
        Traditional method :
        we divide a by b ( or b by a) till we get reminder 0.
        now if a % b != 0
        then we divide b by reminder(a%b)
        and this process goes till reminder becomes 0.
         and the divisor at which reminder is 0 ====>  is GCD.

         */

        while( a%b!= 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        int gcd = b;

        System.out.println(gcd);

    }
}
