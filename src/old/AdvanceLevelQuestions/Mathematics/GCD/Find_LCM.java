package old.AdvanceLevelQuestions.Mathematics.GCD;

public class Find_LCM {
    public static void main(String[] args) {
        int a = 12;
        int b = 15;

        int lcm = (a * b) / gcd(a,b);

        System.out.println(lcm);

    }
    public static int gcd(int a, int b){
        while(a%b !=0 ){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }
}
