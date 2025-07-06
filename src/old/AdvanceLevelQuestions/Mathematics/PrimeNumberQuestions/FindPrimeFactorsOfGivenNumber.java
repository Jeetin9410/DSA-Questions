package old.AdvanceLevelQuestions.Mathematics.PrimeNumberQuestions;

public class FindPrimeFactorsOfGivenNumber {
    public static void main(String[] args) {
        int A = 46;

        // print 2 till it divides it

        while(A%2==0){
            System.out.print(2+" ");
            A/=2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for(int i = 3;i<=Math.sqrt(A);i+=2){
            while(A%i==0){
                System.out.print(i+" ");
                A/=i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (A > 2)
            System.out.print(A);
    }

}
