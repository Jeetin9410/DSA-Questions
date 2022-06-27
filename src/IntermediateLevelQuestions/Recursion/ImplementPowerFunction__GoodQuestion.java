package IntermediateLevelQuestions.Recursion;

public class ImplementPowerFunction__GoodQuestion {

    /*
    Question : Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

    Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104


     */

    /**************   Solving using Recursion ***************/

    public static void main(String[] args) {
        int A = 60;
        int B = 5;

        /************************** Method 1 *******************/

        /*
        System.out.println(powFun(A,B));

         So the solution above is correct but the issue is it will throw TLE.
        the input for which it has thrown TLE
        A = 213
        B = 231
        C = 1

        So the powFun is taking to long to execute then we expected.

        So we have to make this function more efficient.

        */

        /**************************Method 2 ********************/

        //System.out.println(power(A,B));


        /************************** Method 3 *******************/
        System.out.println(power(2,-2));
    }

    /************************ Method 1 function******************
     public static long powFun(int A, int B){
     if(A==0){
     return 0;
     }
     if(B==0){
     return 1;
     }
     long ans = A * powFun(A,B-1);
     return ans;
     }

     */

    /******************************* Method 2 function *****************************/

 /*  public static int power(int x, int y)
    {
        if (y == 0)
            return 1;
        else if (y % 2 == 0)
            return power(x, y / 2) * power(x, y / 2);
        else
            return x * power(x, y / 2) * power(x, y / 2);



       // Time Complexity: O(n)
       // Space Complexity: O(1)

    }

  */



    /****************** Improving Method 2  *****************/
    /// Optimal but n should be >= 0 always.
    // Algorithmic Paradigm: Divide and conquer.

 /*   public static int power(int x, int y)
    {
        int temp;
        if( y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp*temp;
        else
            return x*temp*temp;




        Limitation of this function : n should be strictly greater than equal to 0
                                       for negative value of n
                                       this function won't work

    }
*/


    /******************************* Explanation of method 2 **********************/

    /*

     Optimal approach :


    look we have to implement  x^n i.e x raised to power of n.

    so we are going to have 2 possible set of numbers for n
    1) even number i.e n= 0,2,4,6,8,10......
    2) odd number i.e  n= 1,3,5,7,9

    so   x^n  ----> if n is even = x^(n/2) * x^(n/2)
              ----> if n is odd = x * ( x^(n/2) * x^(n/2) )


     */


    /*************************** Method 3 ********************************/


    public static double power(double x, int y)
    {
        double temp;

        double ans = 0.00000;

        if( y == 0)
            return 1;

        if(y<0){

            temp = power(1/x, y / 2);
            if (y % 2 == 0)
                ans = (1/temp)*(1/temp);
            else
                ans = (1/x)*(1/temp)*(1/temp);

        }else{

            temp = power(x, y / 2);
            if (y % 2 == 0)
                ans = temp*temp;
            else
               ans = x*temp*temp;
        }


    return ans;

    }


}
