package IntermediateLevelQuestions.StackandQueuesBasics;

import java.util.Stack;

public class BalanceParanthesesII {
    public static void main(String[] args) {
        String A = "{([])}";

        System.out.println(solve(A));
    }
    public static int solve(String A) {
        int len = A.length();
        Stack<Character> stack = new Stack();
        for(char c : A.toCharArray()){
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) return 0;
            if(c == '}' && stack.pop() != '{') return 0;
            if(c == ']' && stack.pop() != '[') return 0;
            if(c == ')' && stack.pop() != '(') return 0;
        }
        return stack.isEmpty() ? 1 : 0;
    }
}

