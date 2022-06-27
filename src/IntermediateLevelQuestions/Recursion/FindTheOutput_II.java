package IntermediateLevelQuestions.Recursion;

public class FindTheOutput_II {
    /*
    Question : Find the output of the program.

     */
    public static void main(String[] args) {

        System.out.println(fun(2,10));

    }
    public  static int fun(int x, int n){
        if(n==0){
            return 1;
        } else if (n % 2 == 0) {
            return fun(x*x,n/2);
        }else {
            return x * fun(x*x,(n-1)/2);
        }
    }
}
