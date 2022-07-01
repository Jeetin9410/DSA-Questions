package IntermediateLevelQuestions.StackandQueuesBasics;

public class BalanceParantheses {
    /*
    Given a string A consisting only of '(' and ')'.

     You need to find whether parentheses in A are balanced or not, if it is balanced then return 1 else return 0.

     1 <= |A| <= 10^5

     Output format: Return 1 if parantheses in string are balanced else return 0.


     Example Input
Input 1:

 A = "(()())"
Input 2:

 A = "(()"


Example Output
Output 1:

 1
Output 2:

 0

     */

    public static void main(String[] args) {
        String str = "(()()))";
        int top = -1;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                top++;
            }else if(str.charAt(i)==')'){
                top--;
            }
        }
        if(top==-1){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
