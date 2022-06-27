package IntermediateLevelQuestions.Recursion;

public class ImplementPowerFunctionWithModulus {
    /*
    Question :
              Implement pow(A, B) % C.
        In other words, given A, B and C, Find (A^B % C).

        Note: The remainders on division cannot be negative.
        In other words, make sure the answer you return is non-negative.


        Problem Constraints
            -109 <= A <= 109
            0 <= B <= 109
            1 <= C <= 109

        Example Input

       A = 2, B = 3, C = 3


        Example Output  :  2


        Example Explanation :
        2^3 % 3 = 8 % 3 = 2

     */



    /*
    Now the above code you are seeing will work correct only for +ve value of (A^B)

    Concept   :

    A%B  or A mod B implies the reminder.

    ==> You can think of this as subtracting b from a enough times to get in the range [0, b-1]

    {0,2} : Required Range of answer.
    8 % 3 : ( 8 --> 5 --> 2 )

    So last we end at 2 so answer is 2.

    If b>0, then the remainder will be in the range [0, b-1] meaning positive or zero.

    If b<0 the remainder will be in the range [b+1, 0] meaning negative or zero.

    means

    If A is negative and B is positive , you ADD B to A enough times to reach a number in range [0, b-1].

    If A is negative and B is negative , you SUBTRACT B from A enough times to reach a number in range [b+1,0]


    Example:
    [0,3]
     21 mod 4 : (21-->17-->13-->9-->5-->1)
     End at 1 so ans is 1.

     -21 mod 4 : ( -21 --> -17 --> -13 --> -9 --> -5 --> -1 -->3)
       answer range : [0,3]

       Ans : 3

       -21 mod -4 : ( -21 -> -17 -> -13 -> -9 -> -5 -> -1 )
       answer range : [-3,0]
       Ans: -1

     */

    public static void main(String[] args) {
        int A = 213;
        int B = 231;
        int C = 1   ;


        /************************* Method 1 with explanation *************************************/

        /*
        if(powFun(A,B)>0){
            System.out.println(powFun(A,B)%C);
        }else{
                long ans = powFun(A,B);
                while(true){
                    ans = ans + C;
                    if(ans>=0 && ans<=(C-1)){
                        break;
                    }
                }
            System.out.println(ans);
        } */

        /*

        So the solution above is correct but the issue is it will throw TLE.
        the input for which it thrown TLE is
        A = 213
        B = 231
        C = 1

        So the powFun is taking to long to execute then we expected.

        So we have to make this function more efficient.

         */


        /*
        Using powFun(A,B) will throw TLE.

         so to avoid it we going to use it as explained below
         */
     /*   long ans = 0;
       if(B%2==0){
            ans = powFun(A,B/2) * powFun(A,B/2);
           System.out.println(ans);
       }else{
           ans = A * ans;
           System.out.println(ans);
       }

      */


        /************** Method 4   ********/

        System.out.println(pow(A,B,C));


    }


/************************ Method 1 function******************/
 /*   public static long powFun(int A, int B){
        if(A==0){
            return 0;
        }
        if(B==0){
            return 1;
        }
        long ans = A * powFun(A,B-1);
        return ans;
    } */




    /*
         ************************ Method 2 **********************
         Here  i am not writing power function for negative values of B as it is given that
         B will always be >= 0
         and cause there is no negative value of B so all answer will be in int ,no need to declare
         double return type or double variables

     */

  /*  public static int power(int x, int y){
        if(y == 0 || x ==0){
            return 1;
        }
        int temp = power(x,y/2);
        if(y%2==0){
            return temp * temp;
        }else{
            return x * temp * temp;
        }

        // Above function is also throwing TLE
        // A = 213 B = 231 C =1
    }
    */

    /******************* Method 4 :  Class Notes************/

    public static int pow(int A, int B, int C){
        if(A==0 || B==0){
            return 1;
        }
        int temp = pow(A,B/2,C);
        int even_ans = ((temp % C) * (temp % C))% C;
        if((B&1)==0){
            return (int)even_ans;
        }else{
            // now pow can also return negative value as well so,
            int x = (int) ((Long.valueOf(A%C)*Long.valueOf(even_ans%C))%C);
            if(x<0){
                return C+x;
            }else{
                return x;
            }
        }
    }



}
