package old.AdvanceLevelQuestions.Mathematics.ModuloOperator;

public class FindFactorial {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(factorial(num));
    }
    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        int ans = n * factorial(n-1);
        return ans;
    }
}
