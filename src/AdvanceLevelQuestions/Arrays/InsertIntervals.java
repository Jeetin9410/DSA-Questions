package AdvanceLevelQuestions.Arrays;

import java.util.Arrays;
import java.util.Stack;

public class InsertIntervals {
    /*
   You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
   represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
   You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
    still does not have any overlapping intervals (merge overlapping intervals if necessary).

    Return intervals after the insertion.

    Example 1:

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]
    Example 2:

    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

    constraints:
    0 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 105
    intervals is sorted by starti in ascending order.
    newInterval.length == 2
    0 <= start <= end <= 105

     */

    public static void main(String[] args) {


        /*
        Approach 1 :

        first add this new interval into intervals list...using stack

        then stack --> array ---> then merge interval process as previous code.
         */

        /*
         if(intervals.length<1){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }

        Stack<int[]> stack = new Stack();
        boolean isNewIntervalAdded = false;
        for(int i =0;i< intervals.length;i++){
            if(newInterval[0] < intervals[i][0]){
                if(!isNewIntervalAdded){
                    stack.add(newInterval);
                    stack.add(intervals[i]);
                    isNewIntervalAdded = true;
                }else{
                    stack.add(intervals[i]);
                }
            }else{
                stack.add(intervals[i]);
            }
        }

        int[][] newIntervalList = new int[stack.size()][2];

        for(int i = newIntervalList.length-1;i>=0;i--){
            int[] popArray = stack.pop();
            newIntervalList[i][0] = popArray[0];
            newIntervalList[i][1] = popArray[1];
        }


        //// Now we have to merge the overlapping intervals.

        stack.clear();

        stack.add(newIntervalList[0]);


        for(int i = 1; i< newIntervalList.length;i++){
            int startpoint2 = newIntervalList[i][0];
            int endpoint2 = newIntervalList[i][1];

            int[] popInterval = stack.pop();
            int startpoint1 = popInterval[0];
            int endpoint1 = popInterval[1];

            if(endpoint1 >= startpoint2){
                int endMax = Math.max(endpoint1,endpoint2);
                int[] merge = new int[]{startpoint1,endMax};
                stack.add(merge);
            }else{
                stack.add(popInterval);
                stack.add(newIntervalList[i]);
            }
        }

        int[][] output = new int[stack.size()][2];

        for(int i = output.length-1;i>=0;i--){
            int[] popArray = stack.pop();
            output[i][0] = popArray[0];
            output[i][1] = popArray[1];
        }

        return output;
         */



        /*
        Approach 2 : just create new array and this new interval at last;
                      sort the array by first element of every interval

                      and then simply use the  Merge interval approach
         */

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newinterval = {4,8};

        int[][] newIntervalList = new int[intervals.length + 1][2];

        newIntervalList[0] = newinterval; // added new interval at first.

        for(int i = 0;i<intervals.length;i++){
            newIntervalList[i+1] = intervals[i];
        }

        Arrays.sort(newIntervalList, (a,b) -> Integer.compare(a[0],b[0]));



        Stack<int[]> stack = new Stack<>();
        stack.add(newIntervalList[0]);

        for(int i =1;i<newIntervalList.length;i++){

            int startpoint2 = newIntervalList[i][0];
            int endpoint2 = newIntervalList[i][1];

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
                stack.add(newIntervalList[i]);
            }
        }

        // making array out of stack

        int[][] output = new int[stack.size()][2];

        for (int i = output.length-1;i>=0;i--){
            int[] popArray = stack.pop();
            output[i][0]  = popArray[0];
            output[i][1]  = popArray[1];
        }

        for (int i =0;i<output.length;i++){
            System.out.println(Arrays.toString(output[i]));
        }



    }

}
