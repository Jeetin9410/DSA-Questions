package old.AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions;

public class isPrimeNumber {
    public static void main(String[] args) {
        int num = 11;
        // method 1 :
        /*
        A prime number(N) has no factor in between 3 to sqrt(N)
         */
        System.out.println(isPrime(num));
    }
    public static boolean isPrime(int n){     /// This method is SIMILAR to find the factors of given number.

        if(n<=1)
            return false;

        if(n==2)
            return true;

        if(n%2==0){
            return false;
        }

        for(int i = 3; i<=Math.sqrt(n);i+=2){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }

    // TC : O(sqrt(N))
    // SC : O(1)
}
