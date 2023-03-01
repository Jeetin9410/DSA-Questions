package AdvanceLevelQuestions.Mathematics.ModuloOperator;

public class ImplementPowerFunctionWithModulus {
    /*
    Implement pow(A, B) % C.
        In other words, given A, B and C, Find (A^B % C).
        Note: The remainders on division cannot be negative.
         In other words, make sure the answer you return is non-negative.

     -10^9 <= A <= 10^9
        0 <= B <= 10^9
        1 <= C <= 10^9
     */
    public static void main(String[] args) {
        int A = 12;
        int B = 55557207;
        int C = 55557209;
        // ans should be 19

        // first lets have basic pow function
        // then we will modify it and add %C
        System.out.println(pow(A,B,C));
    }

    /*

     public static int pow(int A, int B,int C){
        if(A==0)
            return 0;
        if(B==0)
            return 1;
        ==> we do %C here
   //     int ans = pow(A,B/2,C)%C;
          long ans = pow(A,B/2,C)%C;
        ==> %C means ans will lie in [0 ,10^9-1]
        ==> what if ans is 10^9, line ans = ans * ans; will go overflow cause int can't hold this big number
        so let change ans from int to long
        if(B%2==0){
            ans = (ans*ans)%C;
        ==> so here we add %C also
        }else{
            ans = ((ans*ans)%C * A)% C;
        }
        return ans;


        // Now the above code will work fine for positive cases only.
        // Now we will modify it for -ve A values , which is shown as below.
    }
     */

    /*
      public static int pow(int A, int B,int C){
        if(A==0)
            return 0;
        if(B==0)
            return 1;
        long ans = pow(A,B/2,C)%C;
        if(B%2==0){
            ans = (ans*ans)%C;
        }else{
            ans = ((ans*ans)%C*A)%C;
        }

        Now the above ans can be negative , we have to make it positive.
        Note : Some language like Python did this themselves, but In Java, C++ and JavaScript we have to do it
               manually.
        Ques : How to do it?
        Ans : Just Add C to it.
              now to handle edge cases like if A and C are 10^9, we will take %C of (ans+C) as well.

        ans = (ans +C) %C;

        return ans;
    }
     */



    public static int pow(int A, int B,int C){
        if(A==0)
            return 0;
        if(B==0)
            return 1;
        int ans = pow(A,B/2,C)%C;
        if(B%2==0){
            ans = (ans*ans)%C;
        }else{
            ans = ((ans*ans)%C * A)%C;
        }
        return (ans+C)%C;
    }
}
