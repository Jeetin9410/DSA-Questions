package old.AdvanceLevelQuestions.Stack.questions;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Stack;

public class ValidParantheses {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

        1. Open brackets must be closed by the same type of brackets.
        2. Open brackets must be closed in the correct order.
        3. Every close bracket has a corresponding open bracket of the same type.
     */

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println("Given string "+ s +" is valid parantheses :" + isValid(s));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i <n; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if(stack.isEmpty()) return false;   // edge case : what is "]"
            if(ch == ')' && stack.pop() != '(') return false;
            if(ch == '}' && stack.pop() != '{') return false;
            if(ch == ']' && stack.pop() != '[') return false;
        }

        return stack.isEmpty();
    }

}
