package IntermediateLevelQuestions.Recursion;

public class CheckPalindrome {
    /*
     Check Palindrome

     Write a recursive function that checks whether string A is a palindrome or Not.
    Return 1 if the string A is a palindrome, else return 0.

    Note: A palindrome is a string that's the same when read forward and backward.

    Problem Constraints
    1 <= A <= 50000

    String A consists only of lowercase letters.
     */

    public static void main(String[] args) {
        String A = "strings";

        /*
        Approach : Basically we can solve this using for loop and if we carefully that solution
                  we will fnd that we was using index of for loop as pointer ,
                  and compared the string's character like 0 with A.length-1 till we reach the mid of given
                  string.

                  So

                  to solve this problem by recursion we can
                  use that logic
                  but now instead of for loop we will call a function again and again.

                  Now the question how we gonna so that pointer wala thing,so that we can check the character
                  at given index.

                  Solution :  we will create two pointer(not exact pointer but int value) which will store the
                  start and end index of String.
                  and we will pass these values along with String itself.

                  Now what is going to be the logic part of the function.


         */

        System.out.println(checkPalindrome(0,A.length()-1,A));

    }
    public static int checkPalindrome( int start, int end, String str){
        if(start==end){
            return 1;
        }
        if(str.charAt(start)!=str.charAt(end)){return 0;}
        return checkPalindrome(start+1,end-1,str);
    }
}
