package old.AdvanceLevelQuestions.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MergeIntervalLeetCode {
    /*
    Given a set of time intervals in any order, merge all overlapping intervals into one
    and output the result which should have only mutually exclusive intervals.

    Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
    Output: {{1, 4}, {6, 8}, {9, 10}}
    Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10].

    Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
    Output: {{1, 9}}

    Constraints:

    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104
     */
    public static void main(String[] args) {

        //// Considering the given array is not sorting.

        int[][] intervals = {{1,3},{2,4},{6,8},{9,10}};

        // Optimised approach is Using Stack

        /*
         ==>  Sort the intervals based on the increasing order of starting time.
              Why ?  because if list is not sorted we won't be able to do perform following action in linear traversal.
            1) Push the first interval into a stack.
            2) For each interval do the following:
                a) If the current interval does not overlap with the top of the stack then,
                push the current interval into the stack.
                b) If the current interval overlap with the top of the stack then, update the stack top
                with the ending time of the current interval.
                c) The end stack contains the merged intervals.
         */

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);

        for(int i = 1; i< intervals.length;i++){


                int startpoint2 = intervals[i][0];
                int endpoint2 = intervals[i][1];

                int[] popInterval = stack.pop();

                int startpoint1 = popInterval[0];
                int endpoint1 = popInterval[1];

                // find the endpoint of the interval
                int endMax = Math.max(endpoint1,endpoint2);

                if(endpoint1 >= startpoint2){
                    int[] merge = new int[]{startpoint1,endMax};
                    stack.add(merge);
                }else{
                    stack.add(popInterval);
                    stack.add(intervals[i]);
                }

        }

        // making array out of stack

        int[][] output = new int[stack.size()][2];

        for (int i = output.length-1;i>=0;i--){
            int[] popArray = stack.pop();
            output[i][0]  = popArray[0];
            output[i][1]  = popArray[1];
        }

        //return output;


    }
}
