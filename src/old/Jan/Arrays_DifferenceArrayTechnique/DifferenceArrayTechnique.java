package old.Jan.Arrays_DifferenceArrayTechnique;

/*      The is premium problem on leetcode ==> Very important topic, Asked by Google, Microsoft, Meta
         This concept is base --> later other variations questions are possible on this like Shifting Letters II (on leetcode)

Question :
Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments
each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:
Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
Output: [-2,0,3,5,3]

Explanation :
Initial state:
[0,0,0,0,0]

After applying operation [1,3,2]:
[0,2,2,2,0]

After applying operation [2,4,3]:
[0,2,5,5,3]

After applying operation [0,2,-2]:
[-2,0,3,5,3]


Solution Video with concept: https://www.youtube.com/watch?v=R-PBfqsRGP0&ab_channel=Techdose

 */

/*  Approach:
    Difference Array Technique is basically a technique which let us update the Range of elements in given array in O(1).

    Given array: arr = [15,10, 5, 20, 40]
    Queries: [1, 3, 10] --> from 1 to 3 inclusive --> add 10
             [1, 4, 5]

             Print Final Array.
    Basic working is:
    1. For a given array, we find a difference array or Gradient Array
       i.e [15, -5, -5, 15, 20, 0]  //last element is extra , just taken for easy calculation

    2. The difference array keeps track of the change in value at specific positions in the original array.
       Instead of modifying every element in a range, we just record:

        1. Where the change starts (add the value).
        2. Where the change ends (subtract the value to cancel it beyond the range).

       This "marking" system allows you to efficiently apply updates to the original array using a prefix sum later.

       Ques : why doing so?
       Ans: Gradient array is basically an array that show relative increment or decrement in element at index "i"
            form element at index "i-1"

            So if we do step 1 and step 2 ---> to this gradient array

            then at the end we will add 0th element to 1 elment of gradient array and soo on......

            which will ultimately give me my updated array in O(1)

    3. for query one -->
       Gradient array = [15,5,-5,15,10,0]

    4. For query two -->
       Gradient array= [15, 10, -5, 15, 10, -5]

       final ans =
       0 index -->  15
       1 index --> 15 + 10 = 25
       2 index --> 25+ -5 = 20
       3 index --> 20 + 15 = 35
       4 index --> 35 + 10 = 45
       5 index --> 45 - 5 = 40  // extra

       final array = [15, 25, 20, 35, 45]


 */


import java.util.Arrays;

public class DifferenceArrayTechnique {
    public static void main(String[] args) {

        int[] stocks = {15,10,5,20,40};
        int[][] queries = {{1,3,10},{1,4,5}};

        int n = stocks.length;
        int[] gradientArray = new int[n+1];
        gradientArray[0] = stocks[0];
        gradientArray[n] = 0;

        for(int i = 1; i < n; i++){
            gradientArray[i] = stocks[i] - stocks[i-1];
        }

        System.out.println(Arrays.toString(gradientArray));

        for(int i = 0; i<queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int value = queries[i][2];

            gradientArray[start] += value;
            gradientArray[end + 1] -= value;
        }

        System.out.println(Arrays.toString(gradientArray));

        for(int i = 1; i< gradientArray.length; i++) {
            gradientArray[i] = gradientArray[i] + gradientArray[i-1];
        }

        System.out.println(Arrays.toString(gradientArray));

        System.out.println("Final Answer : " +  Arrays.toString( Arrays.copyOfRange(gradientArray,0,n)));

    }
}
