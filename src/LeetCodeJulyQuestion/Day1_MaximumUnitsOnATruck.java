package LeetCodeJulyQuestion;

import java.util.HashMap;

public class Day1_MaximumUnitsOnATruck {
    /*
    You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes,
    where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

    -->  numberOfBoxesi is the number of boxes of type i.
    -->  numberOfUnitsPerBoxi is the number of units in each box of the type i.

    You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
     You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

    Return the maximum total number of units that can be put on the truck.

    Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.

Example 2 :

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91


Constraints:

1 <= boxTypes.length <= 1000
1 <= numberOfBoxes(i), numberOfUnitsPerBox(i) <= 1000
1 <= truckSize <= 10^6

     */

    /*
    Approach :
      For simplicity let us consider that boxType = [x,y]

     so acc to truck Size  :  Sum of all x must NOT exceed truck side,  So for some testcase it might be less that
                              truckSize and the Total number of units are maximum.

      So my appraoch is :  To select  maximum y first and correspondingly calculate x*y

      and do this this  Sum of all (x) <= truckSize.

     */

    public static void main(String[] args) {
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};

        // no of units per box , no of boxes
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i< boxTypes.length;i++){
          map.put(boxTypes[i][1],boxTypes[i][0]);
        }



        System.out.println(map.toString());
    }
}
