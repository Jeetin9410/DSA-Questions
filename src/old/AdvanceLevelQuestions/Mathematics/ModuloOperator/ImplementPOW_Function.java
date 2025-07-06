package old.AdvanceLevelQuestions.Mathematics.ModuloOperator;

public class ImplementPOW_Function {
    /*
    Given two integers x and n, write a function to compute x^n.
     We may assume that x and n are small and overflow doesn’t happen.
     */
    public static void main(String[] args) {
        int x = -3;
        int n = 1000000000;

        System.out.println(pow(x,n));
    }
    public static int pow(int x, int n){
        if(x==0)
            return 0;

        if(n==0)
            return 1;

        int ans = pow(x,n/2);

        if(n%2 == 0){
            return ans * ans;
        }else {
            return ans * ans * x;
        }
    }
}
