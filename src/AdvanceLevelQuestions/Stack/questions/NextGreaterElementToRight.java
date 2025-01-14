package AdvanceLevelQuestions.Stack.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElementToRight {
    /*

    Given an array arr[] of integers, the task is to find the Next Greater Element for each element
    of the array in order of their appearance in the array.

    Note: The Next Greater Element for an element x is the first greater element on the right side of x in the array.
    Elements for which no greater element exist, consider the next greater element as -1.

    Input: arr[] = [1, 3, 2, 4]
    Output: [3, 4, 4, -1]
    Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn’t exist, it is -1.

     */

    public static void main(String[] args) {


        /*
        Brute force approach:
        2 Nested for loop
           i -> 0 to arr.size()
             j -> i + 1 to arr.size()

        Intuition:
        Here we can observe the j is from i to n --> we can use Stack in this to approve the solution.

        Normally we iterate from index 0 to n-1.
        But here if we iterate from n-1 to 0 --> we will know for element which element is greater to its right.

        Approach :
        i index will iterate from n-1 to 0:
        for Every index we will check some conditions on stack to determine greater element to right of i th element
        0.  we will push every element at i index into stack for future comparisions.
        1. if stack is empty --> Means no Element is present at Right of index i --> we will push -1 in arrayList
                                 and also push the i the element into the stack.
        2. if stack is not empty --> then we will check i th element in arr is greater than top element of stack using stack.pop()
                  Shown below

         3.Now we just need to reverse the list where we stored the elements.

         */

        int[] arr = {1, 3, 2, 4};
        int n = arr.length;
        Stack<Integer> stack  = new Stack<>();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(stack.peek());
            }
            stack.push(arr[i]);
        }

        Collections.reverse(list);

        System.out.println(list);




    }
}
