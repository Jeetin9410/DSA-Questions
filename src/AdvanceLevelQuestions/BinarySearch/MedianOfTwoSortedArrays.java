package AdvanceLevelQuestions.BinarySearch;

import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
    /*
    Given two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays,
 where N is the number of elements in the first array, and M is the number of elements in the second array.

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

1 <= N + M <= 2*10^6

 Input: a[] = {-5, 3, 6, 12, 15}, b[] = {-12, -10, -6, -3, 4, 10}
Output: The median is 3.
Explanation: The merged array is: ar3[] = {-12, -10, -6, -5 , -3, 3, 4, 6, 10, 12, 15}.
So the median of the merged array is 3

Input: a[] = {2, 3, 5, 8}, b[] = {10, 12, 14, 16, 18, 20}
Output: The median is 11.
Explanation : The merged array is: ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
If the number of the elements are even. So there are two middle elements.
Take the average between the two: (10 + 12) / 2 = 11.


     */
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,4,5);
        List<Integer> b  = Arrays.asList(2,3);

        /*  Approach 1 :
            Merge these two sorted list and then find the Median of resultant List
            But that will Throw TLE
            Cause that solution will be

            Time Complexity: O((N + M) Log (N + M)), Time required to sort the array of size N + M
            Auxiliary Space: O(N + M), Creating a new array of size N+M.

            SO THIS WONT WORK
         */

        /*  Approach 2:
           So we know that....merging these two list ....will give us FINAL list let it be C
           and C will have some elements from list a and some list b

           Example:

           B = 1,2,3,4,5,6,7,8
           A = 1,2,3,4

           C = 1,1,2,2,3,3,4,4,5,6,7,8

           So if we look closely
           TotalLengthOfC = 12
           halfLengthOfC = 6

           Half length of C consist of some elements of A and some elements of B.

           SO WHAT IF WE CAN SOME HOW FIND==> which elements of A and B will come in first
                                              half of C and which in second half of C.

                  Logic of that :
                  Take the smaller length List
                  set its low = 0 and high = A.size() -1

                  find mid

                  Now as soon as we find mid, the List A itself got divided into two parts
                  Now we have to check weather this partition is CORRECT or NOT.

                  How ?
                  Now as we have already done the partition of List A, so we know the partition size of those part as well
                  , we will use that partition size to find , How should we divide the another List B

                  So back to mathematics :
                  TotalLengthOfC = 12
                  halfLengthOfC = 6
                           0  1  2  3
                  for A =  1  2  3  4
                           l         h
                               m
                  so first mid is at index 1 , and length of partition is 2.

                  and we know first half of C will have 6 element
                  so if we taking two element from A then
                  elements from B will be = 6 -2 =4
       (Important)      Ques :     NOW we have to check , IS 4 is VALID partition for list B.

                  till now,after 1st partition  both list look like this
                  // Assumption we are doing here is that, both left part of A and B ,will make left half of C
                  //    left      right
                  B :  1,2,3,4   5,6,7,8

                  A :  1,2       3,4

                let these pointer to point left of both lists
                 leftLowA= 1   , LeftHighA = 2
                 leftLowB = 1   , leftHighB = 4

                 rightLowA = 3 ,   rightHighA = 4
                 rightLowB = 5  ,  rightHighB = 8

             SOOO....... If 4 is valid partition , then

             leftHighB < rightLowA         ---  (1)
             leftHighA < rightLowB         ---  (2)
                  But eq 1 above is not satisfied

                  So this partition of A and B is not valid

                  So now we will move the
                  low = mid + 1
                  high = A.size()-1     for A

                            0  1  2  3
                  for A =  1  2  3  4
                                 l   h
                                 m

                 so now the parition of B will be at : 6 - 3 = 3

                 Visual representation :

                    //    left      right
                  B :  1,2,3      4,5,6,7,8

                  A :  1,2,3      4

                 let these pointer to point left of both lists
                 leftLowA= 1   , LeftHighA = 3
                 leftLowB = 1   , leftHighB = 3

                 rightLowA = 4 ,   rightHighA = 4
                 rightLowB = 4  ,  rightHighB = 8


             Now both the conditions are satisfied :
             leftHighB < rightLowA         ---  (1)
             leftHighA < rightLowB         ---  (2)
                  which means the partition is Correct

                  Now this means that both left part of A and B will make the left Half of C
                  anf both right part of A and B will make the right Half of C


                 Here comes the twist :

                 so now we know C length is even or odd

                 and FINALLY NOW  we will use the formula to find the median

                 How ?

                 for Even case : median is ((n\2) + (n\2 + 1))/2.0
                 so it means
                 one element will come from left part either from A or B
                 one element will come from right part either from A or B.

                 from left part :  whom so ever is the max of both A and B will come. cause arrays are sorted
                 from right part :  whom so ever is the min in bothA and B will come . cause arrays are sorted.


                 For odd case
                 on left part : whom so ever is the max of both A and B will come.


         */
        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(List<Integer> a, List<Integer> b ){
        int n = a.size();
        int m = b.size();
        if(n < m){
            return findMedianSortedArrays(b,a);
        }

        // The above code is just to ensure that List a size should be grater then List size b.
        // this above step is so valuable that it got me stuck for 3 days .FUCKKKK


        int totalLengthOfC = m+n+1;      //1 because index start from 0, to make it from 1;
        int halfLengthOfC = (totalLengthOfC)/2;

        int lowA = 0;
        int highA = a.size();      //// here you have to take the list which is of larger size. Which already been takecare above.

        while(lowA<=highA){
            int cut1 = lowA + (highA - lowA)/2;   // this mid is basically the cut of partition in list A
            int cut2 = halfLengthOfC - cut1;       // this cut is of partition in list B.
            // we need 4 pointers for comparison

             int l1 , l2, r1, r2;

             l1 = (cut1 == 0) ? Integer.MIN_VALUE : a.get(cut1 -1);
             l2 = (cut2 == 0) ? Integer.MIN_VALUE : b.get(cut2-1);
             r1 = (cut1 == n) ? Integer.MAX_VALUE : a.get(cut1);
             r2 = (cut2 == m) ? Integer.MAX_VALUE : b.get(cut2);

             if(l1 <= r2 && l2 <= r1){
                 int maxLeft = Math.max(l1,l2);
                 int minRight = Math.min(r1,r2);

                 if((m+n)%2==0){
                     return (double)(0.5 * (maxLeft + minRight));
                 }
                 return maxLeft;
             } else if (l1 > r2) {
                 highA = cut1 -1;
             }else{
                 lowA = cut1 + 1;
             }
        }
        return (double) 0.0;
    }
}
