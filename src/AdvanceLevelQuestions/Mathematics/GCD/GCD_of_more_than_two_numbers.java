package AdvanceLevelQuestions.Mathematics.GCD;

public class GCD_of_more_than_two_numbers {
    /*
    Given an array of numbers, find GCD of the array elements. In a previous post we find GCD of two number.

    Examples:

Input  : arr[] = {1, 2, 3}
Output : 1

Input  : arr[] = {2, 4, 6, 8}
Output : 2


Concept :

        gcd(a,b,c) = gcd( gcd(a,b),c )
                    OR   gcd( a, gcd(b,c) )
                    OR   gcd( gcd(a,c),b)

     */

    public static void main(String[] args) {
        int[] arr = {2,4,6,8};

        int ans = arr[0];

        for(int element : arr){
            ans = gcd(ans,element);
        }

        System.out.println(ans);
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

}
