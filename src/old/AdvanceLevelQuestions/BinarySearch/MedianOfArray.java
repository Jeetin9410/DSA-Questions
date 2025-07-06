package old.AdvanceLevelQuestions.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianOfArray {
    /*
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

Problem Constraints
1 <= N + M <= 2*106



Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.



Output Format
Return a decimal value denoting the median of two sorted arrays.



Example Input
Input 1:

 A = [1, 4, 5]
 B = [2, 3]
Input 2:

 A = [1, 2, 3]
 B = [4]


Example Output
Output 1:

 3.0
Output 2:

 2.5


Example Explanation
Explanation 1:

 The median of both the sorted arrays will be 3.0.
Explanation 2:

 The median of both the sorted arrays will be (2+3)/2 = 2.5.

     */

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3,5);
        List<Integer> b = Arrays.asList(4);

        /* Intution 1: Merge two sorted arrays
        and simply use the median formula on final sorted merges array.

        Issues : The code below is throwing TLE on Hard Cases.

         */

  /*      int n1= a.size();
        int n2 =b.size();

        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        int k = 0;

        while(i<n1 && j<n2){
          if(a.get(i)<b.get(j)){
              ans.add(a.get(i));
              k++;
              i++;
          }else {
              ans.add(b.get(j));
              k++;
              j++;
          }
        }

        while(i < a.size()){
            ans.add(a.get(i));
            k++;
            i++;
        }

        while(j < b.size()){
            ans.add(b.get(j));
            k++;
            j++;
        }


        double median = 0.0;
        int n3 = ans.size();
        if(n3%2==0){
            median = (double) ((double) (ans.get((n3-1)/2) + ans.get(((n3-1)/2) + 1))/2.0);
        }else {
            median = (double)ans.get(n3/2);
        }

        System.out.println(Solution(ans));  */

        /*   Using Binary Search 

         */
    }
    public static double Solution(List<Integer> ans )
    {
        int n = ans.size();

        // If length of array is even
        if (n % 2 == 0)
        {
            int z = n / 2;
            int e = ans.get(z);
            int q = ans.get(z - 1);

            double val = (double) (e + q) / 2;
            return val;
        }

        // If length if array is odd
        else
        {
            int z = Math.round(n / 2);
            return (double)ans.get(z);
        }
    }

}
